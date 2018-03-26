package com.lvtn.seekingtutors.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lvtn.seekingtutors.services.UserService;

@RestController
@RequestMapping(value = "/api/logintest")
public class userApi {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<String> add() throws Exception{
		return ResponseEntity.ok("ok");
	}
}
