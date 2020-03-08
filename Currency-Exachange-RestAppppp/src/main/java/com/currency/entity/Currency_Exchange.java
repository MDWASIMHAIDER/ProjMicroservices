package com.currency.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
//@Table(name="Currency_Exchange_Entity")
public class Currency_Exchange {
	@Id
	private Integer currency_id;
	private String currency_from;
	private String currency_to;
	private Double currency_value;
}
