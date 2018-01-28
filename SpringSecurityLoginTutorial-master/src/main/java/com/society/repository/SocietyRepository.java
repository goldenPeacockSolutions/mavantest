package com.society.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.society.model.Society;

@Repository("societyRepository")
public interface SocietyRepository extends JpaRepository<Society, Long> {

	Society findByName(String name);
	// Society findByEmail(String email);
    List<Society> findByNameNotNull();
}
