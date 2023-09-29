package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Powertrace;

public interface PowertraceRepository extends JpaRepository<Powertrace, Long> {
	List<Powertrace> findByPublished(boolean published);
	List<Powertrace> findByNameContaining(String name);
	Optional<Powertrace> findByName(String name);
}
