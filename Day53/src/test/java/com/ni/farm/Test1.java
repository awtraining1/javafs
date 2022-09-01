package com.ni.farm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Test1 {

	@LocalServerPort
	private int port;
	
	@Autowired
	MockMvc mockMvc; // MockMvc simulates a browser.

	@Test
	public void checkIndexPage_isReturning_Succesfully() throws Exception {

		mockMvc.perform(get("/"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(containsString("Welcome to Best Farms")));
	}
	
//	@Test
//	public void checkIndexPage_isNotReturning_BadRequest() throws Exception {
//
//		mockMvc.perform(get("/"))
//		.andDo(print()) // prints detailed info about requests and responses
//		.andExpect(status().isBadRequest());
//	}

}
