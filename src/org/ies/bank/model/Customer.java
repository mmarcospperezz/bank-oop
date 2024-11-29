package org.ies.bank.model;

import java.util.Objects;

public class Customer {
    private String nif;
    private String nombre;
    private String apellidos;

    public Customer(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(nif, customer.nif) && Objects.equals(nombre, customer.nombre) && Objects.equals(apellidos, customer.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, nombre, apellidos);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
