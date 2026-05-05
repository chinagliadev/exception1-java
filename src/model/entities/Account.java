package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account(Integer number, String holder, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.withDrawLimit = withDrawLimit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	
	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	
	public void deposit(double amount) throws DomainException
	{
		if(amount <= 0) 
		{
			throw new DomainException("Invalid amount ! value below zero");
		}
		
		this.balance = amount;
	}
	
	public void withDraw(double amount) throws DomainException 
	{
		
		if(amount > this.balance) 
		{
			throw new DomainException("Not enough balance");
		}
		
		if(amount > this.withDrawLimit) 
		{
			throw new DomainException("The amound exceeds withdraw limit");
		}
		
		double newBalance = this.balance -= amount;
		
		System.out.println("New Balance: " +  newBalance);
	}
}
