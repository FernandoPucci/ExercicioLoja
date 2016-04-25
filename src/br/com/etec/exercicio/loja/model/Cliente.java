/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author fernando-pucci
 */
@Entity
@Table(name = "CLIENTE")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Cliente  implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COD_CLIENTE")    
    private Integer codCliente;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FLG_ATIVO")
    private Boolean flgAtivo;

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Boolean flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

  

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", endereco=" + endereco + ", cidade=" + cidade + ", estado=" + estado + ", flgAtivo=" + flgAtivo + '}';
    }

}
