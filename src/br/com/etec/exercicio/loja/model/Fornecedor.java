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
@Table(name = "FORNECEDOR")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Fornecedor implements java.io.Serializable{

    /*
     COD_FORNECEDOR
     NOME_FORNECEDOR
     CIDADE
     ESTADO
     FLG_ATIVO
    
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COD_FORNECEDOR")
    private Integer codFornecedor;

    @Column(name = "NOME_FORNECEDOR")
    private String nomeFornecedor;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FLG_ATIVO")    
    private Boolean flgAtivo;

    public Integer getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(Integer codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
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

    public Boolean isFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Boolean flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "codFornecedor=" + codFornecedor + ", nomeFornecedor=" + nomeFornecedor + ", cidade=" + cidade + ", estado=" + estado + ", flgAtivo=" + flgAtivo + '}';
    }

}
