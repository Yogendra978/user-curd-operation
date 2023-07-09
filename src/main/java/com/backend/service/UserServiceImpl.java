package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.User;
import com.backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User  UserSave(User User) {
		com.backend.entity.User save = userRepository.save(User);
		return save;
		
	}

	@Override
	public List<User> listAll() {
		List<User> findAll = userRepository.findAll();
		return findAll;
	}

	@Override
	public User UpdateUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.findById(id).get();
		return user;
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
		
	}

}
