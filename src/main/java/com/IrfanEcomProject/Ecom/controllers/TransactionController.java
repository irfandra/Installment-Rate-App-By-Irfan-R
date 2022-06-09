package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.transaction.TransactionInsertDTO;
import com.IrfanEcomProject.Ecom.models.Transaction;
import com.IrfanEcomProject.Ecom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TransactionHeaderDTO> getAllTransaction() {
        return transactionService.findAllTransaction();
    }
    @PostMapping("insert")
    public String insertTransaction(@RequestBody TransactionInsertDTO transactionInsertDTO) {
        transactionService.insertTransaction(transactionInsertDTO);
        return "Inserted";
    }
    @DeleteMapping("delete")
    public String deleteTransaction(@RequestParam(value = "id") String id) {
        transactionService.deleteTransaction(id);
        return "Deleted";
    }

}
