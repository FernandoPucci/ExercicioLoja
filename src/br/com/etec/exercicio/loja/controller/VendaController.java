/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.dao.VendaDAO;
import br.com.etec.exercicio.loja.dao.VendaDAOImpl;
import br.com.etec.exercicio.loja.model.Cliente;
import br.com.etec.exercicio.loja.model.Venda;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class VendaController {

    VendaDAO vendaDAO = null;

    public VendaController() {

        if (vendaDAO == null) {

            vendaDAO = new VendaDAOImpl();

        }

    }

    public void cadastrarVendaController(Cliente cliente) throws Exception {

        Venda vendaSaida = null;

        if (cliente == null) {

            throw new Exception("A Venda deve ser atribuída a um Cliente. Cliente nulo.");

        }

        vendaSaida = new Venda();

        vendaSaida.setCliente(cliente);
        vendaSaida.setValorTotal(0.0); //venda é cadastrada com valor 0 depois atualizada
        vendaSaida.setDataNota(new Date(System.currentTimeMillis()));

        vendaDAO.save(vendaSaida);

    }

    public List<Venda> listarTodasVendasController() throws Exception {

        List<Venda> listaSaida = new ArrayList<Venda>();

        listaSaida = vendaDAO.getAll(Venda.class);

        return listaSaida;

    }

    public Venda consultarVendaByIdController(Integer codVenda) throws Exception {

        Venda vendaSaida = null;

        if (codVenda == null) {

            throw new Exception("Código de venda inválido");

        }

        vendaSaida = vendaDAO.getById(Venda.class, codVenda);

        return vendaSaida;

    }

    public void atualizarVendaController(Venda venda) throws Exception {

        Venda vendaSaida = null;

        if (venda == null) {

            throw new Exception("Impossível atualizar, venda vazia.");

        }

        if (venda.getCliente() == null) {

            throw new Exception("Impossível atualizar, venda sem Cliente associado.");

        }
        
        vendaSaida = new Venda();

        vendaSaida.setCodVenda(venda.getCodVenda());
        vendaSaida.setCliente(venda.getCliente());
        vendaSaida.setDataNota(venda.getDataNota());
        vendaSaida.setValorTotal(venda.getValorTotal());

        vendaDAO.save(vendaSaida);
        
    }

}
