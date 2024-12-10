package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

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

