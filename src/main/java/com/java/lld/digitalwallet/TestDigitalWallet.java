package com.java.lld.digitalwallet;

import com.java.lld.digitalwallet.entity.Wallet;
import com.java.lld.digitalwallet.exception.InsufficientBalanceException;
import com.java.lld.digitalwallet.repo.TransactionDb;
import com.java.lld.digitalwallet.repo.WalletDb;
import com.java.lld.digitalwallet.repo.impl.TransactionDbImpl;
import com.java.lld.digitalwallet.repo.impl.WalletDbImpl;
import com.java.lld.digitalwallet.service.WalletService;
import com.java.lld.digitalwallet.service.impl.WalletServiceImpl;

public class TestDigitalWallet {

    /*
    1. You are supposed to create a digital wallet system that allows people to transfer amounts between their wallets.
    2. The wallet uses its own currency known as FkRupee(F₹).
    3. The account balance cannot drop below F₹ 0.00.
    4. The smallest amount that can be transferred between wallets is 0.0001.
    5. The user should be presented with options for each action. And the options are as follows:
    6. Create Wallet – This option should create a wallet for the user.
    7. Transfer Amount – This option should enable the transfer of funds from one account to the other.
    8. Account Statement – This option should display the account statement for the specified user.
            Overview – This option should display all the account numbers currently in the system. Additionally, it should show the current balances for these accounts.
    9. Exit – The system should exit.
    */
    public static void main(String[] args) throws InsufficientBalanceException {

        WalletDb walletDb = WalletDbImpl.builder().build();
        TransactionDb transactionDb = TransactionDbImpl.builder().build();

        WalletService walletService = WalletServiceImpl.builder().transactionDb(transactionDb).walletDb(walletDb).build();

        Wallet sharadWallet = walletService.createWallet("Sharad");
        Wallet avaniWallet = walletService.createWallet("Avani");

        System.out.println(walletService.getWalletBalance(sharadWallet.getWalletId()));
        System.out.println(walletService.getWalletBalance(avaniWallet.getWalletId()));

        walletService.rechargeWallet(sharadWallet.getWalletId(), 6000L);
        walletService.rechargeWallet(avaniWallet.getWalletId(), 5000L);

        System.out.println(walletService.getWalletBalance(sharadWallet.getWalletId()));
        System.out.println(walletService.getWalletBalance(avaniWallet.getWalletId()));

        System.out.println(walletService.getWalletStatement(sharadWallet.getWalletId()));

        walletService.sendAmount(sharadWallet.getWalletId(), avaniWallet.getWalletId(), 4000L);

        System.out.println(walletService.getWalletBalance(sharadWallet.getWalletId()));
        System.out.println(walletService.getWalletBalance(avaniWallet.getWalletId()));

        System.out.println(walletService.getWalletStatement(sharadWallet.getWalletId()));
        System.out.println(walletService.getWalletStatement(avaniWallet.getWalletId()));

    }
}
