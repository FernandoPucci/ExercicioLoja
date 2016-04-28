/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.dao;

import br.com.etec.exercicio.loja.model.Cliente;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public interface ClienteDAO extends BaseDAO<Cliente, Integer> {

      public List<Cliente> consultarClienteByNomeSobrenomeDAO(String nome) throws Exception;
       
}
