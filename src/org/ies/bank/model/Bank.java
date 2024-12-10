package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bank {
    private String nombre;
    private Account[] cuentas;

    public Bank(String nombre, Account[] cuentas) {
        this.nombre = nombre;
        this.cuentas = cuentas;
    }

    public void showAccounts() {
        for (Account account : cuentas) {
            System.out.println("IBAN: " + account.getIban() +
                    ", Saldo: " + account.getSaldo() +
                    ", NIF: " + account.getCliente().getNif());
        }
    }

    public Account findAccount (String iban){
        for (Account account : cuentas){
            if (account.getIban().equals(iban)){
                return account;
            }
        }
        return null;
    }

    public void showAccountscustomer (String nif) {
        for (Account account : cuentas){
            if (account.getCliente().getNif().equals(nif)){
                account.showInfo();
            }
        }
    }

    public Account searchIban(String iban) {
        for (Account account : cuentas) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void addMoney(String iban, double cantidad) {
        Account cuenta = findAccount(iban);
        if (cuenta != null) {
            cuenta.setSaldo(cuenta.getSaldo() + cantidad);
            System.out.println("Se ingresaron " + cantidad + " a la cuenta " + iban);
        } else {
            System.out.println("No se encuentra la cuenta con IBAN: " + iban);
        }
    }

    public int numberAccounts (String nif){
        int counts = 0;
        for (Account account: cuentas){
            if(account.getCliente().getNif().equals(nif)){
                counts++;
            }
        }
        return counts;
    }

    public Customer returnInfo(String iban) {
        Account cuenta = findAccount(iban);
        if (cuenta == null){
            return null;
        }
        else {
            return cuenta.getCliente();
        }

    }

    public void withDraw (String iban, double amount) {
        Account account = findAccount(iban);
        if (account != null) {
            if (account.getSaldo() >= amount){
                account.deposit(-amount);
            } else {
                System.out.println("Cuenta no encontrada");
            }
        }
    }
    public void deposit (String iban, double amount){
        Account account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void transfer (String iban1, String iban2, double amount){
        Account account1 = findAccount(iban1);
        Account account2 = findAccount(iban2);

        if (account1 != null && account2 != null) {
            account1.retirar(amount);
            account2.deposit(amount);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Account[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Account[] cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(nombre, bank.nombre) && Objects.deepEquals(cuentas, bank.cuentas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, Arrays.hashCode(cuentas));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "nombre='" + nombre + '\'' +
                ", cuentas=" + Arrays.toString(cuentas) +
                '}';
    }
}
