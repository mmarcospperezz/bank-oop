package org.ies.bank.components;

import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp4 {
    private final ScannerBankReader bankReader;

    public BankApp4(ScannerBankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();
        Account account1 = bank.findAccount("ES0001");
        Account account2 = bank.findAccount("ES0002");

        if (account1 != null) {
            account1.showInfo();
            account2.showInfo();
            bank.transfer("ES0001", "ES0002", account1.getSaldo());

            bank.showAccounts();

        }
    }
}
