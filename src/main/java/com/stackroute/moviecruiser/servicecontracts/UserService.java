package com.stackroute.moviecruiser.servicecontracts;

import org.springframework.stereotype.Service;

import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.UserRepository;

@Service
public interface UserService {
	public User getUserById(long id);
	public User deleteUser(User user);
	public User deleteUserById(long id);
	public User addUser(User user);
	public void setUserRepository(UserRepository userRepository);
}
