package com.bank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.controller.SummaryController;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.dto.SummaryDto;
import com.bank.entity.Account;
import com.bank.entity.Transaction;

@Service
public class SummaryServiceImpl implements SummaryService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SummaryController.class);

	@Autowired
	AccountRepository  accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public SummaryDto accountSummaryDetails(Long custId) {
		
		SummaryDto summaryDto = new SummaryDto();
		List<Transaction> transactions = transactionRepository.findByFromAccount(custId);
		Account account= accountRepository.findByAccountNumber(custId);
	
		System.out.println("**************************"+account);
		
		summaryDto.setAccount(account);
		summaryDto.setTransactions(transactions);

		return summaryDto;
	}

}
