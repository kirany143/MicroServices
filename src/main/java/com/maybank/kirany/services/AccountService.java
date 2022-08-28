package com.maybank.kirany.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maybank.kirany.models.Account;
import com.maybank.kirany.repositories.AccountRepository;
import com.maybank.kirany.utils.CodeGenerator;

@Service
public class AccountService {

	private final AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Account getAccount(String sortCode, String accountNumber) {
		Optional<Account> account = accountRepository.findBySortCodeAndAccountNumber(sortCode, accountNumber);

		return account.orElse(null);
	}

	public Account getAccount(String accountNumber) {
		Optional<Account> account = accountRepository.findByAccountNumber(accountNumber);

		return account.orElse(null);

	}

	public Account createAccount(String bankName, String ownerName, String icNumber, String motherName,
			String phoneNumber, String companyName) {

		CodeGenerator codeGenerator = new CodeGenerator();
		Account newAccount = new Account(codeGenerator.generateSortCode(), codeGenerator.generateAccountNumber(), 0.00,
				bankName, ownerName, icNumber, motherName, phoneNumber, companyName);

		return accountRepository.save(newAccount);
	}
}
