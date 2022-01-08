package com.waracle.cakemgr.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.entity.CakeEntity;

@SpringBootTest
@ActiveProfiles({ "integration" })
@AutoConfigureMockMvc(addFilters = false)
class CakeRestControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void should_return_all_cakes_when_found() throws Exception {

		mockMvc.perform(get("/cake-mgr").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpectAll(
						status().isOk(), jsonPath("$").isArray(),
						jsonPath("$.length()").value(4),
						jsonPath("$[0]").exists(),
						jsonPath("$[1]").exists(),
						jsonPath("$[2]").exists(),
						jsonPath("$[3]").exists()
				);
	}

	@Test
	void should_download_all_cakes_when_found() throws Exception {

		mockMvc.perform(get("/cake-mgr/cakes").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpectAll(status().isOk(),
						content().contentType(MediaType.APPLICATION_OCTET_STREAM),
						header().string("Content-Disposition", "attachment; filename=\"cakes.json\"")); 

	}

	@Test
	@Transactional
	void should_create_new_cake() throws Exception {

		CakeEntity newCake = new CakeEntity(5L, "test", "test desc", "test image");

		mockMvc.perform( 
				post("/cake-mgr") 
						.contentType(MediaType.APPLICATION_JSON_VALUE) 
						.content(objectMapper.writeValueAsString(newCake)))
				.andDo(print())
				.andExpectAll( 
						status().isCreated(), 
						jsonPath("$.id").value(newCake.getId()), 
						jsonPath("$.title").value(newCake.getTitle()),
						jsonPath("$.description").value(newCake.getDescription()),
						jsonPath("$.image").value(newCake.getImage())
				);
	}

}
