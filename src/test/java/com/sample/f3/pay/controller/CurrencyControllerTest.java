package com.sample.f3.pay.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sample.f3.pay.model.Currency;

@RunWith (SpringJUnit4ClassRunner.class)
//@RunWith(SpringRunner.class)


/*
 * NB this test assumes memory controller in use
 * and data has been wiped on startup
 * otherwise we need to add some more sql
 * to pre-delete the entries
 */
@SpringBootTest (webEnvironment=WebEnvironment.RANDOM_PORT)
@EntityScan (basePackages = {"com.sample.f3.pay.repository","com.sample.f3.pay.model"})
@EnableJpaRepositories("com.sample.f3.pay.repository")

@Sql ({"classpath:/data-test.sql"})
@ActiveProfiles ("test")
public class CurrencyControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	/*
	 * Simple test with pre-populated data
	 * 3 currencies
	 * USD,GBP,EUR
	 * 
	 */
	@LocalServerPort
	int port;
	
	@Test
	
	public void contextLoads() 
	{
		
		
		Currency [] data = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/currency/currency/", Currency[].class);
		assertTrue ("currency controller test ",data[1].getCurrencyCode().equals("GBP"));
		assertTrue ("currency controller test size ",data.length==3);
		
		Currency data3 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/currency/currency/30", Currency.class);
		assertTrue ("currency controller test ",data3.getCurrencyCode().equals("EUR"));
		
	}

}
