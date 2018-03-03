package com.sample.f3.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.f3.pay.model.Fx;


/**
 * @author sohail
 *
 */
public interface FxRepository extends JpaRepository <Fx, Long> {

	Fx findByFxId (Long fxId);
	 

}
