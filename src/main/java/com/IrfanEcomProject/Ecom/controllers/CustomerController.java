package com.IrfanEcomProject.Ecom.controllers;

import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;
import com.IrfanEcomProject.Ecom.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CustomerHeaderDTO> findAllCustomer(){
        return customerService.findAllCustomer();
    }
    @PostMapping("insert")
    public boolean insertCustomer(@RequestBody CustomerInsertDTO customerInsertDTO){
        return customerService.insertCustomer(customerInsertDTO);
    }
    @DeleteMapping("by-integer/{customerId}")
    public String deleteAllCustomerByStringId(@PathVariable Integer customerId){
        return customerService.deleteCandidateById(customerId);
    }
    @PutMapping("{customerId}")
    public boolean updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerInsertDTO customerUpdate){
        return customerService.updateCustomer(customerId, customerUpdate);
    }
}
