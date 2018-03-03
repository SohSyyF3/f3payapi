package com.sample.f3.pay.repository;


import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.sample.f3.pay.model.Currency;


//@EntityScan ("com.sample.f3.pay.model")
//yammyamm@ComponentScan (basePackages = {"com.sample.f3.pay.repository","com.sample.f3.pay.model"})
//@Configuration
//@Profile ("test")
//@ContextConfiguration

/*
 * A quick check the database class provides the information as expected in the format expected
 */
@RunWith (SpringJUnit4ClassRunner.class)
@DataJpaTest
@TestExecutionListeners ({DependencyInjectionTestExecutionListener.class,TransactionalTestExecutionListener.class,
	DbUnitTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
@DatabaseSetup (value="classpath:/currencyDataSet.xml")
@DbUnitConfiguration
public class CurrencyRepositoryTest {

	@Autowired
	CurrencyRepository repository;

	@Test
	public void testFindByCurrencyId() {
		Currency cr = repository.findByCurrencyId(new Long(90));
		Assert.assertTrue (cr.getCurrencyCode().equals("RPK"));
	}

	@Test
	public void testFindByCurrencyCode() {
		Currency cr = repository.findByCurrencyCode("USD");
		Assert.assertTrue (cr == null);
	}

	@Test
	public void testFindAll() {
		List <Currency> cr = repository.findAll();
		Assert.assertEquals(cr.size(), 1);
	}

}
