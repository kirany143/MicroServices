package com.maybank.kirany.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue
	private long id;

	private String sortCode;

	private String accountNumber;

	private double currentBalance;

	private String bankName;

	private String ownerName;

	private String icNumber;

	private String motherName;

	private String phoneNumber;

	private String companyName;

	protected Account() {

	}

	public Account(String sortCode, String accountNumber, double currentBalance, String bankName, String ownerName,
			String icNumber, String motherName, String phoneNumber, String companyName) {
		super();
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
		this.icNumber = icNumber;
		this.motherName = motherName;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}

	public Account(long id, String sortCode, String accountNumber, double currentBalance, String bankName,
			String ownerName, String icNumber, String motherName, String phoneNumber, String companyName) {
		super();
		this.id = id;
		this.sortCode = sortCode;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.bankName = bankName;
		this.ownerName = ownerName;
		this.icNumber = icNumber;
		this.motherName = motherName;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", sortCode=" + sortCode + ", accountNumber=" + accountNumber + ", currentBalance="
				+ currentBalance + ", bankName=" + bankName + ", ownerName=" + ownerName + ", icNumber=" + icNumber
				+ ", motherName=" + motherName + ", phoneNumber=" + phoneNumber + ", companyName=" + companyName + "]";
	}

	/*
	 * public Account(String bankName, String ownerName, String generateSortCode,
	 * String generateAccountNumber, double currentBalance) { this.sortCode =
	 * generateSortCode; this.accountNumber = generateAccountNumber;
	 * this.currentBalance = currentBalance; this.bankName = bankName;
	 * this.ownerName = ownerName; }
	 * 
	 * public Account(long id, String sortCode, String accountNumber, double
	 * currentBalance, String bankName, String ownerName) { this.id = id;
	 * this.sortCode = sortCode; this.accountNumber = accountNumber;
	 * this.currentBalance = currentBalance; this.bankName = bankName;
	 * this.ownerName = ownerName; }
	 * 
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 * 
	 * public String getSortCode() { return sortCode; }
	 * 
	 * public void setSortCode(String sortCode) { this.sortCode = sortCode; }
	 * 
	 * public String getAccountNumber() { return accountNumber; }
	 * 
	 * public void setAccountNumber(String optional) { this.accountNumber =
	 * optional; }
	 * 
	 * public double getCurrentBalance() { return currentBalance; }
	 * 
	 * public void setCurrentBalance(double currentBalance) { this.currentBalance =
	 * currentBalance; }
	 * 
	 * public String getOwnerName() { return ownerName; }
	 * 
	 * public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
	 * 
	 * public String getBankName() { return bankName; }
	 * 
	 * public void setBankName(String bankName) { this.bankName = bankName; }
	 * 
	 * @Override public String toString() { return "Account{" + "id=" + id +
	 * ", sortCode='" + sortCode + '\'' + ", accountNumber='" + accountNumber + '\''
	 * + ", currentBalance=" + currentBalance + ", bankName='" + bankName + '\'' +
	 * ", ownerName='" + ownerName + '\'' + '}'; }
	 */
}
