package com.currency.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.bean.ResponseBean;
import com.currency.service.CurrencyService;


@RestController
@RequestMapping("/currency")
public class CurrencyRestController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyService service;
	@GetMapping(value="/getRate/from/{from}/to/{to}",produces="application/json")
	public ResponseBean getCurrencyExchangeRate(@PathVariable("from")String from,@PathVariable("to")String to) {
		
		 String ports=environment.getProperty("local.server.port");
		ResponseBean currencyDetail = service.getCurrencyDetail(from, to);
		currencyDetail.setPorts(ports);
		return currencyDetail;
	}
}
