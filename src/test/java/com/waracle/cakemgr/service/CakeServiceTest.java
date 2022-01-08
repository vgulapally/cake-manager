package com.waracle.cakemgr.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.waracle.cakemgr.entity.CakeEntity;
import com.waracle.cakemgr.repository.CakeRepository;

@ExtendWith(MockitoExtension.class)
class CakeServiceTest {
	
	@Mock
	private CakeRepository cakeRepository;
	
	@InjectMocks
	private DefaultCakeService cakeService;

	@Test
	public void should_get_all_cakes() {
		CakeEntity newCake = new CakeEntity(5L, "test", "test desc", "test image");
		when(cakeRepository.findAll()).thenReturn(List.of(newCake));
		List<CakeEntity> cakes = cakeService.getAll();
		assertAll(() -> assertEquals(1, cakes.size()),
				() -> assertEquals(newCake.getId(), cakes.get(0).getId()),
				() -> assertEquals(newCake.getTitle(), cakes.get(0).getTitle()),
				() -> assertEquals(newCake.getDescription(), cakes.get(0).getDescription()),
				() -> assertEquals(newCake.getImage(), cakes.get(0).getImage())
				);
	}
	
	@Test
	public void should_create_new_cake() {
		CakeEntity newCake = new CakeEntity(5L, "test", "test desc", "test image");
		when(cakeRepository.save(ArgumentMatchers.any())).thenReturn(newCake);
		CakeEntity cake = cakeService.createCake(newCake);
		assertAll(
				() -> assertEquals(newCake.getId(), cake.getId()),
				() -> assertEquals(newCake.getTitle(), cake.getTitle()),
				() -> assertEquals(newCake.getDescription(), cake.getDescription()),
				() -> assertEquals(newCake.getImage(), cake.getImage())
				);
	}

}
