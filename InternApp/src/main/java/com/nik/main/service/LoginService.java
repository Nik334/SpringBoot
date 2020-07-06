package com.nik.main.service;

import com.nik.main.model.User;
import com.nik.main.model.UserLogin;

public interface LoginService {

	public boolean isExists(User user, String password);
	
	public UserLogin addLogin(UserLogin userLogin);
}
