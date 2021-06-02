package com.udemy.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.bookstore.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	//O @Bean faz com que o metodo já entra executando quando entrar com perfil "test"
	@Bean
	public void instanciaBaseDados() {
		this.dbService.instanciaBaseDados();

	}
}
