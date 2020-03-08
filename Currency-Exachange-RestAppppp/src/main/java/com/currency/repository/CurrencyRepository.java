package com.currency.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.currency.entity.Currency_Exchange;


@Repository
public interface CurrencyRepository extends JpaRepository<Currency_Exchange, Serializable>{
	
	@Query("from Currency_Exchange where currency_from=:from and currency_to=:to")
	public Currency_Exchange getDetailByFromAndTo(String from,String to);
	
}
