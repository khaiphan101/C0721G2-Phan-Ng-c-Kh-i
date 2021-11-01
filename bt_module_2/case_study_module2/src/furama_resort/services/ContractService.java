package furama_resort.services;

import furama_resort.models.Contract;
import java.util.Queue;

public interface ContractService extends Service{
    void edit(int idContract);
    Queue<Contract> readFile(String filePath);
    void writeFile(Contract contract, String filePath);
}
