package com.nt.beans;

public class WheatherReportGenerator {
	
	private IWeatherForeCasting weather;
	
	
	
	public void setWeather(IWeatherForeCasting weather) {
		this.weather = weather;
	}



	public double generateTemprature(long zip){
		double temp=weather.getTemprature(zip);
		return temp;
	}
}
