/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.dao.ProdutoDAO;
import br.com.etec.exercicio.loja.dao.ProdutoDAOImpl;
import br.com.etec.exercicio.loja.exceptions.NegocioException;
import br.com.etec.exercicio.loja.model.Fornecedor;
import br.com.etec.exercicio.loja.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ProdutoController {

    ProdutoDAO produtoDAO = null;

    public ProdutoController() {

        if (produtoDAO == null) {

            produtoDAO = new ProdutoDAOImpl();

        }

    }

    public void cadastrarProdutoController(Fornecedor fornecedor, String nomeProduto, Double precoUnitario) throws NegocioException, Exception {

        if ((fornecedor == null) || (fornecedor.getCodFornecedor() == null)) {

            throw new Exception("Impossível cadastrar um Produto sem Fornecedor. Cadastre primeiramene o Fornecedor.");

        }

        validaProdutoString(nomeProduto, precoUnitario);

        Produto produto = new Produto();

        produto.setFlgAtivo(Boolean.TRUE);
        produto.setFornecedor(fornecedor);
        produto.setNomeProduto(nomeProduto.trim().toUpperCase());
        produto.setPrecoUnitario(precoUnitario);

        produtoDAO.save(produto);

    }

    public List<Produto> listarTodosProdutosController() throws Exception {

        List<Produto> listaSaida = new ArrayList<Produto>();

        listaSaida = produtoDAO.getAll(Produto.class);

        return listaSaida;

    }

    public Produto consultarProdutoByIdController(Integer codProduto) throws Exception {

        Produto produtoSaida = null;

        produtoSaida = produtoDAO.getById(Produto.class, codProduto);

        return produtoSaida;

    }

    public void atualizarProdutoFornecedorByIdController(Produto produto) throws NegocioException, Exception {

        if (produto == null) {

            throw new Exception("Impossível atualizar, Produto nulo");

        }

        validaProdutoString(produto.getNomeProduto(), produto.getPrecoUnitario());

        Produto produtoSaida = new Produto();
        produtoSaida.setCodProduto(produto.getCodProduto());
        produtoSaida.setFlgAtivo(produto.isFlgAtivo());
        produtoSaida.setFornecedor(produto.getFornecedor());
        produtoSaida.setNomeProduto(produto.getNomeProduto().trim().toUpperCase());
        produtoSaida.setPrecoUnitario(produto.getPrecoUnitario());

        //salva atualizando
        produtoDAO.save(produtoSaida);

    }

    public List<Produto> consultarProdutoByNomeController(String nome) throws NegocioException, Exception {

        List<Produto> listaSaida = new ArrayList<Produto>();

        if ((nome == null) || (nome.trim().isEmpty())) {

            return listaSaida;

        }

        listaSaida = produtoDAO.consultarProdutoByNomeDAO(nome.trim());

        return listaSaida;

    }

    private void validaProdutoString(String nomeProduto, Double precoUnitario) throws NegocioException, Exception {

        StringBuilder sbErrors = new StringBuilder();

        int idxErrors = 0;

        if ((nomeProduto == null) || (nomeProduto.isEmpty())) {

            sbErrors.append("- O Campo Nome do Produto deve ser preenchido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if (precoUnitario <= 0.0) {
            sbErrors.append("- Preço Unitário Inválido.");
            sbErrors.append("\n");
            idxErrors++;
        }

        if (idxErrors > 0) {

            throw new NegocioException(sbErrors.toString());

        }

    }

}
