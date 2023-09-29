package com.bezkoder.spring.datajpa.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.datajpa.model.Converter;
import com.bezkoder.spring.datajpa.repository.ConverterRepository;

@Service
public class ConverterService {
    private ConverterRepository converterRepository;

    public Converter store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Converter Converter = new Converter(fileName, file.getContentType(), fileName, file.getBytes());

    return converterRepository.save(Converter);
  }
  public Converter getFile(String id) {
    return converterRepository.findById(id).get();
  }
  
  public Stream<Converter> getAllFiles() {
    return converterRepository.findAll().stream();
  }
}
