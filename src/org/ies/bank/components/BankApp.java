package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    public final Scanner scanner;
    public final Bank bank;

    public BankApp(Scanner scanner, Bank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }
}

