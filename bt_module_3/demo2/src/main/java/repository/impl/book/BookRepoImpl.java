package repository.impl.book;

import model.Book;
import model.Card;
import model.Status;
import model.Student;
import repository.ConnectionSQL;
import repository.BookRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepoImpl implements BookRepo {

    @Override

    public List<Book> selectAll() {
        List<Book> bookList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select id_book, name_book, actor, amount, description\n" +
                                "from book;");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_book");
                String name = rs.getString("name_book");
                String actor = rs.getString("actor");
                String amount = rs.getString("amount");
                String description = rs.getString("description");

                bookList.add(new Book(id, name, actor, amount, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return bookList;
    }

//    public List<Book> selectAll() {
//        List<Book> bookList = new ArrayList<>();
//        Connection connection = new ConnectionSQL().getConnection();
//        try (
//                PreparedStatement preparedStatement = connection.prepareStatement(
//                        "select id_premise, s.id_status,s.name_status, area, \n" +
//                                "floor, pr.id_premise_type, pr.name_premise_type, price,start_day, end_day\n" +
//                                "from premise p\n" +
//                                "join `status` s on s.id_status = p.id_status\n" +
//                                "join premise_type pr on p.id_premise_type = pr.id_premise_type;");) {
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String id = rs.getString("id_premise");
//
//                Status status = new Status();
//                status.setId(rs.getInt("id_status"));
//                status.setName(rs.getString("name_status"));
//
//                double area = Double.parseDouble(rs.getString("area"));
//                int floor = Integer.parseInt(rs.getString("floor"));
//
//                PremiseType premiseType = new BookType();
//                premiseType.setId(rs.getInt("id_premise_type"));
//                premiseType.setName(rs.getString("name_premise_type"));
//
//                int price = Integer.parseInt(rs.getString("price"));
//                String startDay = rs.getString("start_day");
//                String endDay = rs.getString("end_day");
//
//                premiseList.add(new Premise(id, status, area, floor, premiseType, price, startDay,endDay));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }finally {
//            ConnectionSQL.close();
//        }
//        return premiseList;
//    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public boolean delete(String id) throws SQLException {
        boolean rowDeleted;
//        try (Connection connection = new ConnectionSQL().getConnection();
//             PreparedStatement statement = connection.prepareStatement(
//                     " delete from premise where id_premise = ?;");) {
//            statement.setString(1, id);
//            rowDeleted = statement.executeUpdate() > 0;
//        }finally {
//            ConnectionSQL.close();
//        }
        return rowDeleted=true;
    }

    public void create(Card card) throws SQLException {
        try (Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert premise values " +
                    " (?,?,?,?,?,?,?,?);")) {
            String idCard;
            Book book;
            Student student;
            Status Status;
            String borrowDay;
            String returnDay;
            preparedStatement.setString(1, card.getIdCard());
            preparedStatement.setString(2, card.getBook().getId());
            preparedStatement.setString(3, card.getStudent().getId());
            preparedStatement.setString(4, card.getStatus().getId());
            preparedStatement.setString(5, card.getBorrowDay());
            preparedStatement.setString(6, card.getReturnDay());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
    }

    public Book findById(String id) {
        List<Book> bookList = selectAll();
        Book book = null;
        for (Book temp : bookList){
            if(temp.getId().equals(id)) {
                book = temp;
            }
        }
        return book;
    }

    public boolean update(Book premise) throws SQLException {
        boolean rowUpdated;
//        try (Connection connection = new ConnectionSQL().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(
//                     "update premise set id_status= ?, area=?, " +
//                     "floor=?,id_premise_type=?, price=?,start_day=?, end_day=? where id_premise = ?;");) {
//            preparedStatement.setInt(1, premise.getStatus().getId());
//            preparedStatement.setDouble(2, premise.getArea());
//            preparedStatement.setInt(3, premise.getFloor());
//            preparedStatement.setInt(4, premise.getPremiseType().getId());
//            preparedStatement.setInt(5, premise.getPrice());
//            preparedStatement.setString(6, premise.getStartDay());
//            preparedStatement.setString(7, premise.getEndDay());
//            preparedStatement.setString(8, premise.getId());
//            rowUpdated = preparedStatement.executeUpdate() > 0;
//        }finally {
//            ConnectionSQL.close();
//        }
        return rowUpdated =true;
    }

    @Override
    public List<Book> search(String name, String id, String email) throws SQLException {
        List<Book> employees = new ArrayList<>();
//
//        try (Connection connection = new ConnectionSQL().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement
//                     ("select id_employee, full_name, email, birthday, id_card, salary, number, \n" +
//                     " address,e.id_position,name_position, ed.id_education_degree, education_degree,di.id_division, \n" +
//                     " name_division from employee e join position d on e.id_position = d.id_position \n" +
//                     " join education_degree ed on ed.id_education_degree = e.id_education_degree\n" +
//                     " join division di on di.id_division = e.id_division\n" +
//                     " where `full_name` like concat('%',?,'%') and id_employee = ? \n" +
//                     " and email like concat('%',?,'%');")) {
//            preparedStatement.setString(1, nameInput);
//            preparedStatement.setString(2, idInput);
//            preparedStatement.setString(3, emailInput);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id_employee");
//                String name = rs.getString("full_name");
//                String birthday = rs.getString("birthday");
//                String id_card = rs.getString("id_card");
//                Double salary = rs.getDouble("salary");
//                String number = rs.getString("number");
//                String email = rs.getString("email");
//                String address = rs.getString("address");
//
//                Position position = new Position();
//                position.setId(rs.getInt("id_position"));
//                position.setName(rs.getString("name_position"));
//
//                EducationDegree educationDegree = new EducationDegree();
//                educationDegree.setId(rs.getInt("id_education_degree"));
//                educationDegree.setName(rs.getString("education_degree"));
//
//                Division division = new Division();
//                division.setId(rs.getInt("id_division"));
//                division.setName(rs.getString("name_division"));
//
//                employees.add(new Employee(id, name, birthday, id_card, salary, number, email,address,
//                        position, educationDegree, division));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }finally {
//            ConnectionSQL.close();
//        }
        return employees;
    }
}
