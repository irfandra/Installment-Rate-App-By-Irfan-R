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

import java.util.List;

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
        return TransactionHeaderDTO.toList(transactionRepository.findAll());
    }

    public void insertTransaction(TransactionInsertDTO transactionInsertDTO) {
        Transaction initialTicket = transactionRepository.getInitialTransactionId();
        Product product = productRepository.findIdByProductName(transactionInsertDTO.getProductName());
        PaymentDetail paymentDetail = paymentDetailRepository.findIdByPaymentType(transactionInsertDTO.getPaymentId());
        Transaction transaction = transactionInsertDTO.convert(initialTicket, product,paymentDetail);
        if(product.getUnitInStock()==0){
            throw new RuntimeException("Product is out of stock");
        }
        product.setUnitInStock(product.getUnitInStock() - 1);
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        Transaction transaction = transactionRepository.findById(id).get();
        Product product = productRepository.findIdByProductName(transaction.getProductName().getId());
        product.setUnitInStock(product.getUnitInStock() + 1);
        transactionRepository.deleteById(id);
    }
}
