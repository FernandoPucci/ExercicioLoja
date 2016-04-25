/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.model.Cliente;
import br.com.etec.exercicio.loja.dao.ClienteDAO;
import br.com.etec.exercicio.loja.dao.ClienteDAOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando-pucci
 */
public class ClienteController {

    ClienteDAO clienteDAO = null;

    public ClienteController() {

        if (clienteDAO == null) {

            clienteDAO = new ClienteDAOImpl();
        }

    }

    public void cadastrarClienteController(String nome, String sobrenome, String cpf, String endereco, String cidade, String estado) throws Exception {

        //TODO: fazer validacoes necess?rias, e em caso de erro, retornar Exce??o.
        //Cria um novo objeto cliente, 
        //para ser carregado com os dados recebidos pelos parametros
        Cliente cliente = new Cliente();

        cliente.setNome(nome.trim().toUpperCase());
        cliente.setSobrenome(sobrenome.trim().toUpperCase());
        cliente.setCpf(cpf.trim().toUpperCase());
        cliente.setEndereco(endereco.trim().toUpperCase());
        cliente.setCidade(cidade.trim().toUpperCase());
        cliente.setEstado(estado.trim().toUpperCase());
        cliente.setFlgAtivo(true); //flgAtivo sempre TRUE ao cadastrar um Cliente

        //salva um cliente
        clienteDAO.save(cliente);

    }

    public List<Cliente> listarTodosClientesController() {

        List<Cliente> listaSaida = new ArrayList<Cliente>();

        listaSaida = clienteDAO.getAll(Cliente.class);

        return listaSaida;

    }

    public Cliente consultarClienteByIdController(Integer codCliente) {

        Cliente clienteSaida = null;

        clienteSaida = clienteDAO.getById(Cliente.class, codCliente);

        return clienteSaida;

    }

    public void atualizarClienteByIdController(Cliente cliente) throws Exception {

        Cliente clienteSaida = new Cliente();

        clienteSaida.setCodCliente(cliente.getCodCliente());
        clienteSaida.setCidade(cliente.getCidade().trim().toUpperCase());
        clienteSaida.setNome(cliente.getNome().trim().toUpperCase());
        clienteSaida.setSobrenome(cliente.getSobrenome().trim().toUpperCase());
        clienteSaida.setFlgAtivo(cliente.getFlgAtivo());
        clienteSaida.setEndereco(cliente.getEndereco().trim().toUpperCase());
        clienteSaida.setEstado(cliente.getEstado().trim().toUpperCase());
        clienteSaida.setCpf(cliente.getCpf().trim().toUpperCase());

        //salva atualizando
        clienteDAO.save(clienteSaida);

    }

}
