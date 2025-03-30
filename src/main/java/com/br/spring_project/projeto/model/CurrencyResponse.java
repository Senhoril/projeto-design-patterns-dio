package com.br.spring_project.projeto.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CurrencyResponse {

        private String code;       // Código da moeda base (ex.: BRL)
        private String codein;     // Código da moeda alvo (ex.: USD)
        private String name;       // Nome completo (ex.: Real Brasileiro/Dólar Americano)
        private double high;       // Maior valor do dia
        private double low;        // Menor valor do dia
        private double bid;        // Taxa de compra
        private double ask;        // Taxa de venda
        private String timestamp;  // Timestamp da última atualização
        private String createDate; // Data de criação

        // Use @JsonProperty se os nomes das propriedades forem diferentes
        @JsonProperty("varBid")
        private String varBid;

        @JsonProperty("pctChange")
        private String pctChange;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getVarBid() {
        return varBid;
    }

    public void setVarBid(String varBid) {
        this.varBid = varBid;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }
}
