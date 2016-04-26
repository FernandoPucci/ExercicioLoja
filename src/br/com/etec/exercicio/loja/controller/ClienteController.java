/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.controller;

import br.com.etec.exercicio.loja.model.Cliente;
import br.com.etec.exercicio.loja.dao.ClienteDAO;
import br.com.etec.exercicio.loja.dao.ClienteDAOImpl;
import br.com.etec.exercicio.loja.exceptions.NegocioException;
import br.com.etec.exercicio.loja.util.Utils;
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

    public void cadastrarClienteController(String nome, String sobrenome, String cpf, String endereco, String cidade, String estado) throws NegocioException, Exception {

        //TODO: fazer validacoes necess?rias, e em caso de erro, retornar Exceção.
        //Cria um novo objeto cliente, 
        //para ser carregado com os dados recebidos pelos parametros
        StringBuilder sbErrors = new StringBuilder();

        int idxErrors = 0;

        if ((nome == null) || (nome.isEmpty())) {

            sbErrors.append("- O Campo Nome do Cliente deve ser preenchido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if ((sobrenome == null) || (sobrenome.isEmpty())) {

            sbErrors.append("- O Campo Sobrenome do Cliente deve ser preenchido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if (!Utils.validarCpf(cpf)) {

            sbErrors.append("- CPF Inválido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if ((cidade == null) || (cidade.isEmpty())) {

            sbErrors.append("- O Campo Cidade do Cliente deve ser preenchido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if ((cidade == null) || (cidade.isEmpty())) {

            sbErrors.append("- O Campo Cidade do Cliente deve ser preenchido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if (!Utils.validarSiglaUF(estado)) {
            
            sbErrors.append("- Estado Inválido.");
            sbErrors.append("\n");
            idxErrors++;

        }

        if (idxErrors > 0) {

            throw new NegocioException(sbErrors.toString());

        }

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

    public List<Cliente> listarTodosClientesController() throws NegocioException, Exception {

        List<Cliente> listaSaida = new ArrayList<Cliente>();

        listaSaida = clienteDAO.getAll(Cliente.class);

        return listaSaida;

    }

    public Cliente consultarClienteByIdController(Integer codCliente) throws NegocioException, Exception {

        Cliente clienteSaida = null;

        clienteSaida = clienteDAO.getById(Cliente.class, codCliente);

        return clienteSaida;

    }

    public void atualizarClienteByIdController(Cliente cliente) throws NegocioException, Exception {

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
