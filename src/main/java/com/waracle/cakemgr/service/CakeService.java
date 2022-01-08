package com.waracle.cakemgr.service;

import java.util.List;

import com.waracle.cakemgr.entity.CakeEntity;


public interface CakeService {

	List<CakeEntity> getAll();
	
	CakeEntity createCake(CakeEntity cakeEntity);

}
