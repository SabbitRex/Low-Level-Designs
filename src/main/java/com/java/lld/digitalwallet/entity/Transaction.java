package com.java.lld.digitalwallet.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transaction {

    private String txnId;
    private Long amount;
    private String txnDate;
    private String senderWalletId;
    private String collectorWalletId;
}
