/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio.loja.controller;

import br.com.etec.exercicio.loja.model.Fornecedor;
import br.com.exercicio.loja.dao.FornecedorDAO;
import br.com.exercicio.loja.dao.FornecedorDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class FornecedorController {

    FornecedorDAO fornecedorDAO = null;

    public FornecedorController() {

        if (fornecedorDAO == null) {

            fornecedorDAO = new FornecedorDAOImpl();
        }

    }

    public void cadastrarFornecedorController(String nome, String cidade, String estado) throws Exception {

        //realizar valida??es
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCidade(cidade.trim().toUpperCase());
        fornecedor.setEstado(estado.trim().toUpperCase());
        fornecedor.setNomeFornecedor(nome.trim().toUpperCase());
        fornecedor.setFlgAtivo(true);

        fornecedorDAO.save(fornecedor);

    }

    public List<Fornecedor> listarTodosFornecedoresController() throws Exception {

        List<Fornecedor> listaSaida = new ArrayList<Fornecedor>();

        listaSaida = fornecedorDAO.getAll(Fornecedor.class);

        return listaSaida;

    }

    public Fornecedor consultarFornecedorByIdController(Integer codFornecedor) {

        Fornecedor fornecedorSaida = null;

        fornecedorSaida = fornecedorDAO.getById(Fornecedor.class, codFornecedor);

        return fornecedorSaida;

    }

}
