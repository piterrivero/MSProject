package com.band.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.band.service.entity.Band;
import com.band.service.service.BandService;

import model.Disc;
import model.Genre;

@RestController
@RequestMapping("/band")
public class BandController {

	@Autowired
	private BandService bandService;
	
	@GetMapping
	public ResponseEntity<List<Band>> listBands(){
		List<Band> bands = bandService.getAll();
		if (bands.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(bands);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Band> getBand(@PathVariable("id") int id){
		Band band = bandService.getBandById(id);
		if (band == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(band);
	}
	
	@PostMapping
	public ResponseEntity<Band> saveBand(@RequestBody Band band){
		Band newBand = bandService.save(band);
		return ResponseEntity.ok(newBand);
	}
	
	@PostMapping("/disc/{idBand}")
	public ResponseEntity<Disc> saveDisc(@PathVariable("idBand") int idBand, @RequestBody Disc disc){
		disc.setIdBand(idBand);
		Disc newDisc = bandService.saveDisc(disc);
		return ResponseEntity.ok(newDisc);
	} 
	
	@GetMapping("/genre/{idGenre}")
	public ResponseEntity<Genre> getGenreById(@PathVariable("idGenre") long idGenre){
		Genre genre = bandService.getGenreById(idGenre);
		return ResponseEntity.ok(genre);
	}
	
	@GetMapping("/disc/{idBand}")
	public ResponseEntity<List<Disc>> getDiscsByIdBand(@PathVariable("idBand") long idBand){
		List<Disc> discs = bandService.getDiscByIdBand(idBand);
		return ResponseEntity.ok(discs);
	}
	
	
	
}
