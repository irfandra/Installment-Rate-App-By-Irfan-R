package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionCustomerDTO;
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
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImplementation implements TransactionService {
    private TransactionRepository transactionRepository;
    private ProductRepository productRepository;
    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    public TransactionServiceImplementation(TransactionRepository transactionRepository, ProductRepository productRepository,
                                            PaymentDetailRepository paymentDetailRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
        this.paymentDetailRepository = paymentDetailRepository;
    }

    @Override
    public List<TransactionHeaderDTO> findAllTransaction() {
        if (transactionRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("No Transaction Found");
        }
        return TransactionHeaderDTO.toList(transactionRepository.findAll());
    }

    @Override
    public List<TransactionCustomerDTO> findTransactionByFullName(String fullName) {
        if (transactionRepository.findTransactionByFullName(fullName).isEmpty()) {
            throw new EntityNotFoundException("No Transaction Found for " + fullName);
        }
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        List<Transaction> transactionList = transactionRepository.findTransactionByFullName(fullName);
        List<TransactionCustomerDTO> transactionCustomerDTOs = transactionList.stream()

                .map(transaction -> new TransactionCustomerDTO(
                        transaction.getCustomer().getFirstName() + " " + transaction.getCustomer().getLastName(),
                        transaction.getCustomer().getPhone(),
                        transaction.getProductName().getId(),
                        currencyFormatter.format(transaction.getDownPayment()),
                        currencyFormatter.format(transaction.getMonthlyPayment()),
                        currencyFormatter.format(transaction.getTotalFirstPayment()),
                        currencyFormatter.format(transaction.getTotalPrice())))
                .collect(Collectors.toList());
        return transactionCustomerDTOs;
    }

    @Override
    public boolean insertTransaction(TransactionInsertDTO transactionInsertDTO) {
        Transaction initialTicket = transactionRepository.getInitialTransactionId();
        Product product = productRepository.findIdByProductName(transactionInsertDTO.getProductName());
        if (product == null) {
            throw new EntityNotFoundException("Product " + transactionInsertDTO.getProductName() + " Not Found");
        }
        PaymentDetail paymentDetail = paymentDetailRepository.findIdByPaymentType(transactionInsertDTO.getPaymentId());
        if (paymentDetail == null) {
            throw new EntityNotFoundException("Payment Detail" + transactionInsertDTO.getPaymentId() + " Not Found");
        }
        Transaction transaction = transactionInsertDTO.convert(initialTicket, product, paymentDetail);
        if (product.getUnitInStock() == 0) {
            throw new RuntimeException("Product is out of stock");
        }
        product.setUnitInStock(product.getUnitInStock() - 1);
        transactionRepository.save(transaction);
        return true;
    }

    @Override
    public boolean deleteTransaction(String transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new EntityNotFoundException("Transaction " + transactionId + " Not Found"));
        Product product = productRepository.findIdByProductName(transaction.getProductName().getId());
        product.setUnitInStock(product.getUnitInStock() + 1);
        transactionRepository.deleteById(transactionId);
        return true;
    }
}
