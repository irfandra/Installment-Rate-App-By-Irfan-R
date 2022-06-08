package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = """
            select * from Customer
            """, nativeQuery = true)
    List<Customer> getAllCustomer();

}
