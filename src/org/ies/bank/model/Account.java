package org.ies.bank.model;

import java.util.Objects;

public class Account {
    private String iban;
    private double saldo;
    private Customer cliente;

    public Account(String iban, double saldo, Customer cliente) {
        this.iban = iban;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void deposit (double amount) {
        saldo += amount;
    }

    public void retirar (double amount) {
        saldo -= amount;
    }

    public void showInfo (){
        System.out.println("Informacion de cuentas:" + getIban() + getCliente() + getSaldo());
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(saldo, account.saldo) == 0 && Objects.equals(iban, account.iban) && Objects.equals(cliente, account.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo, cliente);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
