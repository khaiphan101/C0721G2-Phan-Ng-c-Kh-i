//package com.example.furama_resort.repository.impl.employee;
//
//import model.employee.Division;
//import repository.ConnectionSQL;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DivisionImpl {
//
//    public static List<Division> selectAll(){
//
//        List<Division> divisions = new ArrayList<>();
//        Connection connection = new ConnectionSQL().getConnection();
//        try (
//                PreparedStatement preparedStatement = connection.prepareStatement(
//                        "select * from division");) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                Division division = new Division();
//                division.setId(rs.getInt("id_division"));
//                division.setName(rs.getString("name_division"));
//                divisions.add(division);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            ConnectionSQL.close();
//        }
//        return divisions;
//    }
//}
