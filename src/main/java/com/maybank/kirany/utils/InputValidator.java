package com.maybank.kirany.utils;

import com.maybank.kirany.constants.constants;

public class InputValidator {

	public static boolean isSearchCriteriaValid(AccountInput accountInput) {

		return constants.SORT_CODE_PATTERN.matcher(accountInput.getSortCode()).find()
				&& constants.ACCOUNT_NUMBER_PATTERN.matcher(accountInput.getAccountNumber()).find();
	}

	public static boolean isAccountNoValid(String accountNo) {
		return constants.ACCOUNT_NUMBER_PATTERN.matcher(accountNo).find();
	}

	public static boolean isCreateAccountCriteriaValid(CreateAccountInput createAccountInput) {
		return (!createAccountInput.getBankName().isBlank() && !createAccountInput.getOwnerName().isBlank()
				&& !createAccountInput.getIcNumber().isBlank() && !createAccountInput.getPhoneNumber().isBlank()
				&& !createAccountInput.getMotherName().isBlank() && !createAccountInput.getCompanyName().isBlank());
	}

}
