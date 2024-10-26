package com.java.lld.digitalwallet.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Wallet {

    private String walletId;
    private String userName;
    private Long currentAmount;
    private List<Transaction> transactions;
    private Boolean active;
}