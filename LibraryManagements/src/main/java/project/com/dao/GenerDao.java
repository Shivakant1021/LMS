package project.com.dao;

import project.com.model.Gener;

public interface GenerDao {
	Gener addGener(Gener gener);
	Gener findGenreByName(Gener generName);

}
