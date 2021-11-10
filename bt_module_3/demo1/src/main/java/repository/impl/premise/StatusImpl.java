package repository.impl.premise;

import model.premise.Status;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusImpl {
    public static List<Status> selectAll(){

        List<Status> statusList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from status");) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Status status = new Status();
                status.setId(rs.getInt("id_status"));
                status.setName(rs.getString("name_status"));
                statusList.add(status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return statusList;
    }
}
