package org.ies.bank.components;

import org.ies.bank.components.scanner.ScannerBankReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    public final Scanner scanner;
    public final ScannerBankReader bankReader;

    public BankApp(Scanner scanner, ScannerBankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Bank bank = bankReader.read();

        int option;
        do{
            option = chooseOption();
            if (option == 1) {
                bank.showAccounts();
            } else if (option == 2) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();
                if(iban != null) {
                    Account account = bank.findAccount(iban);
                    System.out.println(account);
                } else{
                    System.out.println("No existe");
                }

            } else if (option == 3) {
                System.out.println("Introduce el NIF del cliente:");
                String nif = scanner.nextLine();

                bank.showAccountscustomer(nif);
            } else if (option == 4) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();

                System.out.println("¿Que cantidad vas ingresar?:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                bank.addMoney(iban, amount);
            } else if (option == 5) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();

                System.out.println("¿Que cantidad vas a retirar?:");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                bank.withDraw(iban, amount);
            } else if (option == 6) {
                System.out.println("Introduce el nif del cliente:");
                String nif = scanner.nextLine();

                int customerAccountsnumber = bank.numberAccounts(nif);
                System.out.println("El cliente tiene" + customerAccountsnumber);
            } else if (option == 7) {
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();

                bank.showAccountscustomer(iban);

            } else if (option == 8){
                System.out.println("Introduce el primer IBAN");
                String iban1 = scanner.nextLine();
                System.out.println("Introduce el segundo IBAN");
                String iban2 = scanner.nextLine();
                System.out.println("¿Cuanto dinero quieres enviar?");
                double amount = scanner.nextDouble();

                bank.transfer(iban1, iban2, amount);


            } else{
                System.out.println("Opcion invalida");
            }
        } while (option != 9);


    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Mostrar todas las cuentas");
            System.out.println("2. Mostrar datos de una cuenta por IBAN");
            System.out.println("3. Mostrar cuentas de un cliente por NIF");
            System.out.println("4. Ingresar dinero en una cuenta");
            System.out.println("5. Retirar dinero de una cuenta");
            System.out.println("6. Contar cuentas de un cliente");
            System.out.println("7. Mostrar titular de la cuenta");
            System.out.println("8. Realizar una trasferencia");

            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

        } while (option < 1 || option > 9);
        return option;
    }
}
