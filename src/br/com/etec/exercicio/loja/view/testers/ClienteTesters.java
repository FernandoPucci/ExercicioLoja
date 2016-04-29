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
            //consultarTodosClientesTester();

            //testa consulta cliente por codigo
            //consultarClienteByIdTester(5);

            //testar atualização do cliente
            //atualizarClienteByIdTesters(1);
            
            //testa a consulta por trecho de nome/sobrenome
            consultarClienteByNomeSobrenomeTester("ilv");

        } catch (Exception ex) {

            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
            
        } finally {

            System.exit(0);
            
        }

    }

    private static void cadastrarClienteTester() throws Exception {

        //Cria uma instancia do objeto ClienteController
        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Cadastrando cliente");
        clienteController.cadastrarClienteController("Ricardo", "Akira", "61175806579", "RUA ANTONIO CRISTOVAM, 543", "MOCOCA", "SP");
//        clienteController.cadastrarClienteController("Júlio", "Pereira Gomes", "74392297896", "Rua Avelino Jacó da Silva, 729", "Juiz de Fora", "MG");
//        clienteController.cadastrarClienteController("Samuel", "Araujo Santos", "61175806579", "Rua Alvarenga Peixoto, 257", "Ituiutaba", "MG");
//        clienteController.cadastrarClienteController("Letícia", "Cavalcanti Goncalves", "19307906602", "Rua Sargento Jayme Pantaleão, 1393", "Maceió", "AL");
//        clienteController.cadastrarClienteController("Gustavo", "Dias Lima", "71374283800", "Rua Ernesto Cosmo Fioretti, 1133", "Campinas", "SP");
//        clienteController.cadastrarClienteController("Brenda", "Costa Almeida", "21784060763", "Rua Esperanto, 708", "Rio de Janeiro", "RJ");
//        clienteController.cadastrarClienteController("Tânia", "Souza Rocha", "94562965207", "Quadra SRES Quadra 04 Bloco R, 1345", "Cruzeiro", "df");
//        clienteController.cadastrarClienteController("Felipe", "Souza Goncalves", "45503381050", "Rua Domingos Furtado Valadares, 1235", "São Paulo", "SP");
//        clienteController.cadastrarClienteController("Anna", "Barros Silva", "50205448844", "Rua Resende, 1189", "Guarapuava", "PR");
//        clienteController.cadastrarClienteController("Breno", "Correia Gomes", "29159937858", "Rua Antônio Barzaque Primo, 708", "Araçatuba", "SP");
//        clienteController.cadastrarClienteController("Sophia", "Souza Cardoso", "91204552320", "Rua Doutor José Augusto, 1130", "JAU", "SP");
        //clienteController.cadastrarClienteController("Jose", "Pedro da Silva", "65931313001", "Rua Escorrega la vai um", "Mococa", "SP");
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

        } else {

            System.out.println("NÃO FOI ENCONTRADO NENHUM CLIENTE PARA O CODIGO [" + codCliente + "]");
        }

        System.out.println("Teste OK");

    }

    public static void atualizarClienteByIdTesters(Integer codCliente) throws Exception {

        ClienteController clienteController = new ClienteController();
        System.out.println("Teste Consulta/atualzacao CLIENTE por ID " + codCliente);

        Cliente cliente = null;

        cliente = clienteController.consultarClienteByIdController(codCliente);

        if (cliente != null) {

            //atualiza cidade
            cliente.setCpf("38658963756");
            cliente.setCidade("Monte Santo de Minas");
            cliente.setEndereco("Av. Vital Paulino Costa, 310");
            cliente.setEstado("MG");
            clienteController.atualizarClienteByIdController(cliente);

        } else {

            System.out.println("NÃO FOI ENCONTRADO NENHUM CLIENTE PARA O CODIGO [" + codCliente + "]");
        }

    }
    
     private static void consultarClienteByNomeSobrenomeTester(String nome) throws Exception {
     
     ClienteController clienteController = new ClienteController();
     
     List<Cliente> listaCliente = clienteController.consultarClienteByNomeSobrenomeController(nome);
         
     for(Cliente c : listaCliente){
     
         System.out.println(c.toString());
     
     }
     
     }

}
