package com.genre.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genre.service.model.Genre;
import com.genre.service.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	public List<Genre> getAll(){
		return genreRepository.findAll();
	}
	
	public Genre getBandById(int id) {
		return genreRepository.findById(id).orElse(null);
	}
	
	public Genre save(Genre genre) {
		Genre newGenre = genreRepository.save(genre);
		return newGenre;
	}
	
}
