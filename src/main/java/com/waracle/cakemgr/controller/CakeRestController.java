package com.waracle.cakemgr.controller;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.entity.CakeEntity;
import com.waracle.cakemgr.service.CakeService;

@RequestMapping(path = "/cake-mgr")
@RestController
public class CakeRestController {
	
	private final CakeService cakeService;
	private final ObjectMapper objectMapper;

	@Autowired
	public CakeRestController(CakeService cakeService, ObjectMapper objectMapper) {
		this.cakeService = cakeService;
		this.objectMapper = objectMapper;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CakeEntity> getAll() {
		return cakeService.getAll();
	}
	
	@GetMapping("/cakes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<InputStreamResource> downloadCakes() throws JsonProcessingException {
		List<CakeEntity> cakes=  cakeService.getAll();
		
		byte[] buf = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(cakes);

		return ResponseEntity
		        .ok()
		        .contentLength(buf.length)
		        .header("Content-Disposition", "attachment; filename=\"cakes.json\"")
		        .contentType(MediaType.parseMediaType("application/octet-stream"))
		        .body(new InputStreamResource(new ByteArrayInputStream(buf)));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CakeEntity create(@RequestBody CakeEntity cakeEntity) {
		return cakeService.createCake(cakeEntity);
	}
	
	

}
