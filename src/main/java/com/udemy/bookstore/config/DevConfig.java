package com.udemy.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.bookstore.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbservice;

	// @Value recupera o valor da variavel que esta indicada com $ no
	// application.properties
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	
	// @Bean : Sempre que a classe é instanciada, o método anotado é executado
	@Bean
	public boolean instanciaBaseDados() {
		if (strategy.equals("create")) {
			this.dbservice.instanciaBaseDados();
		}
		return false;
	}
}
