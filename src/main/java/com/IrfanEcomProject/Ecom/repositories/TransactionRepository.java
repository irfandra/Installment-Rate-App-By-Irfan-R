package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,String> {

    @Query(value = """
            SELECT * FROM Transaction 
            """,nativeQuery = true)
    List<Transaction> getAllTransaction();

    @Query(value = """
            select TOP 1 * from [Transaction] order by TransactionId desc
            """, nativeQuery = true)
    Transaction getInitialTransactionId();
}
