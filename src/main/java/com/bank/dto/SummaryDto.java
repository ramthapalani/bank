package com.bank.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.bank.entity.Account;
import com.bank.entity.Transaction;

public class SummaryDto {
	
	private long custId;

	@OneToOne
	private Account  account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@OneToMany
	private List<Transaction> transactions;

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
	
}
