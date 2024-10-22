package com.example.aula05.model;

public abstract class ContaBancaria {
    private String cliente;
    private int numConta;
    private double saldo;

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
