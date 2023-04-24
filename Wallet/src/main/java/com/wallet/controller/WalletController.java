package com.wallet.controller;

import com.wallet.model.Wallet;
import com.wallet.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/wallets")
    public ResponseEntity<Wallet> addWallets(@Valid @RequestBody Wallet wallet){
        return new ResponseEntity<>(walletService.addWallet(wallet), HttpStatus.CREATED);
    }

    @GetMapping("/wallets")
    public ResponseEntity<List<Wallet>> getAllWallets(){
        return new ResponseEntity<>(walletService.getAllWallets(), HttpStatus.OK);
    }

    @GetMapping("/wallets/{walletName}")
    public ResponseEntity<Wallet> getAllWallets(@PathVariable String walletName){
        return new ResponseEntity<>(walletService.getWallet(walletName), HttpStatus.OK);
    }
}
