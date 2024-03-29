package project.com.service;

import project.com.model.Auther;

public interface AutherService {
	Auther addAuther(Auther auther);
	Auther getAutherById(int autherId);
	Auther getAutherByName(String autherName);
}
