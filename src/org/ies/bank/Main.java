package org.ies.bank;

import org.ies.bank.components.*;
import org.ies.bank.components.scanner.ScannerAccountReader;
import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.components.scanner.ScannerCustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScannerCustomerReader customerReader = new ScannerCustomerReader(scanner);
        ScannerAccountReader accountReader = new ScannerAccountReader(scanner, customerReader);
        ScannerBankReader bankReader = new ScannerBankReader(scanner, accountReader);
        var bankApp = new BankApp2(bankReader);

        bankApp.run();
    }
}