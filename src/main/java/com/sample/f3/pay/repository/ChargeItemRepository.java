package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.f3.pay.model.ChargeItem;

public interface ChargeItemRepository extends JpaRepository<ChargeItem, Long> {

}
