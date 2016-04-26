/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.dao.ItemVendaDAO;
import br.com.etec.exercicio.loja.dao.ItemVendaDAOImpl;
import br.com.etec.exercicio.loja.model.ItemVenda;
import br.com.etec.exercicio.loja.model.Produto;
import br.com.etec.exercicio.loja.model.Venda;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ItemVendaController {

    ItemVendaDAO itemVendaDAO = null;

    public ItemVendaController() {

        if (itemVendaDAO == null) {

            itemVendaDAO = new ItemVendaDAOImpl();

        }

    }

    public void cadastrarItemVendaController(Venda venda, Produto produto, Double quantidade) throws Exception {

        ItemVenda itemVendaSaida = null;

        if (venda == null) {

            throw new Exception("Impossível registrar Item venda. É necessária uma VENDA associada.");

        }

        if (produto == null) {

            throw new Exception("Impossível registrar Item venda. É necessário um PRODUTO associada.");

        }

        itemVendaSaida = new ItemVenda();

        itemVendaSaida.setVenda(venda);
        itemVendaSaida.setProduto(produto);
        itemVendaSaida.setQuantidade(quantidade);

        itemVendaDAO.save(itemVendaSaida);

    }

    public ItemVenda consultarItemVendaByIdController(Integer codItemVenda) throws Exception {

        ItemVenda itemVendaSaida = null;

        itemVendaSaida = itemVendaDAO.getById(ItemVenda.class, codItemVenda);

        return itemVendaSaida;

    }

    public List<ItemVenda> listarTodosItensVendaController() throws Exception {

        List<ItemVenda> listaSaida = null;

        listaSaida = itemVendaDAO.getAll(ItemVenda.class);

        return listaSaida;

    }

    public void atualizarItemVendaController(ItemVenda itemVenda, Produto produto, Double quantidade) throws Exception {

        ItemVenda itemVendaSaida = null;

        if (itemVenda == null) {

            throw new Exception("Impossível atualizar Item venda. É necessária um ITEM VENDA associada.");

        }

        if (produto == null) {

            throw new Exception("Impossível atualizar Item venda. É necessário um PRODUTO associada.");

        }

        itemVendaSaida = new ItemVenda();

        itemVendaSaida.setCodItemVenda(itemVenda.getCodItemVenda());
        itemVendaSaida.setVenda(itemVenda.getVenda());
        itemVendaSaida.setProduto(produto);
        itemVendaSaida.setQuantidade(quantidade);

        itemVendaDAO.save(itemVendaSaida);

    }

}
