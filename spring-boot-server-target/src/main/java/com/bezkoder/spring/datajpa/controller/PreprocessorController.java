package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bezkoder.spring.datajpa.repository.PreprocessorRepository;
import com.bezkoder.spring.datajpa.model.Preprocessor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PreprocessorController {

    @Autowired
    PreprocessorRepository preprocessorRepository;

    @GetMapping("/preprocessors")
	public ResponseEntity<List<Preprocessor>> getAllPreprocessors(@RequestParam(required = false) String name) {
		try {
			List<Preprocessor> preprocessors = new ArrayList<Preprocessor>();

			if (name == null)
				preprocessorRepository.findAll().forEach(preprocessors::add);
			else
				preprocessorRepository.findByNameContaining(name).forEach(preprocessors::add);

			if (preprocessors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(preprocessors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    @GetMapping("/preprocessors/{id}")
	public ResponseEntity<Preprocessor> getPreprocessorById(@PathVariable("id") long id) {
		Optional<Preprocessor> preprocessorData = preprocessorRepository.findById(id);

		if (preprocessorData.isPresent()) {
			return new ResponseEntity<>(preprocessorData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    @PostMapping("/preprocessors")
	public ResponseEntity<Preprocessor> createPreprocessor(@RequestBody Preprocessor preprocessor) {
		try {
			Preprocessor _preprocessor= preprocessorRepository
					.save(new Preprocessor(0, preprocessor.getName(), preprocessor.getArchitecture() , preprocessor.getCore(), preprocessor.getChip(),preprocessor.getDescription() , preprocessor.isPublished()));
			return new ResponseEntity<>(_preprocessor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/preprocessors/{id}")
	public ResponseEntity<Preprocessor> updatePreprocessor(@PathVariable("id") long id, @RequestBody Preprocessor preprocessor) {
		Optional<Preprocessor> preprocessortData = preprocessorRepository.findById(id);

		if (preprocessortData.isPresent()) {
				Preprocessor _preprocessor = preprocessortData.get();
			_preprocessor.setName(preprocessor.getName());
			_preprocessor.setDescription(preprocessor.getDescription());
			_preprocessor.setPublished(preprocessor.isPublished());
			return new ResponseEntity<>(preprocessorRepository.save(_preprocessor), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/preprocessors/{id}")
	public ResponseEntity<HttpStatus> deletePreprocessor(@PathVariable("id") long id) {
		try {
			preprocessorRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/preprocessors")
	public ResponseEntity<HttpStatus> deleteAllPreprocessor() {
		try {
			preprocessorRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@GetMapping("/preprocessors/published")
	public ResponseEntity<List<Preprocessor>> findByPublished() {
		try {
			List<Preprocessor> preprocessors = preprocessorRepository.findByPublished(true);

			if (preprocessors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(preprocessors, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
}
