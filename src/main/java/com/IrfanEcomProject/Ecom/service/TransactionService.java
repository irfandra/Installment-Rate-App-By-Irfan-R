package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionCustomerDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionInsertDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionHeaderDTO> findAllTransaction();
    List<TransactionCustomerDTO> findTransactionByFullName(String fullName);
    boolean insertTransaction(TransactionInsertDTO transactionInsertDTO);
    boolean deleteTransaction(String transactionId);

}
