package com.alaorden.co.contract;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alaorden.co.util.ServiceResponse;

@Controller
@RequestMapping("/contract")
public class ContractController {
	
	@PostMapping("/")
	public ServiceResponse createContract() {
		return null;
	}
	
	@PutMapping("/")
	public ServiceResponse updateContract() {
		return null;
	}
	
	@DeleteMapping("/{contractId}")
	public ServiceResponse deleteContract() {
		return null;
	}
	
	@GetMapping("/{contractId}")
	public ServiceResponse getContract(@PathVariable(required = false) String companyId) {
		return null;
	}
}
