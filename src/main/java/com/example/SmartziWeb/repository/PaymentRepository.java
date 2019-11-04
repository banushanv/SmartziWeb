package com.example.SmartziWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SmartziWeb.model.Paymentform;


public interface PaymentRepository extends JpaRepository<Paymentform, Long>{

}
