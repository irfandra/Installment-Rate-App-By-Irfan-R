package com.IrfanEcomProject.Ecom.dtos.transaction;

import com.IrfanEcomProject.Ecom.models.Transaction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionHeaderDTO {
    private final String id;
    private final Integer customerId;
    private final Integer paymentId;
    private final String productName;


    public static TransactionHeaderDTO set(Transaction transaction) {
        return new TransactionHeaderDTO(transaction.getId(),
                transaction.getCustomer().getId(),
                transaction.getPayment().getId(),
                transaction.getProductName().getId());
    }

    public static List<TransactionHeaderDTO> toList(List<Transaction> transactions) {
        List<TransactionHeaderDTO> result = new ArrayList<>();
        for (Transaction t : transactions
        ) {
            result.add(set(t));
        }
        return result;
    }
}
