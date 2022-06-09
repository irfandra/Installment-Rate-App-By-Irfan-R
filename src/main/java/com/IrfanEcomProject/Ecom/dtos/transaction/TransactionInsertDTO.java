package com.IrfanEcomProject.Ecom.dtos.transaction;

import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import com.IrfanEcomProject.Ecom.models.Product;
import com.IrfanEcomProject.Ecom.models.Transaction;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class TransactionInsertDTO {
    private Integer customerId;
    private Integer paymentId;
    private String productName;
    private String downPayment;
    private String monthlyPayment;
    private String totalFirstPayment;
    private String totalPrice;

    public Transaction convert(Transaction transactionId, Product product, PaymentDetail paymentDetail) {
        return new Transaction(customTicket(transactionId), customerId, paymentId, productName, calculateDownPayment(product)
                , calculateMonthlyPayment(product, paymentDetail),calculateTotalFirstPayment(), calculateTotalPrice(product));
    }

    private String customTicket(Transaction transactionId) {
        int num = 0;
        int year = LocalDate.now().getYear();// --> 2022
        String month = LocalDate.now().getMonth().toString();// --> June
        int increment = (num + 1);//

        if (transactionId == null) {//"TRX/2022/JUNE/1"
            return "TRX" + "/" + year + "/" + month + "/" + increment;
        } else {

            increment = Integer.parseInt(transactionId.getId().substring(14)) + 1;
            return "TRX" + "/" + year + "/" + month + "/" + increment;
        }
    }

    private String calculateDownPayment(Product productPrice) {
        double percent = 0.15;
        BigDecimal price = productPrice.getPrice();
        downPayment = percent * price.doubleValue() + "";
        return downPayment;
    }

    private String calculateMonthlyPayment(Product productPrice, PaymentDetail installmentYear) {
        int cicilan = installmentYear.getInstallmentYear() * 12;
        double rate = installmentYear.getInterestRate();
        var price = ((productPrice.getPrice().doubleValue() - Double.parseDouble(downPayment))) / cicilan;
        var totalRate = ((productPrice.getPrice().doubleValue() - Double.parseDouble(downPayment)) * rate) / cicilan;
        var monthlyPayment1 = totalRate + price;
        monthlyPayment = monthlyPayment1 + "";
        return monthlyPayment;
    }

    private String calculateTotalFirstPayment() {
        return Double.parseDouble(downPayment) + Double.parseDouble(monthlyPayment) + "";
    }

    private String calculateTotalPrice(Product productPrice) {
        totalPrice = productPrice.getPrice().doubleValue() + "";
        return totalPrice;
    }

}
