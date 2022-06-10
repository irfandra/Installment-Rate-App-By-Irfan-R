package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionCustomerDTO;
import com.IrfanEcomProject.Ecom.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = """
            SELECT * FROM Transaction 
            """, nativeQuery = true)
    List<Transaction> getAllTransaction();

    @Query(value = """
            select TOP 1 * from [Transaction] order by TransactionId desc
            """, nativeQuery = true)
    Transaction getInitialTransactionId();

    @Query(value = """
            select t.TransactionId,c.CustomerId,t.PaymentId, CONCAT(c.FirstName,' ', c.LastName) as FullName,c.Phone, t.ProductName,
            t.DownPayment,t.MonthlyPayment,t.TotalFirstPayment,t.TotalPrice from [Transaction] t
            join Customer c on t.CustomerId = c.CustomerId
            where CONCAT(c.FirstName,' ', c.LastName) Like %:fullName%
            """, nativeQuery = true)
    List<Transaction> findTransactionByFullName(@Param("fullName") String fullName);
}
