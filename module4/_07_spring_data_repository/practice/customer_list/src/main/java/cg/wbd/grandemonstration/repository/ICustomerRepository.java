package cg.wbd.grandemonstration.repository;


import cg.wbd.grandemonstration.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository{
}
