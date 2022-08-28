package com.maybank.kirany.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.maybank.kirany.models.Account;
import com.maybank.kirany.repositories.AccountRepository;
import com.maybank.kirany.services.AccountService;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

	@Mock
	private AccountRepository accountRepository;

	public AccountService underTest;

	@BeforeEach
	void setUp() {
		underTest = new AccountService(accountRepository);
	}

	@Test
	void shouldReturnAccountBySortCodeAndAccountNumberWhenPresent() {
		var account = new Account(1L, "53-68-92", "78901234", 10.1, "Malayan Bank berhad", "Kiran Yennamadala",
				"12345678", "Lakshmi", "1234567890", "DBS");
		when(accountRepository.findBySortCodeAndAccountNumber("53-68-92", "78901234")).thenReturn(Optional.of(account));
		var result = underTest.getAccount("53-68-92", "78901234");
		assertThat(result.getOwnerName()).isEqualTo(account.getOwnerName());
		assertThat(result.getSortCode()).isEqualTo(account.getSortCode());
		assertThat(result.getAccountNumber()).isEqualTo(account.getAccountNumber());
	}

	@Test
	void shouldReturnNullWhenAccountBySortCodeAndAccountNotFound() {
		when(accountRepository.findBySortCodeAndAccountNumber("53-68-92", "78901234")).thenReturn(Optional.empty());

		var result = underTest.getAccount("53-68-92", "78901234");

		assertThat(result).isNull();
	}

}
