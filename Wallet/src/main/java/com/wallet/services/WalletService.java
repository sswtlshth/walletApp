package com.wallet.services;

import com.wallet.model.Wallet;
import com.wallet.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<Wallet> getAllWallets(){
        return walletRepository.findAll();
    }

    public Wallet addWallet(Wallet wallet) {
        return  walletRepository.save(wallet);
    }

    public Wallet getWallet(String walletName) {
        return walletRepository.findAllByName(walletName);
    }
}


