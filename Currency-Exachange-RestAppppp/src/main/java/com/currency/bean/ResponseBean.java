package com.currency.bean;

import lombok.Data;

@Data
public class ResponseBean {
	private Integer currency_id;
	private String currency_from;
	private String currency_to;
	private Double currency_value;
	private String ports;
}
