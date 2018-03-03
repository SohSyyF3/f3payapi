package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.f3.pay.model.Debtor;

public interface DebtorRepository extends JpaRepository<Debtor, Long> {

}
