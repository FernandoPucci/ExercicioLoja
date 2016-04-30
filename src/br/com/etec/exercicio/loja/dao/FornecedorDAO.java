/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.dao;

import br.com.etec.exercicio.loja.model.Fornecedor;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public interface FornecedorDAO extends BaseDAO<Fornecedor, Integer> {
    
    public List<Fornecedor> consultarFornecedorByNomeDAO(String nome) throws Exception;
    
        
}
