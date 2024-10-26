package com.java.lld.digitalwallet.service;

import com.java.lld.digitalwallet.entity.Transaction;
import com.java.lld.digitalwallet.entity.Wallet;
import com.java.lld.digitalwallet.exception.InsufficientBalanceException;

import java.util.List;

public interface WalletService {

    Wallet createWallet(String userName);
    void sendAmount(String senderWalletId, String collectorWalletId, Long amount) throws InsufficientBalanceException;
    List<Transaction> getWalletStatement(String walletId);
    List<String> showActiveAccount();
    Long getWalletBalance(String walletId);
    void rechargeWallet(String walletId, Long amount) throws InsufficientBalanceException;
}
