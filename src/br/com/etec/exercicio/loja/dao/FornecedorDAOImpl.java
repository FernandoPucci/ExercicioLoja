/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.dao;

import br.com.etec.exercicio.loja.model.Fornecedor;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author fernando-pucci
 */
public class FornecedorDAOImpl extends BaseDAOImpl<Fornecedor, Integer> implements FornecedorDAO {

    @Override
    public List<Fornecedor> consultarFornecedorByNomeDAO(String nome) throws Exception {
        
        List<Fornecedor> listaSaida = null;

        TypedQuery<Fornecedor> query = getEntityManager().createQuery("SELECT F "
                + " FROM Fornecedor F "
                + " where  F.nomeFornecedor like :nomeQuery "
                + " and F.flgAtivo = true ", Fornecedor.class);
        
        query.setParameter("nomeQuery", "%" + nome + "%");
        listaSaida = query.getResultList();

        return listaSaida;
        
    }
   
}
