package com.currency.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.bean.ResponseBean;
import com.currency.entity.Currency_Exchange;
import com.currency.repository.CurrencyRepository;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository repo;
	
	public void saving() {
		Currency_Exchange entity=new Currency_Exchange();
		entity.setCurrency_id(1);
		entity.setCurrency_from("USD");
		entity.setCurrency_to("INR");
		entity.setCurrency_value(70.05);
		repo.save(entity);
	}
	public ResponseBean getCurrencyDetail(String from, String to){
		ResponseBean bean = new ResponseBean();
		saving();
		Currency_Exchange currency_Exchange = repo.getDetailByFromAndTo(from, to);
		BeanUtils.copyProperties(currency_Exchange, bean);
		return bean;
	}
}
