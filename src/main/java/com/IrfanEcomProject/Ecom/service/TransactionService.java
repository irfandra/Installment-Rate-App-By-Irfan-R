package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionInsertDTO;
import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import com.IrfanEcomProject.Ecom.models.Product;
import com.IrfanEcomProject.Ecom.models.Transaction;
import com.IrfanEcomProject.Ecom.repositories.PaymentDetailRepository;
import com.IrfanEcomProject.Ecom.repositories.ProductRepository;
import com.IrfanEcomProject.Ecom.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ProductRepository productRepository,
                              PaymentDetailRepository paymentDetailRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.paymentDetailRepository = paymentDetailRepository;
    }
    public List<TransactionHeaderDTO> findAllTransaction() {
        if(transactionRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("No Transaction Found");
        }
        return TransactionHeaderDTO.toList(transactionRepository.findAll());
    }

    public boolean insertTransaction(TransactionInsertDTO transactionInsertDTO) {
        Transaction initialTicket = transactionRepository.getInitialTransactionId();
        Product product = productRepository.findIdByProductName(transactionInsertDTO.getProductName());
        if(product == null) {
            throw new EntityNotFoundException("Product "+ transactionInsertDTO.getProductName() + " Not Found");
        }
        PaymentDetail paymentDetail = paymentDetailRepository.findIdByPaymentType(transactionInsertDTO.getPaymentId());
        if(paymentDetail == null) {
            throw new EntityNotFoundException("Payment Detail" + transactionInsertDTO.getPaymentId() +" Not Found");
        }
        Transaction transaction = transactionInsertDTO.convert(initialTicket, product,paymentDetail);
        if(product.getUnitInStock()==0){
            throw new RuntimeException("Product is out of stock");
        }
        product.setUnitInStock(product.getUnitInStock() - 1);
        transactionRepository.save(transaction);
        return true;
    }

    public boolean deleteTransaction(String transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction "+ transactionId +" Not Found"));
        Product product = productRepository.findIdByProductName(transaction.getProductName().getId());
        product.setUnitInStock(product.getUnitInStock() + 1);
        transactionRepository.deleteById(transactionId);
        return true;
    }
}
