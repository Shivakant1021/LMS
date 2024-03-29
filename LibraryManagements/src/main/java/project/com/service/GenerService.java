package project.com.service;

import project.com.model.Gener;

public interface GenerService {
	Gener addGener(Gener gener);
	Gener findGenreByName(Gener genreName);

	
}
