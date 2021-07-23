package com.api.transactional.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

import com.api.transactional.dto.TransactionDto;
import com.api.transactional.entity.Transaction;
import com.api.transactional.exception.TransactionNotAvailableException;
import com.api.transactional.repository.TransactionRepository;
import com.api.transactional.service.TransactionService;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	TransactionRepository transRepository;
	
	private static final String SAVED = "saved";

	@Override
	public String saveTransaction(TransactionDto transDto) {
		// TODO Auto-generated method stub
		log.info("save Transaction process is starting.");
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transDto, transaction);
		//Below 200 amount will be coming through the Batch process
		long amount = transaction.getAmount() - 200l;
		transaction.setAmount(amount);
		transaction.setStatus(SAVED);
		transRepository.save(transaction);
		return "Transaction is Saved Successfully";
	}

	@Override
	public Transaction getTransaction(String accountNumber) {
		Optional<Transaction> trans =transRepository.findByAccountNumber(accountNumber);
		if(!trans.isPresent()) {
			throw new TransactionNotAvailableException("Transaction Not Available!");
		}
		return trans.get();
	}

}
