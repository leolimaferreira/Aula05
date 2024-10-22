package com.example.aula05.model;

public class ContaEspecial extends ContaBancaria{
    double saldo = getSaldo();
    private float limite;
    
    @Override
    public void sacar(double valor) {
        if((saldo - valor) >= -limite) {
            saldo -=  valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo +=  valor;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
