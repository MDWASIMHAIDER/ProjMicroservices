package com.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.converter.costgenerator.CurrencyConverterCost;
import com.converter.responsebean.CurrencyResponseBean;


@RestController
@RequestMapping("/converter")
public class CurrencyConverterRestController {
	
	//Fien Client
	@Autowired
	private CalculateAmount client;
	/*@GetMapping(value="/convertAmount/from/{from}/to/{to}/quantity/{quantity}",produces="application/json")
	public CurrencyConverterCost getConvertedCurrency(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("quantity")Double amountQuantity) {
		String URL="http://localhost:3333/currency/getRate/from/{from}/to/{to}";
		
		CurrencyConverterCost currencyConverterCost=new CurrencyConverterCost();
		Builder builder = WebClient.builder();
		WebClient webClient = builder.build();
		CurrencyResponseBean responseBean = webClient.get().uri(URL, from,to,amountQuantity)
		.retrieve().bodyToMono(CurrencyResponseBean.class).block();
		Double currency_value = responseBean.getCurrency_value();
		Double currencyTotalValue=currency_value*amountQuantity;
		currencyConverterCost.setFrom(from);
		currencyConverterCost.setTo(to);
		currencyConverterCost.setTotalCost(currencyTotalValue);
		return currencyConverterCost;
	}*/
	
	@GetMapping(value="/convertAmount/from/{from}/to/{to}/quantity/{quantity}",produces="application/json")
	public CurrencyConverterCost getConvertedCurrency(@PathVariable("from")String from,@PathVariable("to")String to,@PathVariable("quantity")Double amountQuantity) {
		CurrencyConverterCost currencyConverterCost=new CurrencyConverterCost();
		CurrencyResponseBean currencyResponseBean = client.getConvertedCurrency(from, to);
		Double currency_value = currencyResponseBean.getCurrency_value();
		Double currencyTotalValue=currency_value*amountQuantity;
		currencyConverterCost.setFrom(from);
		currencyConverterCost.setTo(to);
		currencyConverterCost.setPorts(currencyResponseBean.getPorts());
		currencyConverterCost.setTotalCost(currencyTotalValue);
		return currencyConverterCost;
	}
}
