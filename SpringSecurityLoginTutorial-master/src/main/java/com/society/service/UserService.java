package com.society.service;

import com.society.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
