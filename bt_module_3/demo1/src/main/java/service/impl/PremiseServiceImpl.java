package service.impl;

import model.premise.Premise;
import repository.PremiseRepo;
import repository.impl.premise.PremiseRepoImpl;
import service.PremiseService;

import java.sql.SQLException;
import java.util.List;

public class PremiseServiceImpl implements PremiseService {
    private PremiseRepo premiseRepo = new PremiseRepoImpl();
    @Override
    public List<Premise> selectAll() {
        return premiseRepo.selectAll();
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return premiseRepo.delete(id);
    }

    @Override
    public void create(Premise premise) throws SQLException {
        premiseRepo.create(premise);
    }
        public Premise findById(String id){
        return premiseRepo.findById(id);
    }

    @Override
    public boolean update(Premise premise) throws SQLException {
        return premiseRepo.update(premise);
    }

}
