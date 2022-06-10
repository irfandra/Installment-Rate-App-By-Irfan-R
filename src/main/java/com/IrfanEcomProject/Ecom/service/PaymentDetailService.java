package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailInsertDTO;

import java.util.List;

public interface PaymentDetailService  {
    List<PaymentDetailHeaderDTO> findAllPaymentDetail();
    boolean insertPaymentDetail(PaymentDetailInsertDTO paymentDetailInsertDTO);
    boolean deleteAllPaymentDetailById(Integer paymentDetailId);
    boolean updatePaymentDetail(Integer paymentDetailId, PaymentDetailInsertDTO paymentDetailUpdate);


}
