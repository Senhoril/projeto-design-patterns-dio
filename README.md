# **Conversor de Moedas com Spring Boot**

Este é um projeto simples de **Conversor de Moedas** desenvolvido usando **Spring Boot**, **H2 Database**, e **Swagger OpenAPI**. Ele permite consultar taxas de câmbio em tempo real para diferentes moedas (como USD, EUR, GBP) utilizando a API externa [AwesomeAPI](https://docs.awesomeapi.com.br/).

---

## **Funcionalidades**

- **Consulta de Taxas de Câmbio**: Obtenha a taxa de câmbio atual entre o Real Brasileiro (*BRL*) e outras moedas.
- **Histórico de Consultas**: Todas as consultas são salvas no banco de dados H2 para consulta posterior.
- **Documentação via Swagger**: A API é documentada automaticamente com *Swagger*, permitindo fácil visualização e teste dos endpoints.
- **Banco de Dados H2**: O projeto utiliza o H2 como banco de dados em memória para armazenar as taxas de câmbio.

---

## **Endpoints**

### **GET `/currency/{code}`**
- Consulta e salva a taxa de câmbio para a moeda especificada (ex.: `USD`, `EUR`).

### **GET `/currency/history`**
- Lista todas as taxas de câmbio salvas no banco de dados.

---

## **Requisitos**

- **Java 17**
- **Gradle 8+**
- Acesso à internet para consumir a API externa

---
## Diagrama de Classes

```mermaid
classDiagram
    class CurrencyWrapper {
        +Map~String, CurrencyResponse~ currencyResponses
        +setDynamicProperty(String key, CurrencyResponse value)
        +getCurrencyResponse() CurrencyResponse
    }

    class CurrencyResponse {
        +String code
        +String codein
        +String name
        +double high
        +double low
        +double bid
        +double ask
        +String timestamp
        +String createDate
        +String varBid
        +String pctChange
        +getCode() String
        +setCode(String code)
        +getCodein() String
        +setCodein(String codein)
        +getName() String
        +setName(String name)
        +getHigh() double
        +setHigh(double high)
        +getLow() double
        +setLow(double low)
        +getBid() double
        +setBid(double bid)
        +getAsk() double
        +setAsk(double ask)
        +getTimestamp() String
        +setTimestamp(String timestamp)
        +getCreateDate() String
        +setCreateDate(String createDate)
        +getVarBid() String
        +setVarBid(String varBid)
        +getPctChange() String
        +setPctChange(String pctChange)
    }

    class CurrencyRate {
        +Long id
        +String currencyCode
        +double rate
        +LocalDateTime timestamp
        +CurrencyRate()
        +CurrencyRate(String currencyCode, double rate)
        +getId() Long
        +setId(Long id)
        +getCurrencyCode() String
        +setCurrencyCode(String currencyCode)
        +getRate() double
        +setRate(double rate)
        +getTimestamp() LocalDateTime
        +setTimestamp(LocalDateTime timestamp)
    }

    class CurrencyService {
        +CurrencyRate getAndSaveCurrencyRate(String currencyCode)
    }

    class CurrencyController {
        +CurrencyRate getCurrency(String code)
        +List~CurrencyRate~ getCurrencyHistory()
    }

    CurrencyWrapper --> CurrencyResponse : contains
    CurrencyService --> CurrencyRate : creates
    CurrencyController --> CurrencyService : uses
