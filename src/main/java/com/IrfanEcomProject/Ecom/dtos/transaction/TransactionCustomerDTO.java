package com.IrfanEcomProject.Ecom.dtos.transaction;

import com.IrfanEcomProject.Ecom.models.Transaction;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;

@Data
public class TransactionCustomerDTO {
    private final String fullName;
    private final String phone;
    private final String productName;
    private final String downPayment;
    private final String monthlyPayment;
    private final String totalFirstPayment;
    private final String totalPrice;

}
