package com.currency.resbean;

import lombok.Data;

@Data
public class ResponseBean {
	private String from;
	private String to;
	private Double totalCost;
}
