package org.ies.bank.components.scanner;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class ScannerBankReader implements BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public ScannerBankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    @Override
    public Bank read () {
        System.out.println("Ingrese el nombre del banco:");
        String nombre = scanner.nextLine();
        System.out.println("¿Cuantas cuentas tiene?:");
        int size = scanner.nextInt();
        scanner.nextLine();
        Account[] accounts = new Account[size];
        for (int  i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }


        return new Bank(
                nombre,
                accounts
        );
    }
}

