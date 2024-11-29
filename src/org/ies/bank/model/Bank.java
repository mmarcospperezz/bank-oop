package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

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

    public Account searchIban(String iban) {
        for (Account account : cuentas) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
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
