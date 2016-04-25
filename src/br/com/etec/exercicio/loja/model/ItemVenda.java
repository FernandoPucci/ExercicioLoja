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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author fernando-pucci
 */
@Entity
@Table(name = "ITEM_VENDA")
public class ItemVenda implements java.io.Serializable {

    /*
     COD_ITEM
     COD_VENDA
     COD_PRODUTO
     QUANTIDADE
    
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COD_ITEM")
    private Integer codItemVenda;


    @ManyToOne
    @JoinColumn(name = "COD_VENDA")
    private Venda venda;

    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    public Integer getCodItemVenda() {
        return codItemVenda;
    }

    public void setCodItemVenda(Integer codItemVenda) {
        this.codItemVenda = codItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codItemVenda=" + codItemVenda + ", venda=" + venda + ", produto=" + produto + ", quantidade=" + quantidade + '}';
    }

    
    
}
