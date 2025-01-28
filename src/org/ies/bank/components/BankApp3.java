package org.ies.bank.components;

import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp3 {
    private final ScannerBankReader bankReader;

    public BankApp3(ScannerBankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        bank.showAccounts();

        Account account1 = bank.findAccount("ES0003");
        if (account1 != null) {
            account1.deposit(-30);
        } else {
            System.out.println("No existe la cuenta");
        }

        bank.showAccountscustomer("000X");

        Account account2 = bank.findAccount("ES0003");
        if (account2 != null) {
            account2.deposit(300);
        } else {
            System.out.println("No existe la cuenta");
        }

        Account account3 = bank.findAccount("ES0001");
        if (account3 != null) {
            account3.getCliente().showInfo();
        } else {
            System.out.println("La cuenta no existe");
        }

    }
}
