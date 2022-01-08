package com.waracle.cakemgr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.waracle.cakemgr.entity.CakeEntity;
import com.waracle.cakemgr.repository.CakeRepository;

@Service
@Transactional
public class DefaultCakeService implements CakeService {
		
	private final CakeRepository cakeRepository;

	@Autowired
	public DefaultCakeService(CakeRepository cakeRepository) {
		this.cakeRepository = cakeRepository;
	}

	@Override
	public List<CakeEntity> getAll() {
		return cakeRepository.findAll();
	}

	@Override
	public CakeEntity createCake(CakeEntity cakeEntity) {
		return cakeRepository.save(cakeEntity);
	}

}
