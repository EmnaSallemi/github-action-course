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

import com.bezkoder.spring.datajpa.model.Target;
import com.bezkoder.spring.datajpa.repository.TargetRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TargetController {

	@Autowired
	TargetRepository targetRepository;

	@GetMapping("/targets")
	public ResponseEntity<List<Target>> getAllTargetsByName(
				@RequestParam(required = false) String name,
				@RequestParam(required = false) String chip) {
					try {
						List<Target> targets = new ArrayList<>();
				
						if (name == null && chip == null) {
							targetRepository.findAll().forEach(targets::add);
						} else if (name != null && chip == null) {
							targetRepository.findByNameContaining(name).forEach(targets::add);
						} else if (name == null && chip != null) {
							targetRepository.findByChipContaining(chip).forEach(targets::add);
						} else {
							targetRepository.findByNameContainingAndChipContaining(name, chip).forEach(targets::add);
						}
				
						if (targets.isEmpty()) {
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						}
				
						return new ResponseEntity<>(targets, HttpStatus.OK);
					} catch (Exception e) {
						return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
					}
	}


	@GetMapping("/targets/{id}")
	public ResponseEntity<Target> getTargetById(@PathVariable("id") long id) {
		Optional<Target> targetData = targetRepository.findById(id);

		if (targetData.isPresent()) {
			return new ResponseEntity<>(targetData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/targets")
	public ResponseEntity<Target> createTarget(@RequestBody Target target) {
		try {
			Target _target = targetRepository
					.save(new Target(0, target.getName(), target.getArchitecture() , target.getCore(), target.getChip(),target.getDescription() , target.isPublished()));
			return new ResponseEntity<>(_target, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/targets/{id}")
	public ResponseEntity<Target> updateTarget(@PathVariable("id") long id, @RequestBody Target target) {
		Optional<Target> targetData = targetRepository.findById(id);

		if (targetData.isPresent()) {
			Target _target = targetData.get();
			_target.setName(target.getName());
			_target.setChip(target.getChip());
			_target.setCore(target.getCore());
			_target.setArchitecture(target.getArchitecture());
			_target.setPublished(target.isPublished());
			return new ResponseEntity<>(targetRepository.save(_target), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/targets/{id}")
	public ResponseEntity<HttpStatus> deleteTarget(@PathVariable("id") long id) {
		try {
			targetRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/targets")
	public ResponseEntity<HttpStatus> deleteAllTargets() {
		try {
			targetRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/targets/published")
	public ResponseEntity<List<Target>> findByPublished() {
		try {
			List<Target> targets = targetRepository.findByPublished(true);

			if (targets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(targets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
