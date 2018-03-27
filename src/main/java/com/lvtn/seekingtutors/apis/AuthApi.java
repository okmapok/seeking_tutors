package com.lvtn.seekingtutors.apis;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lvtn.seekingtutors.Constant.ConstantKeys;
import com.lvtn.seekingtutors.services.AuthService;
import javassist.NotFoundException;

import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping(value = "/api/login")
public class AuthApi {
	@Autowired
	private AuthService authService;
	
	@Autowired
	 private HttpSession httpSession;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Map<String, Object> body) throws NotFoundException, JSONException{
		String email = body.get(ConstantKeys.EMAIL).toString();
	    String password = body.get(ConstantKeys.PASS_WORD).toString();
	    JSONObject response = authService.authenticate(email, password);
	    if(response != null && (int)response.get(ConstantKeys.RESPONSE_CODE) == 200) 
	    {
	    	httpSession.setAttribute(ConstantKeys.EMAIL, email);
	        httpSession.setAttribute(ConstantKeys.PASS_WORD, password);
	        httpSession.setAttribute(ConstantKeys.STATUS, ConstantKeys.SUCCESS);
	        return new ResponseEntity<>(response.toString(), HttpStatus.OK);
	    }
	    
		return new ResponseEntity<>(response.toString(), HttpStatus.UNAUTHORIZED);
	}
}
