package org.ies.bank.components.scanner;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerAccountReader implements AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public ScannerAccountReader(Scanner scanner, CustomerReader customerReader) {
        this.scanner = scanner;
        this.customerReader = customerReader;
    }

    @Override
    public Account read () {
        System.out.println("Ingrese su IBAN:");
        String iban = scanner.nextLine();
        System.out.println("Ingrese su saldo:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        Customer cliente = customerReader.read();

        return new Account(
                iban,
                saldo,
                cliente
        );
    }
}
