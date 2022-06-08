package com.IrfanEcomProject.Ecom.dtos.customer;

import com.IrfanEcomProject.Ecom.models.Customer;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class CustomerInsertDTO {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String address;

    public Customer toCustomer() {
        DateTimeFormatter formatTgl = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Customer(firstName,
                lastName,
                LocalDate.parse(birthDate, formatTgl),
                phone,
                address);
    }

}
