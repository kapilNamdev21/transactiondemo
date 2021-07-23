package com.api.transactional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.transactional.dto.TransactionDto;
import com.api.transactional.entity.Transaction;
import com.api.transactional.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transService;
	
	@PostMapping("/transactions")
	public String saveTransaction(@RequestBody TransactionDto transDto){
		
		return transService.saveTransaction(transDto);
	}
	
	@GetMapping("/transactions/{accountnumber}")
	private Transaction getTransaction(@PathVariable("accountnumber") String accountNumber) {
		return transService.getTransaction(accountNumber);	
	}
	

}
