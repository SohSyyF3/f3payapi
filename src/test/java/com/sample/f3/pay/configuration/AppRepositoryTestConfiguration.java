package com.sample.f3.pay.configuration;

//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = {"com.sample.f3.pay.repository"})
//@ComponentScan (basePackages = {"com.sample.f3.pay.repository","com.sample.f3.pay.model"})
@Configuration
@Profile ("test")
public class AppRepositoryTestConfiguration {

}
