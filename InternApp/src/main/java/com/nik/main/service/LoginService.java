package com.nik.main.service;

import com.nik.main.model.User;

public interface LoginService {

	public boolean isExists(User user, String password);
}
