package com.api.transactional.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TransactionDto {
	@NotBlank
	private String accountNumber;
	@NotBlank
	private long balance;
	@NotBlank
	private long amount;
	private String comment;
	private LocalDate dateTimeStamp; 
}








