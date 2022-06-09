package com.IrfanEcomProject.Ecom.dtos.paymentDetail;

import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaymentDetailHeaderDTO {
    private final Integer paymentId;
    private final Integer installmentYear;
    private final String interestRate;

    public static PaymentDetailHeaderDTO set(PaymentDetail paymentDetail) {
        return new PaymentDetailHeaderDTO(
                paymentDetail.getId(),
                paymentDetail.getInstallmentYear(),
                paymentDetail.getInterestRate()*100 + "%");
    }

    public static List<PaymentDetailHeaderDTO> toList(List<PaymentDetail> paymentDetails){
        List<PaymentDetailHeaderDTO> result = new ArrayList<>();
        for (PaymentDetail e: paymentDetails
        ) {
            result.add(set(e));
        }
        return result;
    }

}
