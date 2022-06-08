package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailInsertDTO;
import com.IrfanEcomProject.Ecom.service.PaymentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paymentDetail")
public class PaymentDetailController {
    private PaymentDetailService paymentDetailService;
    @Autowired
    public PaymentDetailController(PaymentDetailService paymentDetailService) {
        this.paymentDetailService = paymentDetailService;
    }
    @GetMapping("get-all")
    public List<PaymentDetailHeaderDTO> findAllPaymentDetail(){
        return paymentDetailService.findAllPaymentDetail();
    }

    @PostMapping("insert")
    public boolean insertPaymentDetail(@RequestBody PaymentDetailInsertDTO paymentDetailInsertDTO){
        return paymentDetailService.insertPaymentDetail(paymentDetailInsertDTO);
    }
    @DeleteMapping("by-integer/{paymentDetailId}")
    public String deleteAllPaymentDetailByStringId(@PathVariable Integer paymentDetailId){
        return paymentDetailService.deleteAllPaymentDetailById(paymentDetailId);
    }
    @PutMapping("{paymentDetailId}")
    public boolean updatePaymentDetail(@PathVariable Integer paymentDetailId, @RequestBody PaymentDetailInsertDTO paymentDetailUpdate){
        return paymentDetailService.updatePaymentDetail(paymentDetailId, paymentDetailUpdate);
    }
}
