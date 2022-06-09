package com.IrfanEcomProject.Ecom.dtos.transaction;

import com.IrfanEcomProject.Ecom.models.Transaction;
import lombok.Data;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
public class TransactionHeaderDTO {
    private final String id;
    private final Integer customerId;
    private final Integer paymentId;
    private final String productName;
    private final String downPayment;
    private final String monthlyPayment;
    private final String totalFirstPayment;
    private final String totalPrice;


    public static TransactionHeaderDTO set(Transaction transaction) {
        Locale locale = new Locale("id", "ID");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return new TransactionHeaderDTO(transaction.getId(),
                transaction.getCustomer().getId(),
                transaction.getPayment().getId(),
                transaction.getProductName().getId(),
                currencyFormatter.format(transaction.getDownPayment()),
                currencyFormatter.format(transaction.getMonthlyPayment()),
                currencyFormatter.format(transaction.getTotalFirstPayment()),
                currencyFormatter.format(transaction.getTotalPrice()));
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
