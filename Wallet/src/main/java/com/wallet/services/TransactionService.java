package com.wallet.services;

import com.wallet.exception.InsufficientBalanceException;
import com.wallet.exception.OperationNotSupportedException;
import com.wallet.exception.WalletNotFoundException;
import com.wallet.model.Transaction;
import com.wallet.model.Wallet;
import com.wallet.repository.TransactionRepository;
import com.wallet.repository.WalletRepository;
import org.springframework.stereotype.Service;



@Service
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository, WalletRepository walletRepository) {
       this.transactionRepository = transactionRepository;
       this.walletRepository = walletRepository;
    }

    public Transaction handleTransactions(Transaction transaction)  {
        return switch (transaction.getTransactionType()){
            case "ADD" -> handleAddTransaction(transaction);
            case "WITHDRAW" -> handleWithdrawTransactions(transaction);
            default ->  throw new OperationNotSupportedException("Transaction Type not supported");
        };
    }

    private Transaction handleWithdrawTransactions(Transaction transaction) {
        Wallet w = walletRepository.findById(transaction.getWallet().getId()).get();
        if(w.getBalance() < transaction.getAmount()){
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        w.setBalance(w.getBalance()-transaction.getAmount());
        walletRepository.save(w);
        return transactionRepository.save(transaction);
    }

    private Transaction handleAddTransaction(Transaction transaction) {
        Wallet w = walletRepository.findById(transaction.getWallet().getId()).orElseThrow(() -> {throw new WalletNotFoundException("Wallet not found" );});
        w.setBalance(w.getBalance()+transaction.getAmount());
        walletRepository.save(w);
        return transactionRepository.save(transaction);
    }
}
