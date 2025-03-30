package com.br.spring_project.projeto;

import com.br.spring_project.projeto.model.CurrencyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://economia.awesomeapi.com.br/json/last/BRL-USD";

		try {
			CurrencyWrapper response = restTemplate.getForObject(url, CurrencyWrapper.class);
			System.out.println(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   }
