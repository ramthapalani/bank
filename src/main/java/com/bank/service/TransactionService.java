package com.bank.service;

import com.bank.dto.FundTransferDto;
import com.bank.dto.TransactionDto;


public interface TransactionService {
	 FundTransferDto fundTransfer(TransactionDto transactionDto);

}
