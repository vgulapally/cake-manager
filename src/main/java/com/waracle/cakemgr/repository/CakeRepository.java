package com.waracle.cakemgr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.waracle.cakemgr.entity.CakeEntity;

@Repository
public interface CakeRepository extends JpaRepository<CakeEntity, Long>{

}
