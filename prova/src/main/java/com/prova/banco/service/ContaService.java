package com.prova.banco.service;

import com.prova.banco.model.ContaBancaria;
import java.util.HashMap;
import java.util.Map;

public class ContaService {

    private Map<String, ContaBancaria> contas = new HashMap<>();

    public void cadastrarConta(ContaBancaria conta) {
        contas.put(conta.getNumeroConta(), conta);
    }

    public ContaBancaria buscarConta(String numero) {
        return contas.get(numero);
    }

    public Map<String, ContaBancaria> listarContas() {
        return contas;
    }
}
