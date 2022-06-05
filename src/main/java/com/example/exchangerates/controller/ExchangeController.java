package com.example.exchangerates.controller;

import com.example.exchangerates.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/today-rate")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public ResponseEntity getTodayRate(@RequestParam Long rateCode) {

        return exchangeService.getActualGif(rateCode);
    }
}
