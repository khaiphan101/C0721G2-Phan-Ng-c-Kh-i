package repository.impl.employee;

import model.employee.Position;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionImpl {
    public static List<Position> selectAll(){

        List<Position> positions = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from `position`");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Position position = new Position();
                position.setName(rs.getString("id_position"));
                position.setName(rs.getString("name_position"));
                positions.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return positions;
    }
}
