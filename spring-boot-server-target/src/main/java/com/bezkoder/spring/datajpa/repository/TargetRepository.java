package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Target;

public interface TargetRepository extends JpaRepository<Target, Long> {
	List<Target> findByPublished(boolean published);
	List<Target> findByNameContaining(String name);
	Optional<Target> findByName(String name);
    Iterable<Target> findByChipContaining(String chip);
    Iterable<Target> findByNameContainingAndChipContaining(String name, String chip);
}
