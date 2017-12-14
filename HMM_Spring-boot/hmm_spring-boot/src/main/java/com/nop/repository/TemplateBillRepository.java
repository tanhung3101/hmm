package com.nop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nop.entity.TemplateBill;

@Repository
public interface TemplateBillRepository extends JpaRepository<TemplateBill, Long> {

	
}
