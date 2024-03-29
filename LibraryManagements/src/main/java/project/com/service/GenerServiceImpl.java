package project.com.service;

import project.com.dao.GenerDao;
import project.com.dao.GenerDaoImpl;
import project.com.model.Gener;

public class GenerServiceImpl implements GenerService{
	static GenerDao gdao= new GenerDaoImpl();

	@Override
	public Gener findGenreByName(Gener genreName) {
		// TODO Auto-generated method stub
		return gdao.findGenreByName(genreName);
	}

	public Gener addGener(Gener gener) {
		// TODO Auto-generated method stub
		return gdao.addGener(gener);
	}

	

}
