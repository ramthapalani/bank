package com.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = -2026907315917388392L;

	private Long custId;
	
	private Long accountNumber;
	
	private BigDecimal balance;
	
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public AccountDto(Long custId, Long accountNumber, BigDecimal balance) {
		super();
		this.custId = custId;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

}

