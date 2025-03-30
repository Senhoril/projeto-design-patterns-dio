package com.br.spring_project.projeto.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class CurrencyWrapper {

    private Map<String, CurrencyResponse> currencyResponses = new HashMap<>();

    // Método para capturar chaves dinâmicas no JSON
    @JsonAnySetter
    public void setDynamicProperty(String key, CurrencyResponse value) {
        currencyResponses.put(key, value);
    }

    // Método para obter a primeira resposta (independente da chave)
    public CurrencyResponse getCurrencyResponse() {
        return currencyResponses.values().stream().findFirst().orElse(null);
    }

    // Getter para o mapa de respostas (opcional, se necessário)
    public Map<String, CurrencyResponse> getCurrencyResponses() {
        return currencyResponses;
    }
}