package com.example.AirportTransfer.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirportTransfer.Utils.ApplicationUtils;
import com.example.AirportTransfer.Utils.JacksonConfig;
import com.example.AirportTransfer.model.dto.AddAirportTransferTypeRequest;
import com.example.AirportTransfer.service.AirportOnewayTripService;



@RestController
@RequestMapping(path = "/airportTransfer")
public class AirportTransferController {
	private static Logger logger = LogManager.getLogger(AirportTransferController.class);

	@Autowired
	private AirportOnewayTripService airportonewayTripService;
	
	@Autowired
	private JacksonConfig jacksonConfig;
	
	String user = "TEST";


	@PostMapping(path = "/airport-oneway-service/airportoneway/add", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity addAirportTransferType(@RequestBody AddAirportTransferTypeRequest agrType) {


		long startTime = System.currentTimeMillis();

		// Add Logging context information
		ThreadContext.put("id", UUID.randomUUID().toString());
		ThreadContext.put("apiName", "/masterdata/agreement/save");
		ThreadContext.put("user", user);

		logger.info("START : Controller : Adding New Agreement Type : argType "+jacksonConfig.convertToJson(agrType));

		ResponseEntity response =airportonewayTripService.addAgreementType(agrType);
	
		logger.info("RESPONSE : " + jacksonConfig.convertToJson(response.getBody()));
		logger.debug("END : Controller POST method : Elapsed Time (ms)= " + ApplicationUtils.getTimeDiff(startTime));
		ThreadContext.clearMap();
		return response;
	}
	

}
