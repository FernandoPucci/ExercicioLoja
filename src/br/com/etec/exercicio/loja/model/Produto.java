/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fernando-pucci
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements java.io.Serializable {

    /*
     COD_PRODUTO
     COD_FORNECEDOR
     NOME_PRODUTO
     PRECO_UNITARIO
     FLG_ATIVO
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COD_PRODUTO")
    private Integer codProduto;

    @OneToOne(fetch = FetchType.LAZY)
    private Fornecedor fornecedor;

    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;

    @Column(name = "PRECO_UNITARIO")
    private Double precoUnitario;

    @Column(name = "FLG_ATIVO")
    private Boolean flgAtivo;

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Boolean isFlgAtivo() {
        return flgAtivo;
    }

    public void setFlgAtivo(Boolean flgAtivo) {
        this.flgAtivo = flgAtivo;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", fornecedor=" + fornecedor + ", nomeProduto=" + nomeProduto + ", precoUnitario=" + precoUnitario + ", flgAtivo=" + flgAtivo + '}';
    }

}
