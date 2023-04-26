package com.wallet.services;

import com.wallet.model.Wallet;
import com.wallet.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class WalletServiceTest {

  /*  @MockBean
    WalletRepository walletRepository;

    @Test
    void testGetAllWallets(){
        Wallet wallet = new Wallet("wallet1",400);
        walletRepository.save(wallet);
        WalletService walletService = new WalletService(walletRepository);
        List<Wallet> allWallets = walletService.getAllWallets();
        Wallet actual = allWallets.get(allWallets.size()-1);
        assertEquals(wallet.getBalance(),actual.getBalance());
        assertEquals(wallet.getName(),actual.getName());
    } */


}
