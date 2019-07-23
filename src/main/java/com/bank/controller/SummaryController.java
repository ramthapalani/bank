package com.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.SummaryDto;
import com.bank.service.SummaryService;

@RestController
@RequestMapping("/summary")
@CrossOrigin

public class SummaryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryController.class);

	@Autowired
	private SummaryService summaryService;
	
	@GetMapping("/{custId}")
	public ResponseEntity<SummaryDto> accountSummary(@PathVariable Long custId){
		
		LOGGER.debug("accountSummary of customer id :"+custId);
		
		SummaryDto registrationDTO=summaryService.accountSummaryDetails(custId);
		return new ResponseEntity<>(registrationDTO,HttpStatus.OK);
	}

}

