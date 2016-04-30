/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.model.Fornecedor;
import br.com.etec.exercicio.loja.dao.FornecedorDAO;
import br.com.etec.exercicio.loja.dao.FornecedorDAOImpl;
import br.com.etec.exercicio.loja.exceptions.NegocioException;
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

    public Fornecedor consultarFornecedorByIdController(Integer codFornecedor) throws Exception {

        Fornecedor fornecedorSaida = null;

        fornecedorSaida = fornecedorDAO.getById(Fornecedor.class, codFornecedor);

        return fornecedorSaida;

    }

    public void atualizarFornecedorByIdController(Fornecedor fornecedor) throws Exception {

        Fornecedor fornecedorSaida = new Fornecedor();
        fornecedorSaida.setCidade(fornecedor.getCidade().trim().toUpperCase());
        fornecedorSaida.setCodFornecedor(fornecedor.getCodFornecedor());
        fornecedorSaida.setFlgAtivo(Boolean.TRUE);

        fornecedorSaida.setEstado(fornecedor.getEstado().trim().toUpperCase());
        fornecedorSaida.setNomeFornecedor(fornecedor.getNomeFornecedor().trim().toUpperCase());

        //salva atualizando
        fornecedorDAO.save(fornecedorSaida);

    }

    public List<Fornecedor> consultarFornecedorByNomeController(String nome) throws NegocioException, Exception {

        List<Fornecedor> listaSaida = new ArrayList<Fornecedor>();

        if ((nome == null) || (nome.trim().isEmpty())) {

            return listaSaida;

        }

        listaSaida = fornecedorDAO.consultarFornecedorByNomeDAO(nome.trim());

        return listaSaida;

    }

}
