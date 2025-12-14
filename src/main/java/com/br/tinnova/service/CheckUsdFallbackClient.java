package com.br.tinnova.service;

import com.br.tinnova.model.dto.SearchUsdFallbackPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "search-usd-fallback", url = "https://api.frankfurter.app")
public interface CheckUsdFallbackClient {

    @GetMapping("/latest?from={currencyFrom}&to={currencyTo}")
    SearchUsdFallbackPriceDTO searchUSD(@PathVariable String currencyFrom, @PathVariable String currencyTo);
}
