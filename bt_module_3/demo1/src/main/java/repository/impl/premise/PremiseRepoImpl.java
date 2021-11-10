package repository.impl.premise;

import model.premise.Premise;
import model.premise.PremiseType;
import model.premise.Status;
import repository.ConnectionSQL;
import repository.PremiseRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PremiseRepoImpl implements PremiseRepo {

    @Override
    public List<Premise> selectAll() {
        List<Premise> premiseList = new ArrayList<>();
        Connection connection = new ConnectionSQL().getConnection();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select id_premise, s.id_status,s.name_status, area, \n" +
                                "floor, pr.id_premise_type, pr.name_premise_type, price,start_day, end_day\n" +
                                "from premise p\n" +
                                "join `status` s on s.id_status = p.id_status\n" +
                                "join premise_type pr on p.id_premise_type = pr.id_premise_type;");) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_premise");

                Status status = new Status();
                status.setId(rs.getInt("id_status"));
                status.setName(rs.getString("name_status"));

                double area = Double.parseDouble(rs.getString("area"));
                int floor = Integer.parseInt(rs.getString("floor"));

                PremiseType premiseType = new PremiseType();
                premiseType.setId(rs.getInt("id_premise_type"));
                premiseType.setName(rs.getString("name_premise_type"));

                int price = Integer.parseInt(rs.getString("price"));
                String startDay = rs.getString("start_day");
                String endDay = rs.getString("end_day");

                premiseList.add(new Premise(id, status, area, floor, premiseType, price, startDay,endDay));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
        return premiseList;
    }

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
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     " delete from premise where id_premise = ?;");) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowDeleted;
    }

    public void create(Premise premise) throws SQLException {
        try (Connection connection = new ConnectionSQL().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert premise values " +
                    " (?,?,?,?,?,?,?,?);")) {
            preparedStatement.setString(1, premise.getId());
            preparedStatement.setInt(2, premise.getStatus().getId());
            preparedStatement.setDouble(3, premise.getArea());
            preparedStatement.setInt(4, premise.getFloor());
            preparedStatement.setDouble(5, premise.getPremiseType().getId());
            preparedStatement.setInt(6, premise.getPrice());
            preparedStatement.setString(7, premise.getStartDay());
            preparedStatement.setString(8, premise.getEndDay());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }finally {
            ConnectionSQL.close();
        }
    }

    public Premise findById(String id) {
        List<Premise> employees = selectAll();
        Premise premise = null;
        for (Premise temp : employees){
            if(temp.getId().equals(id)) {
                premise = temp;
            }
        }
        return premise;
    }

    public boolean update(Premise premise) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = new ConnectionSQL().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "update premise set id_status= ?, area=?, " +
                     "floor=?,id_premise_type=?, price=?,start_day=?, end_day=? where id_premise = ?;");) {
            preparedStatement.setInt(1, premise.getStatus().getId());
            preparedStatement.setDouble(2, premise.getArea());
            preparedStatement.setInt(3, premise.getFloor());
            preparedStatement.setInt(4, premise.getPremiseType().getId());
            preparedStatement.setInt(5, premise.getPrice());
            preparedStatement.setString(6, premise.getStartDay());
            preparedStatement.setString(7, premise.getEndDay());
            preparedStatement.setString(8, premise.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }finally {
            ConnectionSQL.close();
        }
        return rowUpdated;
    }
}
