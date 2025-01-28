package org.ies.bank.components.scanner;

import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class ScannerCustomerReader implements CustomerReader {
    private final Scanner scanner;

    public ScannerCustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Customer read () {
        System.out.println("Ingrese su NIF:");
        String nif = scanner.nextLine();
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su apellidos:");
        String apellidos = scanner.nextLine();

        return new Customer(
                nif,
                nombre,
                apellidos
        );
    }
}
