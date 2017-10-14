package com.stackroute.moviecruiser.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.moviecruiser.MoviecruiserappApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviecruiserappApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {
	HttpHeaders headers = new HttpHeaders();
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@LocalServerPort
    private int port;
	
	@Before
	public void setup() {
		
	}
	
	private String createURLWithPort(String uri) {
        return "http://localhost:" + port + "/v1.1/api" + uri;
    }
	
	@After
	public void teardown() {
		
	}
	
	@Test
	public void testAuthenticateNotNull() {
		HttpEntity<String> entity = new HttpEntity<String>("Abhishek", headers);
		ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/authenticate"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User successfully authenticated",actual);
	}
}
