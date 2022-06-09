package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.RestResponse;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;
import com.IrfanEcomProject.Ecom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("get-all")
    public ResponseEntity<RestResponse<List<CustomerHeaderDTO>>> getAllCustomer() {
        return new ResponseEntity<>(
                new RestResponse<>(customerService.findAllCustomer(),
                        "Customer Find Success",
                        200),
                HttpStatus.OK);
    }
    @PostMapping("insert")
    public ResponseEntity<RestResponse<Boolean>> insertCustomer(@RequestBody CustomerInsertDTO customerInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(customerService.insertCustomer(customerInsertDTO),
                        "Customer Insert Success",
                        201),
                HttpStatus.CREATED);
    }
    @DeleteMapping("by-integer/{customerId}")
    public ResponseEntity<RestResponse<Boolean>> deleteCustomerByInteger(@PathVariable("customerId") Integer customerId) {
        return new ResponseEntity<>(
                new RestResponse<>(customerService.deleteCandidateById(customerId),
                        "Customer Delete Success",
                        200),
                HttpStatus.OK);
    }
    @PutMapping("{customerId}")
    public ResponseEntity<RestResponse<Boolean>> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody CustomerInsertDTO customerInsertDTO) {
        return new ResponseEntity<>(
                new RestResponse<>(customerService.updateCustomer(customerId, customerInsertDTO),
                        "Customer Update Success",
                        200),
                HttpStatus.OK);
    }
}
