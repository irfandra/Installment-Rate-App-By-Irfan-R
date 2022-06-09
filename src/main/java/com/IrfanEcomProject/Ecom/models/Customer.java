package com.IrfanEcomProject.Ecom.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LastName", length = 20)
    private String lastName;

    @Column(name = "BirthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "Phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "Address", length = 500)
    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Customer(String firstName, String lastName, LocalDate birthDate, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public Customer(Integer customerId) {
        this.id = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}