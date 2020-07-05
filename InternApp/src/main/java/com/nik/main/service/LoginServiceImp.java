package com.nik.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nik.main.dao.LoginRepo;
import com.nik.main.model.User;

@RestController
public class LoginServiceImp implements LoginService{

	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public boolean isExists(User user, String password) {
		if(loginRepo.isUserAndPasswordExits(user, password)!=null) {
			return true;
		}else {
			return false;
		}
	}

}
