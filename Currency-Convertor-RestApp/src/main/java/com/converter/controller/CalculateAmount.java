package com.converter.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.converter.responsebean.CurrencyResponseBean;

@FeignClient(name="CURRENCYEXCHANGE")
@RibbonClient(name="CURRENCYEXCHANGE")
public interface CalculateAmount {
	
	@GetMapping(value="/currency/getRate/from/{from}/to/{to}",produces="application/json")
	public CurrencyResponseBean getConvertedCurrency(@PathVariable("from")String from,@PathVariable("to")String to);
	
}
