package com.api.transactional.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.transactional.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	Optional<Transaction> findByAccountNumber(String accountNumber);

}