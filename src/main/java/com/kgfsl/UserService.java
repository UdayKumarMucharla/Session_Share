package com.kgfsl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
	
	@Autowired
	public UserDao userDao;
	
	

	public  void setUserService(UserDao userDao){
		this.userDao = userDao;
	}

	public UserModel fetchByuserId(int id) {
		return userDao.fetchById(id);
	}
	
	public UserModel fetchByuserEmail(String Email) {
		return userDao.fetchByEmail(Email);
	}

	@SuppressWarnings("unchecked")
	public List fetchAll() {

		return userDao.fetchAll();
	}

	public void updateUser(UserModel user) {

		userDao.updateUser(user);
	}

	public void save(UserModel user) {
	
		 userDao.create(user);
	}

	public void deleteById(Integer id) {
	
		userDao.delete(id);
	}

	public void updateTable(String column, String dataType) {
		userDao.updateTable(column,dataType);
		
	}

}
