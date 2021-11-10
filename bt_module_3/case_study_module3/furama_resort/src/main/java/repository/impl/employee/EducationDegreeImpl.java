package repository.impl.employee;
import model.employee.EducationDegree;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeImpl {

    public static List<EducationDegree> selectAll(){

        List<EducationDegree> educationDegrees = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from education_degree");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                EducationDegree educationDegree = new EducationDegree();
                educationDegree.setId(rs.getInt("id_education_degree"));
                educationDegree.setName(rs.getString("education_degree"));
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return educationDegrees;
    }
}
