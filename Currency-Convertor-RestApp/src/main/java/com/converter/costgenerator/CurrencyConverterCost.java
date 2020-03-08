package com.converter.costgenerator;

import lombok.Data;

@Data
public class CurrencyConverterCost {
	
	private String from;
	private String to;
	private Double totalCost;
	private String ports;
}
