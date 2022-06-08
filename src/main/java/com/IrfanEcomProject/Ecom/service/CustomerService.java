package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;
import com.IrfanEcomProject.Ecom.models.Customer;
import com.IrfanEcomProject.Ecom.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<CustomerHeaderDTO> findAllCustomer(){
        return CustomerHeaderDTO.toList(customerRepository.findAll());
    }

    public boolean insertCustomer(CustomerInsertDTO customerInsertDTO) {
        Customer customer = customerInsertDTO.toCustomer();
        customerRepository.save(customer);
        return true;
    }

    public String deleteCandidateById(Integer customerId) {
        customerRepository.deleteById(customerId);
        return "Success";
    }

    public boolean updateCustomer(Integer customerId, CustomerInsertDTO customerUpdate) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setFirstName(customerUpdate.getFirstName()==null?customer.getFirstName():customerUpdate.getFirstName());
        customer.setLastName(customerUpdate.getLastName()==null?customer.getLastName():customerUpdate.getLastName());
        customer.setBirthDate(customerUpdate.getBirthDate()==null?customer.getBirthDate():customerUpdate.toCustomer().getBirthDate());
        customer.setAddress(customerUpdate.getAddress()==null?customer.getAddress():customerUpdate.getAddress());
        customerRepository.save(customer);
        return true;
    }
}
