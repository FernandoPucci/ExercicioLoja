/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.util.Utils;

/**
 *
 * @author fernando-pucci
 */
public class UtilsTesters {

    public static void main(String[] args) {
        ///teste CPF
        System.out.println(Utils.validarCpf("05485767rf9"));
        System.out.println(Utils.validarCpf("07771759165"));

        System.out.println("\n\n");
        //TESTE CNPJ

        System.out.println(Utils.validarCnpj("dd05869529000160"));
        System.out.println(Utils.validarCnpj("79139275000160"));
        System.out.println("\n\n");

        //TESTE VALIDA UF
        System.out.println(Utils.validarSiglaUF("XX"));
        System.out.println(Utils.validarSiglaUF(""));
        System.out.println(Utils.validarSiglaUF("XXXX"));
        System.out.println(Utils.validarSiglaUF("MG"));
        System.out.println(Utils.validarSiglaUF("rj"));

    }

}
