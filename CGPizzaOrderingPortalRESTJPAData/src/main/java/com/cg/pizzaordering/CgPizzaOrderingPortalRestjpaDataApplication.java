package com.cg.pizzaordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages={"com.cg.pizzaordering"})
@EntityScan(basePackages="com.cg.pizzaordering.beans")
@EnableJpaRepositories(basePackages="com.cg.pizzaordering.daoservices")
@EnableWebMvc
public class CgPizzaOrderingPortalRestjpaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgPizzaOrderingPortalRestjpaDataApplication.class, args);
	}

}
