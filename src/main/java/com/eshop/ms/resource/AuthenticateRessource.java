package com.eshop.ms.resource;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ms.model.AuthenticateModel;
import com.eshop.ms.model.SingleValue;
import com.eshop.ms.model.UserContext;
import com.eshop.ms.security.JwTokenGenerator;
import com.eshop.ms.security.JwTokenValidator;

@RestController
@RequestMapping(value = "authenticate", produces = ("application/json"))
public class AuthenticateRessource {
	
	@Autowired
	private JwTokenGenerator jwtGenerator;
	
	@Autowired
	private JwTokenValidator jwtvalidator;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public String authenticate(@RequestBody AuthenticateModel authModel) {
		
		if(!"".equals(authModel.getPassword()) && !StringUtils.isEmpty(authModel.getLogin()) && authModel.getAdmin() == "true") {
			
			System.out.println(jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("ADMIN"))); 
			return jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("ADMIN"));
			
		}
		
		if (!"".equals(authModel.getPassword()) && !StringUtils.isEmpty(authModel.getLogin()) && !(authModel.getAdmin()== "true")){
			System.out.println(jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("USER"))); 
			
			return jwtGenerator.generateToken(authModel.getLogin(), Arrays.asList("USER"));
		}
		
		return "invalid user, impossible to generate the token";
		
		
	}
	@PostMapping("validate")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public UserContext parseToken(@RequestBody SingleValue value) {
		return jwtvalidator.transform(value.getValue());
	}
}
