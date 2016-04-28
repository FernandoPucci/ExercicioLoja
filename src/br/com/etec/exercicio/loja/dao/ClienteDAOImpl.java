/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.dao;

import br.com.etec.exercicio.loja.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author fernando-pucci
 */
public class ClienteDAOImpl extends BaseDAOImpl<Cliente, Integer> implements ClienteDAO {

    @Override
    public List<Cliente> consultarClienteByNomeSobrenomeDAO(String nome) throws Exception {

        List<Cliente> listaSaida = null;

        TypedQuery<Cliente> query = getEntityManager().createQuery("SELECT C "
                + "FROM Cliente C "
                + "where  C.nome like :nomeQuery "
                + "or C.sobrenome like :nomeQuery "
                + "and C.flgAtivo = true ", Cliente.class);
        
        query.setParameter("nomeQuery", "%" + nome + "%");
        listaSaida = query.getResultList();

        return listaSaida;

    }

}
