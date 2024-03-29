package project.com.service;

import project.com.dao.AutherDaoImpl;
import project.com.model.Auther;
import project.com.dao.AutherDao;
public class AutherServiceImpl implements AutherService{
	AutherDao adao =new AutherDaoImpl();
	@Override
	public Auther addAuther(Auther auther) {
		// TODO Auto-generated method stub
		return adao.addAuther(auther);
	}

	@Override
	public Auther getAutherById(int autherId) {
		// TODO Auto-generated method stub
		return adao.getAutherById(autherId);
	}

	@Override
	public Auther getAutherByName(String autherName) {
		// TODO Auto-generated method stub
		return adao.getAutherByName(autherName);
	}

}
