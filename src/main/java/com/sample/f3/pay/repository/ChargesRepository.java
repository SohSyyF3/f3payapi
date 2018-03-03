package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.f3.pay.model.Charges;

public interface ChargesRepository extends JpaRepository<Charges, Long> {

}
