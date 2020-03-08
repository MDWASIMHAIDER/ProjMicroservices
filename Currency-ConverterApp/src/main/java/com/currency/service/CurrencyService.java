package com.currency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.currency.command.CurrencyCommand;
import com.currency.resbean.ResponseBean;

import lombok.experimental.FieldNameConstants;

@Service
public class CurrencyService {
	
	//fien client inplace of webclient and resttemplate
	@Autowired
	private CfFienClient client;
	
	public ResponseEntity<ResponseBean> callConveter(String from1,String to1,Double amtQuantity) {
		//String URL="http://localhost:1111/converter/convertAmount/from/"+from1+"/to/"+to1+"/quantity/"+amtQuantity;
		//System.out.println(from1+"=="+to1+"===="+amtQuantity);
		//RestTemplate restTemplate=new RestTemplate();
		//ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,null, ResponseBean.class,String.class);
		//System.out.println("fien callrd============================");
		ResponseEntity<ResponseBean> responseEntity = client.getResponse(from1,to1,amtQuantity);
		return responseEntity;
	}
}
