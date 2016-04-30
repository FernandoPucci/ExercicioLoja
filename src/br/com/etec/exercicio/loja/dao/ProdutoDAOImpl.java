/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.dao;

import br.com.etec.exercicio.loja.model.Produto;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author fernando-pucci
 */
public class ProdutoDAOImpl extends BaseDAOImpl<Produto, Integer> implements ProdutoDAO {

    @Override
    public List<Produto> consultarProdutoByNomeDAO(String nome) throws Exception {
        
         List<Produto> listaSaida = null;

        TypedQuery<Produto> query = getEntityManager().createQuery("SELECT P "
                + " FROM Produto P "
                + " where  P.nomeProduto like :nomeQuery "
                + " and P.flgAtivo = true ", Produto.class);
        
        query.setParameter("nomeQuery", "%" + nome + "%");
        listaSaida = query.getResultList();

        return listaSaida;
        
    }
    
}
