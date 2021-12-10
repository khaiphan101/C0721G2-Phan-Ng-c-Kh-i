package com.example.furama_resort.repository.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findAllByCustomerTypeId(int id);

//    List<Customer> findAllByNameContaining(String name);

    List<Customer> findAllCustomerByNameContaining(String name);

//    @Query(value = "select * from customer c join customer_type t where c.customer_type_id = t.id and t.id = :id", nativeQuery = true)
//    List<Customer> findAllCustomerByCustomerTypeId(int id);

//    @Query(value = "select * from customer c join customer_type t where c.customer_type_id = t.id and t.id = :customerTypeId", nativeQuery = true)
//    List<Customer> findAllByCsutomerType(@Param("customerTypeId") int customerTypeId);
//
//    @Query(value = "select * \n" +
//            " from customer c\n" +
//            " where c.name like concat('%',:keyword, '%')", nativeQuery = true)
//    List<Customer> search(@Param("keyword")String keyword);

    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    @Query(value = "select * from customer c join customer_type t where c.customer_type_id = t.id and t.id = :id", nativeQuery = true)
    Page<Customer> findCustomersByCustomerType(@Param("id") Integer id, Pageable pageable);

//    @Query(value="select * from customer where match(customer_name,customer_id_card,customer_email,customer_phone,customer_address) against (?1)", nativeQuery=true)
    @Query(value = "select * \n" +
            " from customer c\n" +
            " where c.name like concat('%',:keyword, '%')", nativeQuery = true)
    Page<Customer> search(String keyword,Pageable pageable);


}
