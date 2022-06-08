package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailInsertDTO;
import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import com.IrfanEcomProject.Ecom.repositories.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDetailService {
    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    public PaymentDetailService(PaymentDetailRepository paymentDetailRepository) {
        this.paymentDetailRepository = paymentDetailRepository;
    }

    public List<PaymentDetailHeaderDTO> findAllPaymentDetail(){
        return PaymentDetailHeaderDTO.toList(paymentDetailRepository.findAll());
    }
    public boolean insertPaymentDetail(PaymentDetailInsertDTO paymentDetailInsertDTO){
        paymentDetailRepository.save(paymentDetailInsertDTO.toPaymentDetail());
        return true;
    }

    public String deleteAllPaymentDetailById(Integer paymentDetailId) {
        paymentDetailRepository.deleteById(paymentDetailId);
        return "Deleted";
    }

    public boolean updatePaymentDetail(Integer paymentDetailId, PaymentDetailInsertDTO paymentDetailUpdate) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(paymentDetailId).get();
        paymentDetail.setInstallmentYear(paymentDetailUpdate.getInstallmentYear()==null?paymentDetail.getInstallmentYear():paymentDetailUpdate.getInstallmentYear());
        paymentDetail.setInterestRate(paymentDetailUpdate.getInterestRate()==null?paymentDetail.getInterestRate():paymentDetailUpdate.getInterestRate());
        paymentDetailRepository.save(paymentDetail);
        return true;
    }
}