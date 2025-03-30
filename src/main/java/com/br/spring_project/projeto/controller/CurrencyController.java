package com.br.spring_project.projeto.controller;

import com.br.spring_project.projeto.model.CurrencyRate;
import com.br.spring_project.projeto.repository.CurrencyRateRepository;
import com.br.spring_project.projeto.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyRateRepository repository;

    @GetMapping("/{code}")
    public CurrencyRate getCurrency(@PathVariable String code) {
        return currencyService.getAndSaveCurrencyRate(code);
    }

    @GetMapping("/history")
    public List<CurrencyRate> getCurrencyHistory() {
        return repository.findAll();
    }
}