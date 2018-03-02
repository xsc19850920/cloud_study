package com.genpact.cloud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;



public class SimpleUser implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String username;
	
	private int age;
	
	private Date birth;
	
	private BigDecimal balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public void setBirth(String birth) {
		try {
			this.birth = DateUtils.parseDate(birth, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			this.birth  = null;
			e.printStackTrace();
		}
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
