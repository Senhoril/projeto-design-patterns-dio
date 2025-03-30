package com.br.spring_project.projeto.repository;

import com.br.spring_project.projeto.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate,Long> {
}
