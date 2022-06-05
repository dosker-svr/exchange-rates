package com.example.exchangerates.service;

import com.example.exchangerates.client.ExchangeRatesClient;
import com.example.exchangerates.pojo.ResponseExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ExchangeService {
    @Autowired
    private ExchangeRatesClient client;

    @Value("${app.open-exchange-rates.appId}")
    private String appId;
    //"app_id=${app.open-exchange-rates.appId}"
    //String app_id = "app_id=" + appId;

    public ResponseEntity<Double> getActualGif(Long rateCode) {
        if (rateCode == 156L) {
            ResponseExchangeRates respRate = client.getLatestRates(appId, "cny");
            System.out.println(respRate.getTimestamp());
            System.out.println(respRate.getTimestamp().toString());
            System.out.println(respRate.getTimestamp().getTime());
            //Object object = client.getLatestRates(appId, "cny");
            Double cnyReq = respRate.getRates().get("CNY");//.getCny()
            ResponseEntity<Double> cny = ResponseEntity.ok(cnyReq);

            System.out.println(cny);
            return cny;
        }

        return ResponseEntity.ok(0.0);
    }
}
