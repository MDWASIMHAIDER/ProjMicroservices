package com.currency.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.resbean.ResponseBean;

@FeignClient(name="CURRENCYCONVERTER")
public interface CfFienClient {
	
	@GetMapping(value="/converter/convertAmount/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<ResponseBean> getResponse(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("quantity")Double quantity);
}

