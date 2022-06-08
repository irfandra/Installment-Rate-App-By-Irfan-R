package com.IrfanEcomProject.Ecom.dtos.customer;

import com.IrfanEcomProject.Ecom.models.Customer;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerHeaderDTO {
    private final Integer customerId;
//    private final String firstName;
//    private final String lastName;
    private final String fullName;
    private final String birthDate;
    private final String phone;
    private final String address;


    public static CustomerHeaderDTO set(Customer customer) {
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        return new CustomerHeaderDTO(customer.getId(),
                customer.getFirstName() + " " + customer.getLastName(),
                formatTgl.format(customer.getBirthDate()),
                customer.getPhone(),
                customer.getAddress());
    }
    public static List<CustomerHeaderDTO> toList(List<Customer> customers){
        List<CustomerHeaderDTO> result = new ArrayList<>();
        for (Customer e: customers
        ) {
            result.add(set(e));
        }
        return result;
    }


}
