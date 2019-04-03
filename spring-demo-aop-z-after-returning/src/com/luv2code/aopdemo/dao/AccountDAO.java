package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String seviceCode;
	
	// add a new method: findAccounts()
	
	public List<Account> findAccounts(){
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("Jon", "Silver");
		Account temp2 = new Account("Mathu", "Platinium");
		Account temp3 = new Account("Luca", "Gold");
		
		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + " : DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + " : doWorkNigga()");
		return false;
	}

	
	public String getName() {
		System.out.println(getClass() + " : in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : in setName()");
		this.name = name;
	}

	public String getSeviceCode() {
		System.out.println(getClass() + " : in getSeviceCode()");
		return seviceCode;
	}

	public void setSeviceCode(String seviceCode) {
		System.out.println(getClass() + " : in setSeviceCode()");
		this.seviceCode = seviceCode;
	}
	
}
