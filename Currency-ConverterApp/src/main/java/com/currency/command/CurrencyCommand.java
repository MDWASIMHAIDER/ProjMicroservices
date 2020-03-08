package com.currency.command;

import lombok.Data;

@Data
public class CurrencyCommand {
	
	private String from;
	private String to;
	private Double amountQuantity;
}
