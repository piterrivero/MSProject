package com.band.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.band.service.model.Band;
import com.band.service.repository.BandRepository;

@Service
public class BandService {

	@Autowired
	private BandRepository bandRepository;
	
	public List<Band> getAll(){
		return bandRepository.findAll();
	}
	
	public Band getBandById(int id) {
		return bandRepository.findById(id).orElse(null);
	}
	
	public Band save(Band band) {
		Band newBand = bandRepository.save(band);
		return newBand;
	}
	
}
