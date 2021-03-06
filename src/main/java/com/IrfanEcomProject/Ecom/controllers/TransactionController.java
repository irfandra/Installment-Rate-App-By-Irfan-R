package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionCustomerDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionInsertDTO;
import com.IrfanEcomProject.Ecom.service.TransactionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    private TransactionServiceImplementation transactionServiceImplementation;
    @Autowired
    public TransactionController(TransactionServiceImplementation transactionServiceImplementation) {
        this.transactionServiceImplementation = transactionServiceImplementation;
    }
    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<TransactionHeaderDTO>>> getAllTransaction() {
        return new ResponseEntity<>(
                new RestResponse<>(transactionServiceImplementation.findAllTransaction(),
                        "Transaction Find Success",
                        200),
                HttpStatus.OK);
    }
    @GetMapping("get-by-full-name")
    public ResponseEntity<RestResponse<List<TransactionCustomerDTO>>> getTransactionByFullName(@RequestParam String fullName) {
        return new ResponseEntity<>(
                new RestResponse<>(transactionServiceImplementation.findTransactionByFullName(fullName),
                        "Transaction Find Success",
                        200),
                HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertTransaction(@RequestBody TransactionInsertDTO transactionInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(transactionServiceImplementation.insertTransaction(transactionInsertDTO),
                        "Transaction Insert Success",
                        201),
                HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<RestResponse<Boolean>> deleteTransaction(@RequestParam String transactionId) {
        return new ResponseEntity<>(
                new RestResponse<>(transactionServiceImplementation.deleteTransaction(transactionId),
                        "Transaction Delete Success",
                        200),
                HttpStatus.OK);
    }
}
