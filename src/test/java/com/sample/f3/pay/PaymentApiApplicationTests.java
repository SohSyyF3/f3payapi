package com.sample.f3.pay;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment=WebEnvironment.DEFINED_PORT)
@EnableJpaRepositories("com.sample.f3.pay.repository")
@EntityScan ("com.sample.f3.pay.model")
public class PaymentApiApplicationTests {

	
	@Autowired
	private TestRestTemplate restTemplate;
	@Test
	public void contextLoads() 
	{
		assertThat(this.restTemplate.getForObject("http://127.0.0.1:8080/", String.class)).contains ("PaymentAPI");
	}

}
