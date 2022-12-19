package com.band.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Band {

	@Id
	private int id;
	
	private int idGenre;
	
	private String name;
	
	private String country;
	
}
