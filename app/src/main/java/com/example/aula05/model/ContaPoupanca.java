package com.example.aula05.model;

public class ContaPoupanca extends ContaBancaria{
    double saldo = getSaldo();
    private int diaRendimento;
    private double taxaRendimento;

    @Override
    public void sacar(double valor) {
        if((saldo - valor) >= 0.0) {
            saldo -=  valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo +=  valor;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        for(int i = 0; i < diaRendimento; i++) {
            this.saldo += (this.saldo * (taxaRendimento/ 100));
        }
    }

    public int getDiaRendimento() {
        return diaRendimento;
    }

    public void setDiaRendimento(int diaRendimento) {
        this.diaRendimento = diaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
