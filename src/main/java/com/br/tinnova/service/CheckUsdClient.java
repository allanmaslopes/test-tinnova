package com.br.tinnova.service;

import com.br.tinnova.model.dto.SearchUsdFallbackPriceDTO;
import com.br.tinnova.model.dto.SearchUsdPriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "search-usd", url = "https://economia.awesomeapi.com.br")
public interface CheckUsdClient {

    @GetMapping("/json/last/{currencyFrom}-{currencyTo}")
    SearchUsdPriceDTO searchUSD(@PathVariable String currencyFrom, @PathVariable String currencyTo);

}
