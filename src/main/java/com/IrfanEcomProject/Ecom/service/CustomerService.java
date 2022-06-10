package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerHeaderDTO> findAllCustomer();
    boolean insertCustomer(CustomerInsertDTO customerInsertDTO);
    boolean deleteCustomerById(Integer customerId);
    boolean updateCustomer(Integer customerId, CustomerInsertDTO customerUpdate);

}
