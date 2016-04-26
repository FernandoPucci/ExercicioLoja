/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.util;

import br.com.etec.exercicio.loja.util.constantes.Constantes;
import java.util.Map;

/**
 *
 * @author fernando-pucci
 */
public class Utils {

    public static boolean validarCpf(String cpf) {

        if ((cpf == null) || (cpf.trim().isEmpty())) {
            return false;
        }

        for (int i = 0; i < cpf.length(); i++) {
            if (!Character.isDigit(cpf.charAt(i))) {
                return false;
            }
        }

        return Cpf.isValidCPF(cpf.trim());

    }

    public static boolean validarCnpj(String cnpj) {

        if ((cnpj == null) || (cnpj.trim().isEmpty())) {
            return false;
        }

        for (int i = 0; i < cnpj.length(); i++) {
            if (!Character.isDigit(cnpj.charAt(i))) {
                return false;
            }
        }

        return Cpf.isValidCNPJ(cnpj.trim());

    }

    public static boolean validarSiglaUF(String uf) {

        if ((uf == null) || (uf.isEmpty()) || (uf.length() != 2)) {
            return false;
        }

        for (Map.Entry<String, String> entry : Constantes.estadoSiglas.entrySet()) {

            if (uf.trim().toUpperCase().equals(entry.getValue())) {
                return true;
            }

        }

        return false;

    }

}
