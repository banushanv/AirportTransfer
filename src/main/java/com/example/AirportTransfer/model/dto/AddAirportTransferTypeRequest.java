package com.example.AirportTransfer.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddAirportTransferTypeRequest {
	
	private String tripType;


	private String pickup;

	
	private String dropOff;

	
	private String tripDate;


	private String tripTime;

	private String vehicleType;

	private String passengers;


	private String flightNumber;

	private String flightTime;


	private String outboundTripFare;

	private String promoCode;
}
