package com.maybank.kirany.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.maybank.kirany.controllers.AccountRestController;
import com.maybank.kirany.services.AccountService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountRestController.class)
class AccountRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private AccountService accountService;

	@Test
	void givenMissingInput_whenCheckingBalance_thenVerifyBadRequest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/maybank-api/v1/accounts").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void givenInvalidInput_whenCheckingBalance_thenVerifyBadRequest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/maybank-api/v1/accounts")
				.content("{\"sortCode\": \"53-68\",\"accountNumber\": \"78934\"}")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	

}
