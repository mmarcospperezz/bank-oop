package org.ies.bank.components.random;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Random;

public class RandomBankReader implements BankReader {

    private final Random random;
    private final AccountReader accountReader;

    public RandomBankReader(Random random, AccountReader accountReader) {
        this.random = random;
        this.accountReader = accountReader;
    }

    private final static String[] NAMES = {
           "BBVA", "SANTANDER", "MARCOSBANK", "OPENBANK", "CAIXA"
    };

    public Bank read(){
        Account[] accounts = new Account[10];
        for (int  i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }
       return new Bank(
               NAMES[random.nextInt(NAMES.length)],
               accounts
       );
    }
}
