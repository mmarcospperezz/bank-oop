package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    public final Scanner scanner;
    public final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Bank banco = bankReader.read();

        int opcion;
        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Mostrar todas las cuentas");
            System.out.println("2. Mostrar datos de una cuenta por IBAN");
            System.out.println("3. Mostrar cuentas de un cliente por NIF");
            System.out.println("4. Ingresar dinero en una cuenta");
            System.out.println("5. Retirar dinero de una cuenta");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }
        while (opcion != 0);
    }
}
