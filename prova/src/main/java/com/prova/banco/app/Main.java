package com.prova.banco.app;

import com.prova.banco.model.ContaBancaria;
import com.prova.banco.service.ContaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContaService service = new ContaService();

        int opcao;

        do {
            System.out.println("\n\t===== SISTEMA BANCÁRIO =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Consultar saldo");
            System.out.println("6 - Listar contas");
            System.out.println("0 - Sair");
            System.out.println("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();

                    System.out.print("Titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Saldo inicial (0 para padrão): ");
                    double saldo = sc.nextDouble();

                    ContaBancaria conta;

                    try {
                        if (saldo > 0) {
                            conta = new ContaBancaria(numero, titular, saldo);
                        } else {
                            conta = new ContaBancaria(numero, titular);
                        }
                        service.cadastrarConta(conta);

                        System.out.println("Conta criada com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao criar conta: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();

                    ContaBancaria conta = service.buscarConta(numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }

                    System.out.print("Valor para depósito: ");
                    double valor = sc.nextDouble();

                    try {
                        conta.depositar(valor);
                        System.out.println("Depósito realizado!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 3 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();

                    ContaBancaria conta = service.buscarConta(numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }

                    System.out.print("Valor para saque: ");
                    double valor = sc.nextDouble();

                    try {
                        conta.sacar(valor);
                        System.out.println("Saque realizado!");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }

                case 4 -> {
                    System.out.print("Conta origem: ");
                    String origem = sc.nextLine();

                    System.out.print("Conta destino: ");
                    String destino = sc.nextLine();

                    ContaBancaria cOrigem = service.buscarConta(origem);
                    ContaBancaria cDestino = service.buscarConta(destino);

                    if (cOrigem == null || cDestino == null) {
                        System.out.println("Conta(s) inválida(s).");
                        break;
                    }

                    System.out.print("Valor para transferir: ");
                    double valor = sc.nextDouble();

                    boolean ok = cOrigem.transferir(valor, cDestino);

                    if (ok) System.out.println("Transferência concluída!");
                    else System.out.println("Falha na transferência.");
                }

                case 5 -> {
                    System.out.print("Número da conta: ");
                    String numero = sc.nextLine();

                    ContaBancaria conta = service.buscarConta(numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                    } else {
                        System.out.println("Saldo atual: " + conta.getSaldo());
                    }
                }

                case 6 -> {
                    System.out.println("\n\t--- LISTA DE CONTAS ---");
                    service.listarContas().forEach((k, v) -> {
                        System.out.println("> Conta: " + v.getNumeroConta()
                                + " | Titular: " + v.getTitular()
                                + " | Saldo: " + v.getSaldo());
                    });
                }

                case 0 -> System.out.println("Saindo do sistema...\n");
                default -> System.out.println("Opção inválida.\n");
            }

        } while (opcao != 0);

        sc.close();
    }
}
