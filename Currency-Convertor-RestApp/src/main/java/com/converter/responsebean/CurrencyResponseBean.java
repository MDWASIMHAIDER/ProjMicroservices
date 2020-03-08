package com.converter.responsebean;

import lombok.Data;

@Data
public class CurrencyResponseBean {
	private Integer currency_id;
	private String currency_from;
	private String currency_to;
	private Double currency_value;
	private String ports;
}
