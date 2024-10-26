package com.java.lld.digitalwallet.repo.impl;

import com.java.lld.digitalwallet.entity.Transaction;
import com.java.lld.digitalwallet.entity.Wallet;
import com.java.lld.digitalwallet.enums.TransactionType;
import com.java.lld.digitalwallet.exception.InsufficientBalanceException;
import com.java.lld.digitalwallet.repo.WalletDb;
import lombok.Builder;

import java.util.*;

@Builder
public class WalletDbImpl implements WalletDb {

    private final Map<String, Wallet> walletDbMap = new HashMap<>();

    @Override
    public Wallet createWallet(String userName) {

        String walletId = String.valueOf(UUID.randomUUID());
        Wallet wallet = Wallet.builder().active(true).walletId(walletId).transactions(new ArrayList<>()).userName(userName).build();
        this.walletDbMap.put(walletId, wallet);
        return wallet;
    }

    @Override
    public List<String> getActiveWallet() {

        List<String> result = new ArrayList<>();

        for (Wallet wallet : this.walletDbMap.values()) {

            if (wallet.getActive()) {

                result.add(wallet.getWalletId());
            }
        }

        return result;
    }

    @Override
    public Long getWalletBalance(String walletId) {

        if (this.walletDbMap.get(walletId) != null) {
            return this.walletDbMap.get(walletId).getCurrentAmount();
        }

        return null;
    }

    @Override
    public void updateWallet(String walletId, Long amount, TransactionType transactionType) throws InsufficientBalanceException {

        if (this.walletDbMap.get(walletId) != null) {

            Wallet wallet = this.walletDbMap.get(walletId);

            if (transactionType.name().equalsIgnoreCase("add")) {

                wallet.setCurrentAmount(wallet.getCurrentAmount() + amount);

            } else if (transactionType.name().equalsIgnoreCase("subtract")) {

                if (wallet.getCurrentAmount() - amount < 0 || wallet.getCurrentAmount() == 0) {
                    throw new InsufficientBalanceException("Low Balance!");

                } else {
                    wallet.setCurrentAmount(wallet.getCurrentAmount() - amount);
                }

            } else {

                wallet.setCurrentAmount(amount);
            }

            this.walletDbMap.put(walletId, wallet);
        }
    }

    @Override
    public void registerTransaction(String walletId, Transaction transaction) {

        if (this.walletDbMap.get(walletId) != null) {

            Wallet wallet = this.walletDbMap.get(walletId);

            List<Transaction> transactions = wallet.getTransactions();

            if (transactions != null) {
                transactions.add(transaction);
                wallet.setTransactions(transactions);
            } else {
                List<Transaction> fresh = new ArrayList<>();
                fresh.add(transaction);
                wallet.setTransactions(fresh);
            }
        }
    }

    @Override
    public Wallet getWallet(String walletId) {

        if (this.walletDbMap.get(walletId) != null) {
            return this.walletDbMap.get(walletId);
        }

        return null;
    }
}