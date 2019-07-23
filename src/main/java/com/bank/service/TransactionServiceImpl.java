package com.bank.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.repository.AccountRepository;
import com.bank.dto.FundTransferDto;
import com.bank.dto.TransactionDto;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	public FundTransferDto fundTransfer(TransactionDto transactionReqDTO) {
		
		Long fromAccountId = transactionReqDTO.getFromAccount();
		Long toAccountId = transactionReqDTO.getToAccount();
		BigDecimal transferamount = transactionReqDTO.getTransferAmount();
		
		Account fromAccount = accountRepository.findByAccountNumber(fromAccountId);
		BigDecimal fromAmount = fromAccount.getBalance();
		
		fromAccount.setBalance(fromAmount.subtract(transferamount));
		accountRepository.save(fromAccount);
		
		Account toAccount = accountRepository.findByAccountNumber(toAccountId);
		
		BigDecimal toAmount = toAccount.getBalance();
		toAccount.setBalance(toAmount.add(transferamount));
		accountRepository.save(toAccount);
		
		Date date =  new Date();
		Transaction transaction = new Transaction();
		transaction.setDescription(transactionReqDTO.getDescription());
		transaction.setFromAccount(fromAccountId);
		transaction.setToAccount(toAccountId);
		transaction.setTransactionDate(date);
		transaction.setBalance(fromAccount.getBalance());
		transaction.setTransferAmount(transferamount);
		transactionRepository.save(transaction);
		
		FundTransferDto fundTransaferResponse =  new FundTransferDto();
		fundTransaferResponse.setSetMessage("transferred successfull  ");
		return fundTransaferResponse;
	}
}



