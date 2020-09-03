package com.github.juanlopez.devotest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DevoTestApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("GET /health/rabbit")
	void testGetStatus() throws Exception {
		mockMvc.perform(get("/actuator/health/rabbit"))
				.andExpect(jsonPath("$.status").exists())
				.andExpect(jsonPath("$.status", matchesPattern("DOWN|UP")));
	}

	@Test
	void contextLoads() {
	}

}
