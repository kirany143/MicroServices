package com.maybank.kirany.utils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Objects;

public class CreateAccountInput {

	@NotBlank(message = "Bank name is mandatory")
	private String bankName;

	@NotBlank(message = "Owner name is mandatory")
	private String ownerName;

	@NotBlank(message = "Identity Card number is mandatory")
	@Size(min = 6, max = 10, message = "IC number should be 6 to 10 digits")
	private String icNumber;

	@NotBlank(message = "mother name is mandatory")
	private String motherName;

	@NotBlank(message = "Phone number is mandatory")
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digits")
	private String phoneNumber;

	@NotBlank(message = "Company name is mandatory")
	private String companyName;

	public CreateAccountInput() {
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
	public int hashCode() {
		return Objects.hash(bankName, companyName, icNumber, motherName, ownerName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAccountInput other = (CreateAccountInput) obj;
		return Objects.equals(bankName, other.bankName) && Objects.equals(companyName, other.companyName)
				&& Objects.equals(icNumber, other.icNumber) && Objects.equals(motherName, other.motherName)
				&& Objects.equals(ownerName, other.ownerName) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "CreateAccountInput [bankName=" + bankName + ", ownerName=" + ownerName + ", icNumber=" + icNumber
				+ ", motherName=" + motherName + ", phoneNumber=" + phoneNumber + ", companyName=" + companyName + "]";
	}

	/*
	 * public String getBankName() { return bankName; }
	 * 
	 * public void setBankName(String bankName) { this.bankName = bankName; }
	 * 
	 * public String getOwnerName() { return ownerName; }
	 * 
	 * public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
	 */

	/*
	 * @Override public String toString() { return "CreateAccountInput{" +
	 * "bankName='" + bankName + '\'' + ", ownerName='" + ownerName + '\'' + '}'; }
	 * 
	 * @Override public boolean equals(Object o) { if (this == o) return true; if (o
	 * == null || getClass() != o.getClass()) return false; CreateAccountInput that
	 * = (CreateAccountInput) o; return Objects.equals(bankName, that.bankName) &&
	 * Objects.equals(ownerName, that.ownerName); }
	 * 
	 * @Override public int hashCode() { return Objects.hash(bankName, ownerName); }
	 */
}
