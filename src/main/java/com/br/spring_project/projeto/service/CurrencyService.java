package com.br.spring_project.projeto.service;

import com.br.spring_project.projeto.model.CurrencyRate;
import com.br.spring_project.projeto.model.CurrencyResponse;
import com.br.spring_project.projeto.model.CurrencyWrapper;
import com.br.spring_project.projeto.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class CurrencyService {
    @Autowired
    private CurrencyRateRepository repository;

    private static final String API_URL = "https://economia.awesomeapi.com.br/json/last/";

    public CurrencyRate getAndSaveCurrencyRate(String currencyCode) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = API_URL + currencyCode + "-BRL" ;

            // Consumir a API externa
            CurrencyWrapper response = restTemplate.getForObject(url, CurrencyWrapper.class);

            if (response == null || response.getCurrencyResponse() == null) {
                throw new IllegalArgumentException("Código de moeda inválido ou dados indisponíveis para " + currencyCode);
            }

            CurrencyResponse currencyResponse = response.getCurrencyResponse();

            // Criar e salvar a taxa de câmbio no banco de dados
            CurrencyRate rate = new CurrencyRate(currencyCode, currencyResponse.getBid());
            return repository.save(rate);
        } catch (IllegalArgumentException e) {
            throw e; // Propague o erro para o cliente
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consumir a API externa ou salvar no banco de dados: " + e.getMessage(), e);
        }
    }
}
