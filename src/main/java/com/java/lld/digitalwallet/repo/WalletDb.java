package com.java.lld.digitalwallet.repo;

import com.java.lld.digitalwallet.entity.Transaction;
import com.java.lld.digitalwallet.entity.Wallet;
import com.java.lld.digitalwallet.enums.TransactionType;
import com.java.lld.digitalwallet.exception.InsufficientBalanceException;
import com.java.lld.digitalwallet.service.WalletService;

import java.util.List;

public interface WalletDb {

    Wallet createWallet(String userName);
    List<String> getActiveWallet();
    Long getWalletBalance(String walletId);
    void updateWallet(String walletId, Long amount, TransactionType transactionType) throws InsufficientBalanceException;
    void registerTransaction(String walletId, Transaction transaction);
    Wallet getWallet(String walletId);
}
