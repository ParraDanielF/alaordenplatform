package com.alaorden.co.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alaorden.co.authentication.model.Account;
import com.alaorden.co.util.ServiceResponse;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	
	@PostMapping("/")
	public ServiceResponse login() {
		return null;
	}
	
	@GetMapping("/")
	public ServiceResponse logout() {
		return null;
	}
	
	@GetMapping("/{email}")
	public ServiceResponse generateRecoveryToken() {
		return null;
	}
	
	@GetMapping("/{token}")
	public ServiceResponse validateRecoveryToken() {
		return null;
	}
	
	@PostMapping("/register")
	public ServiceResponse registeUser(Account userData, int role) {
		return null;
	}
}
