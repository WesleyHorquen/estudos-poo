package com.prova.banco.model;

public class ContaBancaria {

    private String numeroConta;
    private double saldo;
    private String titular;

    // Construtor: saldo inicia em 0.0
    public ContaBancaria(String numeroConta, String titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Construtor com saldo inicial validado
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo.");
        }
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // GETTERS
    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Depósito
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser maior que zero.");
        }
        saldo += valor;
    }

    // Saque
    public double sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser maior que zero.");
        }

        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente para saque.");
        }

        saldo -= valor;
        return valor;
    }

    public boolean transferir(double valor, ContaBancaria destino) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta de destino não pode ser nula.");
        }

        try {
            double sacado = this.sacar(valor); // se falhar, cai no catch
            destino.depositar(sacado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
