package com.disc.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disc.service.model.Disc;
import com.disc.service.repository.DiscRepository;

@Service
public class DiscService {

	@Autowired
	private DiscRepository discRepository;
	
	public List<Disc> getAll(){
		return discRepository.findAll();
	}
	
	public Disc getBandById(int id) {
		return discRepository.findById(id).orElse(null);
	}
	
	public Disc save(Disc disc) {
		Disc newDisc = discRepository.save(disc);
		return newDisc;
	}
	
}
