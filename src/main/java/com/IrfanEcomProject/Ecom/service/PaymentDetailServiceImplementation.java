package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailInsertDTO;
import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import com.IrfanEcomProject.Ecom.repositories.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PaymentDetailServiceImplementation implements PaymentDetailService {

    private PaymentDetailRepository paymentDetailRepository;
    @Autowired
    public PaymentDetailServiceImplementation(PaymentDetailRepository paymentDetailRepository) {
        this.paymentDetailRepository = paymentDetailRepository;
    }
    @Override
    public List<PaymentDetailHeaderDTO> findAllPaymentDetail(){
        return PaymentDetailHeaderDTO.toList(paymentDetailRepository.findAll());
    }
    @Override
    public boolean insertPaymentDetail(PaymentDetailInsertDTO paymentDetailInsertDTO){
        paymentDetailRepository.save(paymentDetailInsertDTO.toPaymentDetail());
        return true;
    }
    @Override
    public boolean deleteAllPaymentDetailById(Integer paymentDetailId) {
        PaymentDetail checkId = paymentDetailRepository.findById(paymentDetailId)
                .orElseThrow(() -> new EntityNotFoundException("Payment Detail "+ paymentDetailId +" Not Found"));;
        paymentDetailRepository.deleteById(checkId.getId());
        return true;
    }
    @Override
    public boolean updatePaymentDetail(Integer paymentDetailId, PaymentDetailInsertDTO paymentDetailUpdate) {
        PaymentDetail paymentDetail = paymentDetailRepository.findById(paymentDetailId)
                        .orElseThrow(() -> new EntityNotFoundException("Payment Detail "+ paymentDetailId +" Not Found"));;
        paymentDetail.setInstallmentYear(paymentDetailUpdate.getInstallmentYear()==null?paymentDetail.getInstallmentYear():paymentDetailUpdate.getInstallmentYear());
        paymentDetail.setInterestRate(paymentDetailUpdate.getInterestRate()==null?paymentDetail.getInterestRate():paymentDetailUpdate.getInterestRate());
        paymentDetailRepository.save(paymentDetail);
        return true;
    }
}
