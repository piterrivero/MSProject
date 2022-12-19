package com.disc.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disc.service.model.Disc;
import com.disc.service.service.DiscService;

@RestController
@RequestMapping("/disc")
public class DiscController {

	@Autowired
	private DiscService discService;
	
	@GetMapping
	public ResponseEntity<List<Disc>> listBands(){
		List<Disc> discs = discService.getAll();
		if (discs.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(discs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Disc> getBand(@PathVariable("id") int id){
		Disc disc = discService.getBandById(id);
		if (disc == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(disc);
	}
	
	@PostMapping
	public ResponseEntity<Disc> saveBand(@RequestBody Disc disc){
		Disc newDisc = discService.save(disc);
		return ResponseEntity.ok(newDisc);
	}
	
}
