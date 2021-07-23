package com.api.transactional.service;

import org.springframework.stereotype.Service;

import com.api.transactional.dto.TransactionDto;
import com.api.transactional.entity.Transaction;

@Service
public interface TransactionService {
	String saveTransaction(TransactionDto transDto);
	public Transaction getTransaction(String accountNumber);

}
