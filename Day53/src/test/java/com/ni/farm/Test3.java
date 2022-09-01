package com.ni.farm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ni.farm.controllers.FarmerController_V2;
import com.ni.farm.services.FarmerService_V2;

// Whern our development of any dependent components is incomplete
// but we still want to test the comnpleted parts, 
// mocking the incomplete component will get our job done!

//@WebMvcTest(FarmerController_V2.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Test3 {
	@LocalServerPort
	private int port;
	
	@Autowired
	MockMvc mockMvc; // MockMvc simulates a browser.
	
	@MockBean
	FarmerService_V2 farmerService;	
	
	@Test
	public void checkSingleFarmer_isReturned_Succesfully() throws Exception {
		Farmer f1 = new Farmer("name1234",23,"asas@asas.com",2);
		
		when(farmerService.getFarmerById(1)).thenReturn(f1);
		
		mockMvc.perform(get("/jpa/singlefarmer/1"))
		//check the response was returned successfully
		.andExpect(status().isOk())
		//check the response has content we expect
		.andExpect(content().string(containsString("name1234")));
	}

}
