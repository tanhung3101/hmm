package com.nop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nop.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

	@Query(value= "Select a from Bill a where a.month=:month")
	public List<Bill> findBillByMonth(@Param("month") String month);
}
