package com.maybank.kirany.controllers;

import com.maybank.kirany.constants.constants;
import com.maybank.kirany.models.Account;
import com.maybank.kirany.services.AccountService;
import com.maybank.kirany.utils.AccountInput;
import com.maybank.kirany.utils.CreateAccountInput;
import com.maybank.kirany.utils.InputValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("maybank-api/v1")
public class AccountRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountRestController.class);

	private final AccountService accountService;

	@Autowired
	public AccountRestController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkAccountBalance(@Valid @RequestBody AccountInput accountInput) {

		LOGGER.debug("Triggered AccountRestController for check account balance if account present in maybank");

		// Validate input
		if (InputValidator.isSearchCriteriaValid(accountInput)) {
			
			// To retrieve the account information based on accountNumber
			Account account = accountService.getAccount(accountInput.getSortCode(), accountInput.getAccountNumber());

			// Return the account details if account present in may-bank, or warn that no
			// account was found for given input
			if (account == null) {
				return new ResponseEntity<>(constants.NO_ACCOUNT_FOUND, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(account, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(constants.INVALID_SEARCH_CRITERIA, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAccount(@Valid @RequestBody CreateAccountInput createAccountInput) {

		LOGGER.debug("Triggered AccountRestController for createAccount in maybank");

		// Validate input
		if (InputValidator.isCreateAccountCriteriaValid(createAccountInput)) {

			Account account = accountService.createAccount(createAccountInput.getBankName(),
					createAccountInput.getOwnerName(), createAccountInput.getIcNumber(),
					createAccountInput.getMotherName(), createAccountInput.getPhoneNumber(),
					createAccountInput.getCompanyName());

			// String icNumber, String motherName,String phoneNumber, String companyName

			if (account == null) {
				return new ResponseEntity<>(constants.CREATE_ACCOUNT_FAILED, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(account, HttpStatus.OK);
			}
		} else {
			return new ResponseEntity<>(constants.INVALID_INPUT_FOR_ACCOUNT_CREATION, HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
