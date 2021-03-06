/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.controller.FornecedorController;
import br.com.etec.exercicio.loja.model.Fornecedor;
import br.com.etec.exercicio.loja.controller.FornecedorController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class FornecedorTesters {

    public static void main(String[] args) {

        try {

            //testa o cadastro do fornecedor
//            cadastrarFornecedor();
            //testa a consulta dos fornecedores
//            consultarTodosFornecedoresTester();
            //testa consulta fornecedor por codigo
//            consultarFornecedorByIdTester(997);
            //testa atualizacao de fornecedor
//            atualizarFornecedorByIdTesters(4);
            //teta consultaFornecedorPorNome
            consultarFornecedorByNomeTester("Cola");
            
            
        } catch (Exception ex) {

            System.out.println("ERRO: " + ex.getMessage());
            ex.printStackTrace();
        } finally {

            System.exit(0);

        }

    }
    

    private static void cadastrarFornecedor() throws Exception {

        FornecedorController fornecedorController = new FornecedorController();

        fornecedorController.cadastrarFornecedorController("COCA-COLA", "Ribeirão preto", "SP");

    }

    private static void consultarTodosFornecedoresTester() throws Exception {

        FornecedorController fornecedorController = new FornecedorController();
        System.out.println("Teste Listando FORNECEDORES");

        List<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

        listaFornecedores = fornecedorController.listarTodosFornecedoresController();

        for (Fornecedor c : listaFornecedores) {

            System.out.println(c.toString());

        }

        System.out.println("Teste OK");

    }

    private static void consultarFornecedorByIdTester(Integer codFornecedor) throws Exception {

        FornecedorController fornecedorController = new FornecedorController();
        System.out.println("Teste Consulta FORNECEDOR por ID " + codFornecedor);

        Fornecedor fornecedor = null;

        fornecedor = fornecedorController.consultarFornecedorByIdController(codFornecedor);

        if (fornecedor != null) {

            System.out.println(fornecedor.toString());

        } else {

            System.out.println("NÃO FOI ENCONTRADO NENHUM FORNECEDOR PARA O CODIGO [" + codFornecedor + "]");
        }

        System.out.println("Teste OK");

    }

    public static void atualizarFornecedorByIdTesters(Integer codFornecedor) throws Exception {

        FornecedorController fornecedorController = new FornecedorController();
        System.out.println("Teste Consulta/atualzacao FORNECEDOR por ID " + codFornecedor);

        Fornecedor fornecedor = null;

        fornecedor = fornecedorController.consultarFornecedorByIdController(codFornecedor);

        if (fornecedor != null) {

            //atualiza cidade
            fornecedor.setCidade("Monte Santo de Minas");
            fornecedor.setEstado("MG");
            fornecedorController.atualizarFornecedorByIdController(fornecedor);

        } else {

            System.out.println("NÃO FOI ENCONTRADO NENHUM FORNECEDOR PARA O CODIGO [" + codFornecedor + "]");
        }

    }

    private static void consultarFornecedorByNomeTester(String nome) throws Exception {

        FornecedorController fornecedorController = new FornecedorController();

        List<Fornecedor> listaFornecedor = fornecedorController.consultarFornecedorByNomeController(nome);

        for (Fornecedor f : listaFornecedor) {

            System.out.println(f.toString());

        }

    }

}
