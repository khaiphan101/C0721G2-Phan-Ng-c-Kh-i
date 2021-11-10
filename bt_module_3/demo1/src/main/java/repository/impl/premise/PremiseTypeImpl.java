package repository.impl.premise;

import model.premise.PremiseType;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PremiseTypeImpl {
    public static List<PremiseType> selectAll(){

        List<PremiseType> divisions = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from premise_type");) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                PremiseType premiseType = new PremiseType();
                premiseType.setId(rs.getInt("id_premise_type"));
                premiseType.setName(rs.getString("name_premise_type"));
                divisions.add(premiseType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return divisions;
    }
}
