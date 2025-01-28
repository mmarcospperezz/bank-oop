package org.ies.bank;

import org.ies.bank.components.*;
import org.ies.bank.components.random.RandomAccountReader;
import org.ies.bank.components.random.RandomBankReader;
import org.ies.bank.components.random.RandomCustomerReader;
import org.ies.bank.components.scanner.ScannerAccountReader;
import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.components.scanner.ScannerCustomerReader;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
         var  customerReader = new RandomCustomerReader(random);
        var accountReader = new RandomAccountReader(random,customerReader);
        var bankReader = new RandomBankReader(random, accountReader);
        var bankApp = new BankApp (scanner,bankReader);

        bankApp.run();
    }
}