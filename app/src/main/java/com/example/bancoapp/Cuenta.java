package com.example.bancoapp;

import java.io.Serializable;

public class Cuenta implements Serializable {

    String numCuenta;
    String nombre;
    String banco;
    float saldo;

    public Cuenta() {
    }

    public Cuenta(String numCuenta, String nombre, String banco, float saldo) {
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.banco = banco;
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

}

