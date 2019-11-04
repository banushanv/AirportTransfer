package com.example.AirportTransfer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(schema = "AirportTransfer", name = "AirportTransfer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AirportTransferModel  implements Serializable {
	
	private static final long serialVersionUID = 1488659908646811932L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private long  airportTransferId; 
	
	
@Column(name="TripType")	
private String tripType;

@Column(name="PickUp")
private String pickup;

@Column(name="DropOff")
private String dropOff;

@Column(name="TripDate")
private Date tripDate;

@Column(name="TripTime")
private String tripTime;

@Column(name="vehicleType")
private String vehicleType;


@Column(name="Passengers")
private String passengers;

@Column(name="FlightNumber")
private String flightNumber;

@Column(name="FlightTime")
private String flightTime;

@Column(name="OutBoundTripFare")
private String outboundTripFare;

@Column(name="PromoCode")
private String promoCode;

public String getTripType() {
	return tripType;
}
public void setTripType(String tripType) {
	this.tripType = tripType;
}
public String getPickup() {
	return pickup;
}
public void setPickup(String pickup) {
	this.pickup = pickup;
}
public String getDropOff() {
	return dropOff;
}
public void setDropOff(String dropOff) {
	this.dropOff = dropOff;
}
public Date getTripDate() {
	return tripDate;
}
public void setTripDate(Date date) {
	this.tripDate = date;
}
public String getTripTime() {
	return tripTime;
}
public void setTripTime(String tripTime) {
	this.tripTime = tripTime;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public String getPassengers() {
	return passengers;
}
public void setPassengers(String passengers) {
	this.passengers = passengers;
}
public String getFlightNumber() {
	return flightNumber;
}
public void setFlightNumber(String flightNumber) {
	this.flightNumber = flightNumber;
}
public String getFlightTime() {
	return flightTime;
}
public void setFlightTime(String flightTime) {
	this.flightTime = flightTime;
}
public String getOutboundTripFare() {
	return outboundTripFare;
}
public void setOutboundTripFare(String outboundTripFare) {
	this.outboundTripFare = outboundTripFare;
}
public String getPromoCode() {
	return promoCode;
}
public void setPromoCode(String promoCode) {
	this.promoCode = promoCode;
}





}
