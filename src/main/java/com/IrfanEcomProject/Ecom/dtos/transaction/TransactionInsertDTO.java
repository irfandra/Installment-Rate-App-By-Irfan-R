package com.IrfanEcomProject.Ecom.dtos.transaction;

import lombok.Data;

@Data
public class TransactionInsertDTO {
    private String id;
    private Integer customerId;
    private Integer paymentId;
    private String productName;


}
