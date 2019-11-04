package com.example.AirportTransfer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.AirportTransfer.model.dto.AddAirportTransferTypeRequest;


@Service
public interface AirportOnewayTripService {
	

	public ResponseEntity addAgreementType(AddAirportTransferTypeRequest argType);
}
