package com.wallet.services;

import com.wallet.controller.TransactionController;
import com.wallet.model.Transaction;
import com.wallet.model.Wallet;
import com.wallet.repository.TransactionRepository;
import com.wallet.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TransactionServiceTest {

    /*@MockBean
    TransactionRepository transactionRepository;

    @MockBean
    WalletRepository walletRepository;

    @Test
    public void testHandleTransaction_addFunds(){
        Wallet w = new Wallet(1l,"w1",234);
        Transaction t = new Transaction(1l,"ADD",31,w);
        walletRepository.save(w);
        System.out.println(walletRepository.count());

        TransactionService service = new TransactionService(transactionRepository,walletRepository);
        service.handleTransactions(t);
        Wallet expected = new Wallet(1L,"w1",265);
        Wallet actual = walletRepository.findAllByName("w1");
        assertEquals(expected.getBalance(),actual.getBalance());
    }

    @Test
    public void testHandleTransaction_withdrawFunds(){
        Wallet w = new Wallet(1l,"w1",234);
        Transaction t = new Transaction(1l,"WITHDRAW",31,w);
        walletRepository.save(w);
        System.out.println(walletRepository.count());

        TransactionService service = new TransactionService(transactionRepository,walletRepository);
        service.handleTransactions(t);
        Wallet expected = new Wallet(1L,"w1",203);
        Wallet actual = walletRepository.findAllByName("w1");
        assertEquals(expected.getBalance(),actual.getBalance());
    }

    @Test
    public void testHandleTransaction_withdrawFunds_balanceIsZero(){
        Wallet w = new Wallet(1l,"w1",0);
        Transaction t = new Transaction(1l,"WITHDRAW",31,w);
        walletRepository.save(w);
        System.out.println(walletRepository.count());

        TransactionService service = new TransactionService(transactionRepository,walletRepository);
        service.handleTransactions(t);
        Wallet expected = new Wallet(1L,"w1",-1);
        Wallet actual = walletRepository.findAllByName("w1");
        assertEquals(expected.getBalance(),actual.getBalance());
    }*/
}
