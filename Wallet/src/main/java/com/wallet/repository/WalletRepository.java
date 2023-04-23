package com.wallet.repository;

import com.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("walletRepository")
public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Wallet findAllByName(String walletName);
}
