package com.java.lld.digitalwallet.service.impl;

import com.java.lld.digitalwallet.entity.Transaction;
import com.java.lld.digitalwallet.entity.Wallet;
import com.java.lld.digitalwallet.enums.TransactionType;
import com.java.lld.digitalwallet.exception.InsufficientBalanceException;
import com.java.lld.digitalwallet.repo.TransactionDb;
import com.java.lld.digitalwallet.repo.WalletDb;
import com.java.lld.digitalwallet.service.WalletService;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public class WalletServiceImpl implements WalletService {

    private TransactionDb transactionDb;
    private WalletDb walletDb;

    @Override
    public Wallet createWallet(String userName) {
        return this.walletDb.createWallet(userName);
    }

    @Override
    public void sendAmount(String senderWalletId, String collectorWalletId, Long amount) throws InsufficientBalanceException {

        try {
            this.walletDb.updateWallet(senderWalletId, amount, TransactionType.subtract);
            this.walletDb.updateWallet(collectorWalletId, amount, TransactionType.add);

            Transaction transaction = Transaction.builder().senderWalletId(senderWalletId).collectorWalletId(collectorWalletId).txnId(String.valueOf(UUID.randomUUID())).amount(amount).txnDate(LocalDate.now().toString()).build();
            this.transactionDb.registerTransaction(transaction);
            this.walletDb.registerTransaction(senderWalletId, transaction);
            this.walletDb.registerTransaction(collectorWalletId, transaction);

        } catch (InsufficientBalanceException e) {
            throw new InsufficientBalanceException("Cannot perform this operation!");
        }
    }

    @Override
    public List<Transaction> getWalletStatement(String walletId) {
        return this.walletDb.getWallet(walletId).getTransactions();
    }

    @Override
    public List<String> showActiveAccount() {
        return this.walletDb.getActiveWallet();
    }

    @Override
    public Long getWalletBalance(String walletId) {
        return this.walletDb.getWalletBalance(walletId);
    }

    @Override
    public void rechargeWallet(String walletId, Long amount) throws InsufficientBalanceException {
        try {
            this.walletDb.updateWallet(walletId, amount, TransactionType.recharge);
        } catch (InsufficientBalanceException e) {
            throw new InsufficientBalanceException("Unable to recharge wallet!");
        }
    }
}
