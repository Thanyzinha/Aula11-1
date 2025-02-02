package com.example.tratamentoapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TratamentoController {

    // Usando RequestMapping com método GET para o endpoint /formatar
    @RequestMapping(value = "/formatar", method = RequestMethod.GET)
    public String formatar(
            @RequestParam(value = "tratamento", defaultValue = "Sr.") String tratamento,
            @RequestParam(value = "nome", defaultValue = "Usuário") String nome,
            @RequestParam(value = "sobrenome", defaultValue = "Desconhecido") String sobrenome) {
        
        // Condicional para garantir que não há valores nulos ou vazios para nome e sobrenome
        nome = (nome == null || nome.trim().isEmpty()) ? "Usuário" : nome;
        sobrenome = (sobrenome == null || sobrenome.trim().isEmpty()) ? "Desconhecido" : sobrenome;
        
        // Formatação da resposta
        return String.format("(%s; %s, %s)", tratamento, sobrenome, nome);
    }
}
