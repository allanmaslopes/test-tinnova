package com.br.tinnova.model.dto;

import java.time.LocalDate;
import java.util.Map;

public class SearchUsdFallbackPriceDTO {

    private Double amount;

    private String base;

    private LocalDate date;

    private Map<String, Double> rates;

    public SearchUsdFallbackPriceDTO() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
