package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;

import java.util.List;

public interface CustomerService {
    public List<CustomerHeaderDTO> findAllCustomer();
    public boolean insertCustomer(CustomerInsertDTO customerInsertDTO);
    public boolean deleteCustomerById(Integer customerId);
    public boolean updateCustomer(Integer customerId, CustomerInsertDTO customerUpdate);

}
