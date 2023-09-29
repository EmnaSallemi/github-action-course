package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bezkoder.spring.datajpa.model.Preprocessor;

public interface PreprocessorRepository  extends JpaRepository<Preprocessor, Long>{
    
    List<Preprocessor> findByPublished(boolean published);
	List<Preprocessor> findByNameContaining(String name);
	Optional<Preprocessor> findByName(String name);
}
