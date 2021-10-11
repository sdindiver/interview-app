package com.app.service;

public class TimeConverterService {

	public Integer convertTo24H(String dateTime) {
		String lowerCase = dateTime.toLowerCase();
		if(lowerCase.contains("am")){
			String hourPart = lowerCase.split(":")[0];
			if(hourPart.equalsIgnoreCase("12")){
				hourPart="0"; 
			}
			return Integer.parseInt(hourPart);
		}else{
			String hourPart = lowerCase.split(":")[0];
			if(!hourPart.equalsIgnoreCase("12")){
				return Integer.parseInt(hourPart)+12;
			}
			
		}
		return null;
	}

	public String extractHour(String extractHour) {
		return extractHour.split(":")[0];
	}

}
