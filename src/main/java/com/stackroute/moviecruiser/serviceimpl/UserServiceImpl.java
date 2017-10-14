package com.stackroute.moviecruiser.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.UserRepository;
import com.stackroute.moviecruiser.servicecontracts.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUserById(long id) {
		return userRepository.findOne((long) id);
	}

	@Override
	public User deleteUser(User user) {
		userRepository.delete(user);
		return user;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	@Override
	public User deleteUserById(long id) {
		User userToDelete = getUserById(id);
		userRepository.delete(id);
		return userToDelete;
	}

}
