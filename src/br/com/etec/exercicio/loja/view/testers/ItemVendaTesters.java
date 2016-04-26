/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view.testers;

import br.com.etec.exercicio.loja.controller.ItemVendaController;
import br.com.etec.exercicio.loja.controller.ProdutoController;
import br.com.etec.exercicio.loja.controller.VendaController;
import br.com.etec.exercicio.loja.model.ItemVenda;
import br.com.etec.exercicio.loja.model.Produto;
import br.com.etec.exercicio.loja.model.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ItemVendaTesters {

    public static void main(String[] args) {

        try {
            //testa cadastrar ItemVenda                
            //cadastrarItemVendaTesters();
            //testar listar todos itens venda geral
            listarTodosItensVendaTesters();
            //testar atualizar Item Venda
             atualizarItemVendaTesters(1);

            System.exit(0);
        } catch (Exception ex) {

            System.out.println(">>> ERRO NO TESTE: " + ex.getMessage());
            ex.printStackTrace();

        }

    }

    private static void cadastrarItemVendaTesters() throws Exception {
        System.out.println("CARREGAR VENDA PARA ATRIBUIR ITEMVENDA");
        VendaController vendaController = new VendaController();
        Venda venda = vendaController.consultarVendaByIdController(1);

        System.out.println("CARREGAR PRODUTO PARA ATRIBUIR ITEMVENDA");

        ProdutoController produtoController = new ProdutoController();
        Produto produto = null;

        produto = produtoController.consultarProdutoByIdController(5);

        ItemVendaController itemVendaController = new ItemVendaController();

        Double quantidadeVendida = 3.0;

        System.out.println("CADASTRA ITEMVENDA");
        itemVendaController.cadastrarItemVendaController(venda, produto, quantidadeVendida);

        venda.setValorTotal(venda.getValorTotal() + (produto.getPrecoUnitario() * quantidadeVendida));

        System.out.println("ATUALIZA VENDA");
        vendaController.atualizarVendaController(venda);

    }

    private static void listarTodosItensVendaTesters() throws Exception {

        ItemVendaController itemVendaController = new ItemVendaController();

        List<ItemVenda> listaSaida = new ArrayList<ItemVenda>();

        listaSaida = itemVendaController.listarTodosItensVendaController();

        if (listaSaida.isEmpty()) {

            throw new Exception("NÃO HÁ NENHUM ITEM VENDA CADASTRADO");

        } else {

            for (ItemVenda iv : listaSaida) {

                System.out.println(iv.toString());

            }

        }

    }

    private static void atualizarItemVendaTesters(int codItemVenda) throws Exception {

        ItemVendaController itemVendaController = new ItemVendaController();

        System.out.println("CONSULTA ITEMVENDA");
        ItemVenda itemVendaAtualizar = itemVendaController.consultarItemVendaByIdController(codItemVenda);

        if (itemVendaAtualizar == null) {
            
            throw new Exception("NÃO HÁ NENHUM ITEM VENDA CORRESPONDENTE A ESTE CODIGO [" + codItemVenda + "].");

        }

        System.out.println("CARREGAR VENDA PARA ATUALIZAR ITEMVENDA");
        VendaController vendaController = new VendaController();
        Venda vendaAtualizarItemVenda = vendaController.consultarVendaByIdController(itemVendaAtualizar.getVenda().getCodVenda());

        System.out.println("CARREGAR PRODUTO PARA ATUALIZAR ITEMVENDA");

        ProdutoController produtoController = new ProdutoController();
        Produto produtoAtualizarItemVenda = null;

        produtoAtualizarItemVenda = produtoController.consultarProdutoByIdController(itemVendaAtualizar.getProduto().getCodProduto());

        Double quantidadeVendida = 1.0;

        System.out.println("ATUALIZAR ITEMVENDA");
   
        itemVendaController.atualizarItemVendaController(itemVendaAtualizar, produtoAtualizarItemVenda, quantidadeVendida);
        itemVendaAtualizar.setVenda(vendaAtualizarItemVenda);

        vendaAtualizarItemVenda.setValorTotal(vendaAtualizarItemVenda.getValorTotal() + (produtoAtualizarItemVenda.getPrecoUnitario() * quantidadeVendida));

        System.out.println("ATUALIZA VENDA");
        vendaController.atualizarVendaController(vendaAtualizarItemVenda);

    }

}
