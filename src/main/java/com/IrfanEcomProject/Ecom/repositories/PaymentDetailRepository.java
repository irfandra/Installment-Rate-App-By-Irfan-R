package com.IrfanEcomProject.Ecom.repositories;

import com.IrfanEcomProject.Ecom.models.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
@Query
        (value = """
        SELECT * FROM paymentDetail
        """, nativeQuery = true)
    List<PaymentDetail> getAllPaymentDetail();
}
