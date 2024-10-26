package com.java.lld.digitalwallet.repo;

import com.java.lld.digitalwallet.entity.Transaction;

import java.util.List;

public interface TransactionDb {

    Transaction getTransaction(String txnId);
    void registerTransaction(Transaction transaction);
}
