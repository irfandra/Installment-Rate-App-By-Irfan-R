package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionInsertDTO;
import com.IrfanEcomProject.Ecom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<TransactionHeaderDTO>>> getAllTransaction() {
        return new ResponseEntity<>(
                new RestResponse<>(transactionService.findAllTransaction(),
                        "Transaction Find Success",
                        200),
                HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertTransaction(@RequestBody TransactionInsertDTO transactionInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(transactionService.insertTransaction(transactionInsertDTO),
                        "Transaction Insert Success",
                        201),
                HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<RestResponse<Boolean>> deleteTransaction(@RequestParam String transactionId) {
        return new ResponseEntity<>(
                new RestResponse<>(transactionService.deleteTransaction(transactionId),
                        "Transaction Delete Success",
                        200),
                HttpStatus.OK);
    }
}
