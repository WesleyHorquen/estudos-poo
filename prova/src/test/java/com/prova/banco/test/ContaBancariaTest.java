package com.prova.banco.test;

import com.prova.banco.model.ContaBancaria;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void setup() {
        conta = new ContaBancaria("123", "Wesley", 100.0);
    }

    @AfterEach
    void cleanup() {
        conta = null;
        System.out.println("Teste finalizado.");
    }

    @Test
    @DisplayName("Construtor deve iniciar conta com saldo zero")
    void construtorSaldoZero() {
        ContaBancaria c = new ContaBancaria("111", "Teste");
        assertEquals(0.0, c.getSaldo());
    }

    @Test
    @DisplayName("Construtor deve iniciar conta com saldo positivo válido")
    void construtorSaldoPositivo() {
        ContaBancaria c = new ContaBancaria("222", "Maria", 500.0);
        assertEquals(500.0, c.getSaldo());
    }

    @Test
    @DisplayName("Construtor deve lançar exceção ao receber saldo negativo")
    void construtorSaldoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ContaBancaria("333", "Erro", -10.0);
        });
    }

    @Test
    @DisplayName("Depósito bem-sucedido deve aumentar saldo")
    void depositoBemSucedido() {
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Depósito negativo deve lançar IllegalArgumentException")
    void depositoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-20));
    }

    @Test
    @DisplayName("Depósito zero deve lançar IllegalArgumentException")
    void depositoZero() {
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(0));
    }

    @Test
    @DisplayName("Saque bem-sucedido deve diminuir saldo")
    void saqueBemSucedido() {
        conta.sacar(40.0);
        assertEquals(60.0, conta.getSaldo());
    }

    @Test
    @DisplayName("Saque negativo deve lançar IllegalArgumentException")
    void saqueNegativo() {
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(-10));
    }

    @Test
    @DisplayName("Saque zero deve lançar IllegalArgumentException")
    void saqueZero() {
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(0));
    }

    @Test
    @DisplayName("Saque maior que saldo deve lançar IllegalStateException")
    void saqueMaiorQueSaldo() {
        assertThrows(IllegalStateException.class, () -> conta.sacar(200.0));
    }

    @Test
    @DisplayName("Transferência bem-sucedida deve alterar saldos corretamente")
    void transferenciaBemSucedida() {
        ContaBancaria destino = new ContaBancaria("444", "Destino", 50.0);

        boolean resultado = conta.transferir(50.0, destino);

        assertTrue(resultado);
        assertEquals(50.0, conta.getSaldo());
        assertEquals(100.0, destino.getSaldo());
    }

    @Test
    @DisplayName("Transferência deve falhar se valor excede saldo da origem")
    void transferenciaSaldoInsuficiente() {
        ContaBancaria destino = new ContaBancaria("555", "Destino", 10.0);

        boolean resultado = conta.transferir(500.0, destino);

        assertFalse(resultado);
        assertEquals(100.0, conta.getSaldo());
        assertEquals(10.0, destino.getSaldo());
    }

    @Test
    @DisplayName("Transferência deve falhar se valor negativo")
    void transferenciaValorNegativo() {
        ContaBancaria destino = new ContaBancaria("666", "Destino", 10.0);

        boolean resultado = conta.transferir(-20.0, destino);

        assertFalse(resultado);
        assertEquals(100.0, conta.getSaldo());
        assertEquals(10.0, destino.getSaldo());
    }

    @Test
    @DisplayName("Transferência deve falhar se conta destino for nula")
    void transferenciaDestinoNulo() {
        assertThrows(IllegalArgumentException.class, () -> conta.transferir(10.0, null));
    }
}
