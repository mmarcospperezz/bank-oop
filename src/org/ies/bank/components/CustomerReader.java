package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {
    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

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
