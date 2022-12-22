package com.genre.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genre.service.entity.Genre;
import com.genre.service.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<Genre>> listBands(){
		List<Genre> genres = genreService.getAll();
		if (genres.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(genres);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genre> getBand(@PathVariable("id") int id){
		Genre genre = genreService.getBandById(id);
		if (genre == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(genre);
	}
	
	@PostMapping
	public ResponseEntity<Genre> saveBand(@RequestBody Genre genre){
		Genre newGenre = genreService.save(genre);
		return ResponseEntity.ok(newGenre);
	}
	
}
