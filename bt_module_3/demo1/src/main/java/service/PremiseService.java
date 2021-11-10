package service;

import model.premise.Premise;

import java.sql.SQLException;
import java.util.List;

public interface PremiseService {
    public void create(Premise premise) throws SQLException;

    public List<Premise> selectAll();

    public boolean delete(String id) throws SQLException;

//    public List<Premise> search(String name, String id, String email) throws SQLException;

    public Premise findById(String id);
    public boolean update(Premise premise) throws SQLException;
}
