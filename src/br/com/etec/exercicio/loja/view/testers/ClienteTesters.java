/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.model.Cliente;
import br.com.etec.exercicio.loja.controller.ClienteController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ClienteTesters {

    //Teste Funcionalidades de Cliente
    public static void main(String[] args) {

        try {

            //testa o cadstro do clente
            cadastrarClienteTester();

            //testa a consulta dos clientes
            consultarTodosClientesTester();
            
            //testa consulta cliente por codigo
            consultarClienteByIdTester(5);
            
            
            //testar atualização do cliente
            atualizarClienteByIdTesters(2);

            System.exit(0);
        } catch (Exception ex) {

            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    private static void cadastrarClienteTester() throws Exception {

        //Cria uma instancia do objeto ClienteController
        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Cadastrando cliente");
        clienteController.cadastrarClienteController("JOSE", "DA SILVA", "38658963756", "RUA ANTONIO CRISTOVAM, 543", "MOCOCA", "SP");
        System.out.println("Teste OK");

    }

    private static void consultarTodosClientesTester() throws Exception {

        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Listando clientes");

        List<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes = clienteController.listarTodosClientesController();

        for (Cliente c : listaClientes) {

            System.out.println(c.toString());

        }

        System.out.println("Teste OK");

    }

      private static void consultarClienteByIdTester(Integer codCliente) throws Exception {

        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Consulta CLIENTE por ID " + codCliente);

        Cliente cliente = null;

        cliente = clienteController.consultarClienteByIdController(codCliente);

        if (cliente != null) {

            System.out.println(cliente.toString());

        }else{
        
            System.out.println("NÃO FOI ENCONTRADO NENHUM CLIENTE PARA O CODIGO [" + codCliente + "]");
        }

        System.out.println("Teste OK");

    }
      
      
         public static void  atualizarClienteByIdTesters(Integer codCliente) throws Exception{
    
        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Consulta/atualzacao CLIENTE por ID " + codCliente);

        Cliente cliente = null;

        cliente = clienteController.consultarClienteByIdController(codCliente);

        if (cliente != null) {

            //atualiza cidade
            cliente.setCidade("Monte Santo de Minas");
            cliente.setEndereco("Av. Vital Paulino Costa, 310");
            cliente.setEstado("MG");
            clienteController.atualizarClienteByIdController(cliente);
            
        }else{
        
            System.out.println("NÃO FOI ENCONTRADO NENHUM CLIENTE PARA O CODIGO [" + codCliente + "]");
        }
    
    
    }
    
    
}
