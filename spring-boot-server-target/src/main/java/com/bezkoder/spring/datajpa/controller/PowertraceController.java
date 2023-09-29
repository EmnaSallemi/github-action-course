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

import com.bezkoder.spring.datajpa.model.Powertrace;

import com.bezkoder.spring.datajpa.repository.PowertraceRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PowertraceController {
    
	@Autowired
	PowertraceRepository powertraceRepository;

	@GetMapping("/powertraces")
	public ResponseEntity<List<Powertrace>> getAllPowertraces(@RequestParam(required = false) String name) {
		try {
			List<Powertrace> powertraces = new ArrayList<Powertrace>();

			
			if (name == null)
				powertraceRepository.findAll().forEach(powertraces::add);
			else
				powertraceRepository.findByNameContaining(name).forEach(powertraces::add);

			if (powertraces.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(powertraces, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/powertraces/{id}")
	public ResponseEntity<Powertrace> getPowertraceById(@PathVariable("id") long id) {
		Optional<Powertrace> powertraceData = powertraceRepository.findById(id);

		if (powertraceData.isPresent()) {
			return new ResponseEntity<>(powertraceData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/powertraces")
	public ResponseEntity<Powertrace> createPowertrace(@RequestBody Powertrace powertrace) {
		try {
			Powertrace _powertrace = powertraceRepository
					.save(new Powertrace(0, powertrace.getName(), powertrace.getArchitecture() , powertrace.getCore(), powertrace.getChip(),powertrace.getDescription() , powertrace.isPublished()));
			return new ResponseEntity<>(_powertrace, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/powertraces/{id}")
	public ResponseEntity<Powertrace> updatePowertrace(@PathVariable("id") long id, @RequestBody Powertrace powertrace) {
		Optional<Powertrace> powertraceData = powertraceRepository.findById(id);

		if (powertraceData.isPresent()) {
			Powertrace _powertrace = powertraceData.get();
			_powertrace.setName(powertrace.getName());
			_powertrace.setDescription(powertrace.getDescription());
			_powertrace.setPublished(powertrace.isPublished());
			return new ResponseEntity<>(powertraceRepository.save(_powertrace), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/powertraces/{id}")
	public ResponseEntity<HttpStatus> deletePowertrace(@PathVariable("id") long id) {
		try {
			powertraceRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/powertraces")
	public ResponseEntity<HttpStatus> deleteAllPowertraces() {
		try {
			powertraceRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/powertraces/published")
	public ResponseEntity<List<Powertrace>> findByPublished() {
		try {
			List<Powertrace> powertraces = powertraceRepository.findByPublished(true);

			if (powertraces.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(powertraces, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
