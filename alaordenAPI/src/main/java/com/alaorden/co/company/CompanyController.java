package com.alaorden.co.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alaorden.co.util.ServiceResponse;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@PostMapping("/")
	public ServiceResponse createCompany() {
		return null;
	}
	
	@PutMapping("/")
	public ServiceResponse updateCompany() {
		return null;
	}
	
	@DeleteMapping("/{companyId}")
	public ServiceResponse deleteCompany() {
		return null;
	}
	
	@GetMapping("/{companyId}")
	public ServiceResponse getCompany(@PathVariable(required = false) String companyId) {
		return null;
	}
}
