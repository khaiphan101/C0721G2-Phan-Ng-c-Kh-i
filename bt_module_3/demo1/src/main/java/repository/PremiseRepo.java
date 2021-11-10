package repository;

import model.premise.Premise;

import java.sql.SQLException;
import java.util.List;

public interface PremiseRepo {
    public List<Premise> selectAll();
    public boolean delete(String id) throws SQLException;
    public void create(Premise premise) throws SQLException;
    public Premise findById(String id);
    public boolean update(Premise premise) throws SQLException;
}
