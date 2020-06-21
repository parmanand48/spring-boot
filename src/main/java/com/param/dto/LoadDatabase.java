package com.param.dto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	/*
	 * @Bean CommandLineRunner initDatabase(EmployeeRepository repository) { return
	 * args -> { List<Address> al = new ArrayList<Address>(); Address add1=new
	 * Address(); add1.setAddress("Aundh"); Address add2=new Address();
	 * add1.setAddress("Wakad"); al.add(add1); al.add(add2); log.info("Preloading "
	 * + repository.save(new Employee("Hemal",34,al))); }; }
	 */
}