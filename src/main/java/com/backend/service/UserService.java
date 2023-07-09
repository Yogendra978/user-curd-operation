package com.backend.service;

import java.util.List;

import com.backend.entity.User;

public interface UserService {
	public User UserSave(User User);
	
	public List<User> listAll();
	
	public User UpdateUser(User user);
	
	public User getUserById(Long id);
	
	public void deleteUserById(Long id);
}
