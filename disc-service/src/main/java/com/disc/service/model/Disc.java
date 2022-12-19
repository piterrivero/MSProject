package com.disc.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Disc {
	
	@Id
	private int id;
	
	private int idBand;

	private String title;
	
	private String year;

}
