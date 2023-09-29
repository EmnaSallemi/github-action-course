package com.bezkoder.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Converter;

public interface ConverterRepository extends JpaRepository<Converter, String> {
    
}
