package com.api.transactional.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long number;
	private String status;
	private String accountNumber;
	private long balance;
	private long amount;
	private String comment;
	private LocalDate dateTimeStamp; 
}








