package com.example.exchangerates.client;

import com.example.exchangerates.config.FeignClientConfiguration;
import com.example.exchangerates.pojo.ResponseExchangeRates;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.feign.config.name}", url = "${app.feign.config.url}") //, configuration = FeignClientConfiguration.class
public interface ExchangeRatesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/latest.json")
    ResponseExchangeRates getLatestRates(@RequestParam String app_id, @RequestParam String symbols);

}
