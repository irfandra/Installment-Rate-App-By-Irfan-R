package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.paymentDetail.PaymentDetailInsertDTO;
import com.IrfanEcomProject.Ecom.service.PaymentDetailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paymentDetail")
public class PaymentDetailController {
    private PaymentDetailServiceImplementation paymentDetailServiceImplementation;
    @Autowired
    public PaymentDetailController(PaymentDetailServiceImplementation paymentDetailServiceImplementation) {
        this.paymentDetailServiceImplementation = paymentDetailServiceImplementation;
    }
    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<PaymentDetailHeaderDTO>>> getAllPaymentDetail() {
        return new ResponseEntity<>(
                new RestResponse<>(paymentDetailServiceImplementation.findAllPaymentDetail(),
                        "PaymentDetail Find Success",
                        200),
                HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertPaymentDetail(@RequestBody PaymentDetailInsertDTO paymentDetailInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(paymentDetailServiceImplementation.insertPaymentDetail(paymentDetailInsertDTO),
                        "PaymentDetail Insert Success",
                        201),
                HttpStatus.CREATED);
    }
    @DeleteMapping("by-integer/{paymentDetailId}")
    public ResponseEntity<RestResponse<Boolean>> deletePaymentDetailByInteger(@PathVariable("paymentDetailId") Integer paymentDetailId) {
        return new ResponseEntity<>(
                new RestResponse<>(paymentDetailServiceImplementation.deleteAllPaymentDetailById(paymentDetailId),
                        "PaymentDetail Delete Success",
                        200),
                HttpStatus.OK);
    }
    @PutMapping("{paymentDetailId}")
    public ResponseEntity<RestResponse<Boolean>> updatePaymentDetail(@PathVariable("paymentDetailId") Integer paymentDetailId, @RequestBody PaymentDetailInsertDTO paymentDetailInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(paymentDetailServiceImplementation.updatePaymentDetail(paymentDetailId, paymentDetailInsertDTO),
                        "PaymentDetail Update Success",
                        200),
                HttpStatus.OK);
    }
}
