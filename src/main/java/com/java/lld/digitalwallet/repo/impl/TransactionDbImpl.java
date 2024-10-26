package com.java.lld.digitalwallet.repo.impl;

import com.java.lld.digitalwallet.entity.Transaction;
import com.java.lld.digitalwallet.repo.TransactionDb;
import lombok.Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
public class TransactionDbImpl implements TransactionDb {

    private final Map<String, Transaction> transactionDbMap = new HashMap<>();

    @Override
    public Transaction getTransaction(String txnId) {

        for (Transaction transaction : this.transactionDbMap.values()) {

            if (transaction.getTxnId().equalsIgnoreCase(txnId)) {
                return transaction;
            }
        }

        return null;
    }

    @Override
    public void registerTransaction(Transaction transaction) {
            this.transactionDbMap.put(transaction.getTxnId(), transaction);
    }
}
