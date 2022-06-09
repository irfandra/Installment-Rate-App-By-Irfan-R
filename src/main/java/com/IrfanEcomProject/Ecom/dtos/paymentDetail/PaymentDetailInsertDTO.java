package com.IrfanEcomProject.Ecom.dtos.paymentDetail;

import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import lombok.Data;

@Data
public class PaymentDetailInsertDTO {
    private Integer installmentYear;
    private Double interestRate;

    public PaymentDetail toPaymentDetail() {
        return new PaymentDetail(installmentYear, interestRate);
    }
}
