package com.society.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.society.model.BillHead;

@Repository("billHeadRepository")
public interface BillHeadRepository extends JpaRepository<BillHead,Integer> {
	BillHead findByName(String name);
	List<BillHead> findByNameNotNull();
}
