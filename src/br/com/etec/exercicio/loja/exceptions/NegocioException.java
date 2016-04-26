/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.exceptions;

/**
 *
 * @author fernando-pucci
 * 
 * Exceção especialista em Regras de Negócio
 */
public class NegocioException extends Exception {

    public NegocioException(String message) {
        super("Erro de Negócio:\n" +message);
    }
}
