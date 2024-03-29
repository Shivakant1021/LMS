package project.com.dao;

import project.com.model.Auther;

public interface AutherDao {
	Auther addAuther(Auther auther);
	Auther getAutherById(int autherId);
	Auther getAutherByName(String autherName);
	
}
