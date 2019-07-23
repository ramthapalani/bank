package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.FundTransferDto;
import com.bank.dto.TransactionDto;
import com.bank.service.TransactionServiceImpl;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
		@Autowired
		TransactionServiceImpl  transactionServiceImpl;
		
		@PostMapping(value="/transaction")
		public ResponseEntity<FundTransferDto> fundTransfer(@RequestBody TransactionDto transactionDto)
		{
			FundTransferDto fundTransferResponse=transactionServiceImpl.fundTransfer(transactionDto);
			return new ResponseEntity<>(fundTransferResponse,HttpStatus.OK) ;
			
		}

}
