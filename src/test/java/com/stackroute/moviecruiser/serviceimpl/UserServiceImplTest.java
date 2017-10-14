package com.stackroute.moviecruiser.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.moviecruiser.MoviecruiserappApplication;
import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.repositorycontracts.UserRepository;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviecruiserappApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceImplTest {
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private User user;
	
	@Before
	public void setupMockito() {
		MockitoAnnotations.initMocks(this);
        userServiceImpl = new UserServiceImpl();
        
        userServiceImpl.setUserRepository(userRepository);
	}
	
	@After
	public void teardownMockito() {
		
	}
	
	@Test
	public void shouldReturnUser_whenGetUserCalls() {
		user = new User();
		user.setId((long) 22201);
		user.setUsername("abhishek23");
		//Arrange
		when(userRepository.findOne((long) 22201)).thenReturn(user);
		//Act
		User retrievedUser = userServiceImpl.getUserById((long) 22201);
		//Assert
		assertEquals("Checking ", retrievedUser.getUsername(), "abhishek23");
	}
}
