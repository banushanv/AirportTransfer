package com.example.AirportTransfer.service.Impl;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.AirportTransfer.Utils.JacksonConfig;
import com.example.AirportTransfer.Utils.StringToDateConverter;
import com.example.AirportTransfer.exception.BadRequestException;
import com.example.AirportTransfer.exception.ServiceException;
import com.example.AirportTransfer.model.AirportTransferModel;
import com.example.AirportTransfer.model.dto.AddAirportTransferTypeRequest;
import com.example.AirportTransfer.model.dto.SuccessResponse;
import com.example.AirportTransfer.repository.AirportTransferRepository;
import com.example.AirportTransfer.service.AirportOnewayTripService;




@Service
public class AirportTransferImpl implements AirportOnewayTripService {
	private static Logger logger = LogManager
			.getLogger(AirportTransferImpl.class);

	@Autowired
	private AirportTransferRepository airportTransferRepository;
	
	@Autowired
	private JacksonConfig jacksonConfig;
	
	@Autowired
	private StringToDateConverter converter;



	
	@Override
	public ResponseEntity addAgreementType(AddAirportTransferTypeRequest argType) {
		logger.info("Adding new Agreement Type");
		SuccessResponse response= new SuccessResponse();
		AirportTransferModel modle= new AirportTransferModel(); 
		
		try{
		modle.setDropOff(argType.getDropOff());
		modle.setFlightNumber(argType.getFlightNumber());
		modle.setFlightTime(argType.getFlightTime());
		modle.setOutboundTripFare(argType.getOutboundTripFare());
		modle.setPassengers(argType.getPassengers());
		modle.setPickup(argType.getPickup());
		modle.setPromoCode(argType.getPromoCode());
		modle.setTripDate(converter.converter(argType.getTripDate()));
		modle.setTripTime(argType.getTripTime());
		modle.setTripType(argType.getTripType());
		modle.setVehicleType(argType.getVehicleType());

		

			
			
			this.airportTransferRepository.save(modle);
			logger.info("AirportTransfer is successful");
			response.setDescription("AirportTransfer is successful");
			response.setStatus("200");
			return new ResponseEntity(response, HttpStatus.OK);
			//return this.agreementTypeRepository.findAll();

		}catch(IndexOutOfBoundsException e) {
			logger.error("index out of bound  ", e);
			response.setDescription("index out of bound  ");
			response.setStatus("500");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
		}catch(NumberFormatException e) {
			logger.error("Invalid airport  or Invalid version ",e);
			response.setDescription("Invalid airport  or Invalid version");
			response.setStatus("500");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}catch(BadRequestException e) {
			logger.error(e.getErrorMessage(),e);
			response.setDescription(e.getErrorMessage());
			response.setStatus("400");
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
				
		}catch(ServiceException e) {
			logger.error(e.getErrorMessage(),e);
			response.setStatus(Integer.toString(e.getStatus().value()));
			response.setDescription(e.getErrorMessage());
			return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
			
		}catch(Exception e ) {
			logger.error("error occured while posting document ",e);
			response.setDescription("error occured while posting document");
			response.setStatus("500");
			return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}


}
