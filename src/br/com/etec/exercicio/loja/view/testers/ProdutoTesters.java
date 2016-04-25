/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.controller.FornecedorController;
import br.com.etec.exercicio.loja.controller.ProdutoController;
import br.com.etec.exercicio.loja.model.Fornecedor;
import br.com.etec.exercicio.loja.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ProdutoTesters {
    
    public static void main(String[] args) {
        
        try {

            //testa cadastrar Produto
            cadastrarProdutoTesters();

            //testa listagem de todos produtos cadastrados
            consultarTodosProdutosTesters();

            //testar consultar produto por ID
            consultarProdutoByIdTesters(1);

            //testar atualizar produto
            atualizarProdutoByIdTester(5);
            
            System.exit(0);
            
        } catch (Exception ex) {
            
            System.out.println(">>> ERRO NO TESTE: " + ex.getMessage());
            ex.printStackTrace();
            
        }
    }
    
    private static void cadastrarProdutoTesters() throws Exception {
        
        ProdutoController produtoController = new ProdutoController();
        
        System.out.println("CARREGA FORNECEDOR PARA PRODUTO:");
        
        FornecedorController fornecedorController = new FornecedorController();
        
        Fornecedor fornecedor = fornecedorController.consultarFornecedorByIdController(4);
        
        System.out.println("UTILIZANDO FORNECEDOR: " + fornecedor.getNomeFornecedor());
        
        produtoController.cadastrarProdutoController(fornecedor, "Coca-cola ZERO", 5.30D);
        
        System.out.println("TESTE OK");
        
    }
    
    private static void consultarTodosProdutosTesters() throws Exception {
        
        ProdutoController produtoController = new ProdutoController();
        
        List<Produto> listaProdutos = new ArrayList<Produto>();
        
        listaProdutos = produtoController.listarTodosProdutossController();
        
        if (listaProdutos.isEmpty()) {
            
            System.out.println("NÃO HÁ NENHUM PRODUTO CADASTRADO");
            
        } else {
            
            for (Produto p : listaProdutos) {
                
                System.out.println(p.toString());
                
            }
            
        }
        
    }
    
    private static void consultarProdutoByIdTesters(Integer codProduto) throws Exception {
        
        ProdutoController produtoController = new ProdutoController();
        System.out.println("Teste Consulta PRODUTO por ID " + codProduto);
        
        Produto produto = produtoController.consultarProdutoByIdController(codProduto);
        
        System.out.println(produto.toString());
        
    }
    
    private static void atualizarProdutoByIdTester(Integer codProduto) throws Exception {
        
        ProdutoController produtoController = new ProdutoController();
        System.out.println("Teste Consulta/atualzacao PRODUTO por ID " + codProduto);
        
        Produto produto = produtoController.consultarProdutoByIdController(codProduto);
        
        if (produto == null) {
            
            System.out.println("NÃO HÁ NENHUM PRODUTO REGISTRADO COM ESTE CODIGO: " + codProduto);
            
        } else {
            
            produto.setNomeProduto("sprite");
            produto.setPrecoUnitario(4.00D);
            
            produtoController.atualizarProdutoFornecedorByIdController(produto);
            
        }
        
    }
    
}
