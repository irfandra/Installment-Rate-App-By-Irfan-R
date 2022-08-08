package com.IrfanEcomProject.Ecom.service;

import com.IrfanEcomProject.Ecom.dtos.customer.CustomerHeaderDTO;
import com.IrfanEcomProject.Ecom.dtos.customer.CustomerInsertDTO;
import com.IrfanEcomProject.Ecom.models.Customer;
import com.IrfanEcomProject.Ecom.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public List<CustomerHeaderDTO> findAllCustomer() {
        return CustomerHeaderDTO.toList(customerRepository.getAllCustomer());
    }

    @Override
    public boolean insertCustomer(CustomerInsertDTO customerInsertDTO) {
        Customer customer = customerInsertDTO.toCustomer();
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean deleteCustomerById(Integer customerId) {
        Customer checkId = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + customerId + " Not Found"));
        customerRepository.deleteById(checkId.getId());
        return true;
    }

    @Override
    public boolean updateCustomer(Integer customerId, CustomerInsertDTO customerUpdate) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + customerId + " Not Found"));
        customer.setFirstName(customerUpdate.getFirstName() == null ? customer.getFirstName() : customerUpdate.getFirstName());
        customer.setLastName(customerUpdate.getLastName() == null ? customer.getLastName() : customerUpdate.getLastName());
        customer.setBirthDate(customerUpdate.getBirthDate() == null ? customer.getBirthDate() : customerUpdate.toCustomer().getBirthDate());
        customer.setAddress(customerUpdate.getAddress() == null ? customer.getAddress() : customerUpdate.getAddress());
        customerRepository.save(customer);
        return true;
    }
}
