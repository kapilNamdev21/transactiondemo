package com.api.transactional.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.transactional.entity.Transaction;
import com.api.transactional.repository.TransactionRepository;
import com.api.transactional.serviceImpl.TransactionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTransactionService  {

    @Autowired
    private TransactionServiceImpl service;

    @MockBean
    private TransactionRepository repository;
    
    @Autowired
	private TestEntityManager entityManager;  

    @Test
    public void testSaveTransaction() {
    	Transaction trans = new Transaction();
        trans.setAccountNumber("2234");
        trans.setAmount(5000l);
        trans.setBalance(400l);
        trans.setComment("test");
        trans.setNumber(18l);
        trans.setStatus("saved");
        
        Transaction trans1 = entityManager.persist(trans);
		Optional<Transaction> score2 = repository.findById(trans1.getNumber());
		assertThat(trans1).isEqualTo(score2.get());
        
    }

}
