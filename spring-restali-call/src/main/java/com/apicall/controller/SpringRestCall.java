package com.apicall.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@Controller
public class SpringRestCall {
	//@Autowired
	private RestTemplate rt=new RestTemplate();
	
	@GetMapping(value="/call/name/{name}/desg/{desg}",produces="application/json")
	public @ResponseBody String callRestApi(@PathVariable("name")String name,@PathVariable("desg")String desg) {
		/*System.out.println(name+""+desg);
		String REST_URL="http://localhost:8383/msg?name="+name+"&desg="+desg;
		  ResponseEntity<String> exchange = rt.exchange(
	                REST_URL,
	                HttpMethod.GET,
	                null,
	                String.class
	        );
		  String body = exchange.getBody();
		  return body;*/
		
		WebClient client=WebClient.create();
		
		
	}
}
