package com.sample.f3.pay.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.sample.f3.pay.model.Payment;

/*
 * Use with fixed database
 */
@RunWith (SpringJUnit4ClassRunner.class)

@SpringBootTest (webEnvironment=WebEnvironment.RANDOM_PORT)
@EntityScan (basePackages = {"com.sample.f3.pay.repository","com.sample.f3.pay.model"})
@EnableJpaRepositories("com.sample.f3.pay.repository")

@Sql ({"classpath:/data-test.sql"})
@ActiveProfiles ("test")
public class PaymentControllerTest {

	/*
	 * Test the restAPI from the webside
	 * Upload/add two items of data
	 * Delete the first item
	 * All should return one item only.
	 */
	@LocalServerPort
	int port;
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() 
	{
		/*
		 * For this test I have hard-coded the data here
		 */
		
		/*
		 * One item of data
		 */
		String testdata1 = " {\n" + 
				"            \"attributes\": {\n" + 
				"                \"amount\": \"100.21\",\n" + 
				"                \"beneficiary_party\": {\n" + 
				"                    \"account_name\": \"W Owens\",\n" + 
				"                    \"account_number\": \"31926819\",\n" + 
				"                    \"account_number_code\": \"BBAN\",\n" + 
				"                    \"account_type\": 0,\n" + 
				"                    \"address\": \"1 The Beneficiary Localtown SE2\",\n" + 
				"                    \"bank_id\": \"403000\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Wilfred Jeremiah Owens\"\n" + 
				"                },\n" + 
				"                \"charges_information\": {\n" + 
				"                    \"bearer_code\": \"SHAR\",\n" + 
				"                    \"receiver_charges_amount\": \"1.00\",\n" + 
				"                    \"receiver_charges_currency\": \"USD\",\n" + 
				"                    \"sender_charges\": [\n" + 
				"                        {\n" + 
				"                            \"amount\": \"5.00\",\n" + 
				"                            \"currency\": \"GBP\"\n" + 
				"                        },\n" + 
				"                        {\n" + 
				"                            \"amount\": \"10.00\",\n" + 
				"                            \"currency\": \"USD\"\n" + 
				"                        }\n" + 
				"                    ]\n" + 
				"                },\n" + 
				"                \"currency\": \"GBP\",\n" + 
				"                \"debtor_party\": {\n" + 
				"                    \"account_name\": \"EJ Brown Black\",\n" + 
				"                    \"account_number\": \"GB29XABC10161234567801\",\n" + 
				"                    \"account_number_code\": \"IBAN\",\n" + 
				"                    \"address\": \"10 Debtor Crescent Sourcetown NE1\",\n" + 
				"                    \"bank_id\": \"203301\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Emelia Jane Brown\"\n" + 
				"                },\n" + 
				"                \"end_to_end_reference\": \"Wil piano Jan\",\n" + 
				"                \"fx\": {\n" + 
				"                    \"contract_reference\": \"FX123\",\n" + 
				"                    \"exchange_rate\": \"2.00000\",\n" + 
				"                    \"original_amount\": \"200.42\",\n" + 
				"                    \"original_currency\": \"USD\"\n" + 
				"                },\n" + 
				"                \"numeric_reference\": \"1002001\",\n" + 
				"                \"payment_id\": \"123456789012345678\",\n" + 
				"                \"payment_purpose\": \"Paying for goods/services\",\n" + 
				"                \"payment_scheme\": \"FPS\",\n" + 
				"                \"payment_type\": \"Credit\",\n" + 
				"                \"processing_date\": \"2017-01-18\",\n" + 
				"                \"reference\": \"Payment for Em's piano lessons\",\n" + 
				"                \"scheme_payment_sub_type\": \"InternetBanking\",\n" + 
				"                \"scheme_payment_type\": \"ImmediatePayment\",\n" + 
				"                \"sponsor_party\": {\n" + 
				"                    \"account_number\": \"56781234\",\n" + 
				"                    \"bank_id\": \"123123\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"            \"id\": \"ab4bbd28-33c6-4231-9b64-0e96190f59ef\",\n" + 
				"            \"organisation_id\": \"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb\",\n" + 
				"            \"type\": \"Payment\",\n" + 
				"            \"version\": 0\n" + 
				"        },\n" + 
				"        {\n" + 
				"            \"attributes\": {\n" + 
				"                \"amount\": \"100.21\",\n" + 
				"                \"beneficiary_party\": {\n" + 
				"                    \"account_name\": \"W Owens\",\n" + 
				"                    \"account_number\": \"31926819\",\n" + 
				"                    \"account_number_code\": \"BBAN\",\n" + 
				"                    \"account_type\": 0,\n" + 
				"                    \"address\": \"1 The Beneficiary Localtown SE2\",\n" + 
				"                    \"bank_id\": \"403000\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Wilfred Jeremiah Owens\"\n" + 
				"                },\n" + 
				"                \"charges_information\": {\n" + 
				"                    \"bearer_code\": \"SHAR\",\n" + 
				"                    \"receiver_charges_amount\": \"1.00\",\n" + 
				"                    \"receiver_charges_currency\": \"USD\",\n" + 
				"                    \"sender_charges\": [\n" + 
				"                        {\n" + 
				"                            \"amount\": \"5.00\",\n" + 
				"                            \"currency\": \"GBP\"\n" + 
				"                        },\n" + 
				"                        {\n" + 
				"                            \"amount\": \"10.00\",\n" + 
				"                            \"currency\": \"USD\"\n" + 
				"                        }\n" + 
				"                    ]\n" + 
				"                },\n" + 
				"                \"currency\": \"GBP\",\n" + 
				"                \"debtor_party\": {\n" + 
				"                    \"account_name\": \"EJ Brown Black\",\n" + 
				"                    \"account_number\": \"GB29XABC10161234567801\",\n" + 
				"                    \"account_number_code\": \"IBAN\",\n" + 
				"                    \"address\": \"10 Debtor Crescent Sourcetown NE1\",\n" + 
				"                    \"bank_id\": \"203301\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Emelia Jane Brown\"\n" + 
				"                },\n" + 
				"                \"end_to_end_reference\": \"Wil piano Jan\",\n" + 
				"                \"fx\": {\n" + 
				"                    \"contract_reference\": \"FX123\",\n" + 
				"                    \"exchange_rate\": \"2.00000\",\n" + 
				"                    \"original_amount\": \"200.42\",\n" + 
				"                    \"original_currency\": \"USD\"\n" + 
				"                },\n" + 
				"                \"numeric_reference\": \"1002001\",\n" + 
				"                \"payment_id\": \"123456789012345678\",\n" + 
				"                \"payment_purpose\": \"Paying for goods/services\",\n" + 
				"                \"payment_scheme\": \"FPS\",\n" + 
				"                \"payment_type\": \"Credit\",\n" + 
				"                \"processing_date\": \"2017-01-18\",\n" + 
				"                \"reference\": \"Payment for Em's piano lessons\",\n" + 
				"                \"scheme_payment_sub_type\": \"InternetBanking\",\n" + 
				"                \"scheme_payment_type\": \"ImmediatePayment\",\n" + 
				"                \"sponsor_party\": {\n" + 
				"                    \"account_number\": \"56781234\",\n" + 
				"                    \"bank_id\": \"123123\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"            \"id\": \"7f172f5c-f810-4ebe-b015-cb1fc24c6b66\",\n" + 
				"            \"organisation_id\": \"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb\",\n" + 
				"            \"type\": \"Payment\",\n" + 
				"            \"version\": 0\n" + 
				"        }";
		/*
		 * Second item of data
		 */
		String testdata = "{\n" + 
				"            \"attributes\": {\n" + 
				"                \"amount\": \"100.21\",\n" + 
				"                \"beneficiary_party\": {\n" + 
				"                    \"account_name\": \"W Owens\",\n" + 
				"                    \"account_number\": \"31926819\",\n" + 
				"                    \"account_number_code\": \"BBAN\",\n" + 
				"                    \"account_type\": 0,\n" + 
				"                    \"address\": \"1 The Beneficiary Localtown SE2\",\n" + 
				"                    \"bank_id\": \"403000\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Wilfred Jeremiah Owens\"\n" + 
				"                },\n" + 
				"                \"charges_information\": {\n" + 
				"                    \"bearer_code\": \"SHAR\",\n" + 
				"                    \"receiver_charges_amount\": \"1.00\",\n" + 
				"                    \"receiver_charges_currency\": \"USD\",\n" + 
				"                    \"sender_charges\": [\n" + 
				"                        {\n" + 
				"                            \"amount\": \"5.00\",\n" + 
				"                            \"currency\": \"GBP\"\n" + 
				"                        },\n" + 
				"                        {\n" + 
				"                            \"amount\": \"10.00\",\n" + 
				"                            \"currency\": \"USD\"\n" + 
				"                        }\n" + 
				"                    ]\n" + 
				"                },\n" + 
				"                \"currency\": \"GBP\",\n" + 
				"                \"debtor_party\": {\n" + 
				"                    \"account_name\": \"EJ Brown Black\",\n" + 
				"                    \"account_number\": \"GB29XABC10161234567801\",\n" + 
				"                    \"account_number_code\": \"IBAN\",\n" + 
				"                    \"address\": \"10 Debtor Crescent Sourcetown NE1\",\n" + 
				"                    \"bank_id\": \"203301\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Emelia Jane Brown\"\n" + 
				"                },\n" + 
				"                \"end_to_end_reference\": \"Wil piano Jan\",\n" + 
				"                \"fx\": {\n" + 
				"                    \"contract_reference\": \"FX123\",\n" + 
				"                    \"exchange_rate\": \"2.00000\",\n" + 
				"                    \"original_amount\": \"200.42\",\n" + 
				"                    \"original_currency\": \"USD\"\n" + 
				"                },\n" + 
				"                \"numeric_reference\": \"1002001\",\n" + 
				"                \"payment_id\": \"123456789012345678\",\n" + 
				"                \"payment_purpose\": \"Paying for goods/services\",\n" + 
				"                \"payment_scheme\": \"FPS\",\n" + 
				"                \"payment_type\": \"Credit\",\n" + 
				"                \"processing_date\": \"2017-01-18\",\n" + 
				"                \"reference\": \"Payment for Em's piano lessons\",\n" + 
				"                \"scheme_payment_sub_type\": \"InternetBanking\",\n" + 
				"                \"scheme_payment_type\": \"ImmediatePayment\",\n" + 
				"                \"sponsor_party\": {\n" + 
				"                    \"account_number\": \"56781234\",\n" + 
				"                    \"bank_id\": \"123123\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"            \"id\": \"97fe60ba-1334-439f-91db-32cc3cde036a\",\n" + 
				"            \"organisation_id\": \"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb\",\n" + 
				"            \"type\": \"Payment\",\n" + 
				"            \"version\": 0\n" + 
				"        }";
		
		/*
		 * Second item of data, modified for an update test
		 */
		String testdata2 = "{\n" + 
				"            \"attributes\": {\n" + 
				"                \"amount\": \"2100.21\",\n" + 
				"                \"beneficiary_party\": {\n" + 
				"                    \"account_name\": \"W Owens\",\n" + 
				"                    \"account_number\": \"31926819\",\n" + 
				"                    \"account_number_code\": \"BBAN\",\n" + 
				"                    \"account_type\": 0,\n" + 
				"                    \"address\": \"1 The Beneficiary Localtown SE2\",\n" + 
				"                    \"bank_id\": \"403999\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Wilfred Jeremiah Owens\"\n" + 
				"                },\n" + 
				"                \"charges_information\": {\n" + 
				"                    \"bearer_code\": \"SHAR\",\n" + 
				"                    \"receiver_charges_amount\": \"1.00\",\n" + 
				"                    \"receiver_charges_currency\": \"USD\",\n" + 
				"                    \"sender_charges\": [\n" + 
				"                        {\n" + 
				"                            \"amount\": \"15.00\",\n" + 
				"                            \"currency\": \"GBP\"\n" + 
				"                        },\n" + 
				"                        {\n" + 
				"                            \"amount\": \"10.00\",\n" + 
				"                            \"currency\": \"USD\"\n" + 
				"                        }\n" + 
				"                    ]\n" + 
				"                },\n" + 
				"                \"currency\": \"GBP\",\n" + 
				"                \"debtor_party\": {\n" + 
				"                    \"account_name\": \"EJ Brown Black\",\n" + 
				"                    \"account_number\": \"GB29XABC10161234567801\",\n" + 
				"                    \"account_number_code\": \"IBAN\",\n" + 
				"                    \"address\": \"10 Debtor Crescent Sourcetown NE1\",\n" + 
				"                    \"bank_id\": \"203301\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\",\n" + 
				"                    \"name\": \"Emelia Jane Brown\"\n" + 
				"                },\n" + 
				"                \"end_to_end_reference\": \"Wil piano Jan\",\n" + 
				"                \"fx\": {\n" + 
				"                    \"contract_reference\": \"FX123\",\n" + 
				"                    \"exchange_rate\": \"2.00000\",\n" + 
				"                    \"original_amount\": \"200.42\",\n" + 
				"                    \"original_currency\": \"USD\"\n" + 
				"                },\n" + 
				"                \"numeric_reference\": \"1002001\",\n" + 
				"                \"payment_id\": \"123456789012345678\",\n" + 
				"                \"payment_purpose\": \"Paying for goods/services\",\n" + 
				"                \"payment_scheme\": \"FPS\",\n" + 
				"                \"payment_type\": \"Credit\",\n" + 
				"                \"processing_date\": \"2017-01-18\",\n" + 
				"                \"reference\": \"Payment for Em's piano lessons\",\n" + 
				"                \"scheme_payment_sub_type\": \"InternetBanking\",\n" + 
				"                \"scheme_payment_type\": \"ImmediatePayment\",\n" + 
				"                \"sponsor_party\": {\n" + 
				"                    \"account_number\": \"56781234\",\n" + 
				"                    \"bank_id\": \"123123\",\n" + 
				"                    \"bank_id_code\": \"GBDSC\"\n" + 
				"                }\n" + 
				"            },\n" + 
				"            \"id\": \"97fe60ba-1334-439f-91db-32cc3cde036a\",\n" + 
				"            \"organisation_id\": \"743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb\",\n" + 
				"            \"type\": \"Payment\",\n" + 
				"            \"version\": 0\n" + 
				"        }";

		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpEntity ;
		String data2;
		System.out.println("Hibernate version = " + org.hibernate.Version.getVersionString());
		
		/*
		 * Just checking nothing is assigned to the root of payment
		 * and a 404 error is returned
		 */
		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/", String.class);
		assertTrue (data2.contains("\"status\":404"));

		/*
		 * Confirm that a non existent entry returns blank
		 */
		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/get/1", String.class);
		assertTrue ("blank DB returns " , data2==null);

		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/all/", String.class);
		assertTrue ("blank DB returns " , data2.equals("[]"));

		
		httpEntity = new HttpEntity<String>(testdata,headers);
		data2 = this.restTemplate.postForObject("http://127.0.0.1:" + port + "/payment/add/", httpEntity, String.class);
		httpEntity = new HttpEntity<String>(testdata1,headers);
		data2 = this.restTemplate.postForObject("http://127.0.0.1:" + port + "/payment/add/", httpEntity, String.class);

		/*
		 * Get the whole list, check if the two items were added
		 */
		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/all/", String.class);
		assertTrue("1 items of data", data2.contains("97fe60ba-1334-439f-91db-32cc3cde036a"));
		assertTrue("1 items of data",  data2.contains("ab4bbd28-33c6-4231-9b64-0e96190f59ef"));
		System.out.println(("Full data output "+ data2));
		
		
		/*
		 * Delete one item and confirm it is deleted now
		 */
		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/delete/97fe60ba-1334-439f-91db-32cc3cde036a", String.class);
		
		data2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/all/", String.class);
		assertFalse ("1 items of data", data2.contains("97fe60ba-1334-439f-91db-32cc3cde036a"));
		assertTrue  ("1 items of data",  data2.contains("ab4bbd28-33c6-4231-9b64-0e96190f59ef"));

		/*
		 * Add 97 back in
		 */
		httpEntity = new HttpEntity<String>(testdata,headers);
		data2 = this.restTemplate.postForObject("http://127.0.0.1:" + port + "/payment/add/", httpEntity, String.class);
		Payment pdata2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/get/97fe60ba-1334-439f-91db-32cc3cde036a", Payment.class);
		assertTrue ("item 97 added again ", pdata2.getId().equals("97fe60ba-1334-439f-91db-32cc3cde036a"));
		assertTrue ("item 97 added again ", pdata2.getAttributes().getBeneficiaryParty().getBankId().equals("403000"));
		assertTrue ("item 97 added again ", 0==pdata2.getAttributes().getAmount().compareTo(BigDecimal.valueOf(100.21)));
		assertTrue ("item 97 added again ", 0==pdata2.getAttributes().getChargesInformation().getSenderCharges().get(0).getAmount().compareTo(BigDecimal.valueOf(5.00)));

		/*
		 * Update item 97
		 */
		httpEntity = new HttpEntity<String>(testdata2,headers);
		data2 = this.restTemplate.postForObject("http://127.0.0.1:" + port + "/payment/update/97fe60ba-1334-439f-91db-32cc3cde036a", httpEntity, String.class);
		
		/*
		 * Confirm only 2 items in the DB
		 */
		Payment [] padata2 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/all/", Payment[].class);
		assertTrue ("Update count = ", padata2.length==2);
		
		
		/*
		 * Get the item 97 to check fields
		 */
		Payment pdata3 = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/payment/get/97fe60ba-1334-439f-91db-32cc3cde036a", Payment.class);
		System.out.println(("[ GET ] " + pdata3.getId()+" " + pdata3.getAttributes().getBeneficiaryParty().getBankId()));
		
		assertTrue ("item 97 update again ", pdata3.getId().equals("97fe60ba-1334-439f-91db-32cc3cde036a"));
		assertFalse ("item 97 update again ", pdata3.getAttributes().getBeneficiaryParty().getBankId().equals("403000"));
		assertFalse ("item 97 update again ", 0==pdata3.getAttributes().getAmount().compareTo(BigDecimal.valueOf(100.21)));
		assertTrue ("item 97 update again ", 0==pdata3.getAttributes().getAmount().compareTo(BigDecimal.valueOf(2100.21)));
		assertTrue ("item 97 update again ", 0==pdata3.getAttributes().getChargesInformation().getSenderCharges().get(0).getAmount().compareTo(BigDecimal.valueOf(15.00)));
		assertTrue ("item 97 update again ", pdata3.getAttributes().getBeneficiaryParty().getBankId().equals("403999"));assertFalse ("item 97 update again ", 0==pdata3.getAttributes().getAmount().compareTo(BigDecimal.valueOf(100.21)));

	}

}
