package repository.impl.book;

import model.Student;
import repository.ConnectionSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl {
    public static List<Student> selectAll(){

        List<Student> studentList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from student");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("id_student"));
                student.setName(rs.getString("name_student"));
                student.setClassName(rs.getString("class"));
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionSQL.close();
        }
        return studentList;
    }
}
