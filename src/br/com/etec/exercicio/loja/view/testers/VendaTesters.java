/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.controller.ClienteController;
import br.com.etec.exercicio.loja.controller.VendaController;
import br.com.etec.exercicio.loja.model.Cliente;
import br.com.etec.exercicio.loja.model.Venda;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class VendaTesters {

    public static void main(String[] args) {
        try {
            //testa cadastrar Venda
            //cadastrarVendaTesters();

            //testa listagem de todos vendas cadastrados
            consultarTodasVendasTesters();
            //testar consultar venda por ID
             consultarVendaByIdTesters(1);
            //testar atualizar venda
             atualizarVendaByIdTester(1);
             
             //consulta venda atualizada
             consultarVendaByIdTesters(1);
            System.exit(0);
        } catch (Exception ex) {

            System.out.println(">>> ERRO NO TESTE: " + ex.getMessage());
            ex.printStackTrace();

        }
    }

    private static void cadastrarVendaTesters() throws Exception {

        System.out.println("CARREGA CLIENTE PARA VENDA:");
        ClienteController clienteController = new ClienteController();

        Cliente clienteVenda = clienteController.consultarClienteByIdController(1);

        System.out.println("CADASTRANDO VENDA PARA CLIENTE: " + clienteVenda.getNome() + " " + clienteVenda.getSobrenome());

        VendaController vendaController = new VendaController();

        vendaController.cadastrarVendaController(clienteVenda);

    }

    private static void consultarTodasVendasTesters() throws Exception {

        VendaController vendaController = new VendaController();

        List<Venda> listaVendas = new ArrayList<Venda>();

        listaVendas = vendaController.listarTodasVendasController();

        if (listaVendas.isEmpty()) {
            throw new Exception("NÃO HÁ NENHUMA VENDA CADASTRADA.");

        } else {

            for (Venda v : listaVendas) {

                System.out.println(v.toString());

            }

        }

    }

    private static void consultarVendaByIdTesters(int codVenda) throws Exception {

        VendaController vendaController = new VendaController();

        Venda vendaSaida = new Venda();

        vendaSaida = vendaController.consultarVendaByIdController(codVenda);

        if (vendaSaida == null) {
            throw new Exception("NÃO HÁ NENHUMA VENDA CADASTRADA PARA ESTE CÓDIGO [ " + codVenda + " ].");

        } else {

            System.out.println(vendaSaida.toString());

        }

    }

    private static void atualizarVendaByIdTester(int codVenda)  throws Exception{
       
        VendaController vendaController = new VendaController();

        Venda vendaSaida = new Venda();

        vendaSaida = vendaController.consultarVendaByIdController(codVenda);

        if (vendaSaida == null) {
            throw new Exception("NÃO HÁ NENHUMA VENDA CADASTRADA PARA ESTE CÓDIGO [ " + codVenda + " ].");

        } else {

               vendaSaida.setValorTotal(0.0);
               // vendaSaida.setValorTotal(vendaSaida.getValorTotal() + 1.50);
               // vendaSaida.setDataNota(new Date(System.currentTimeMillis()));
                vendaController.atualizarVendaController(vendaSaida);

        }
        
        
    }

}
