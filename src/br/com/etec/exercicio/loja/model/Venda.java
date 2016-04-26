/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

/**
 *
 * @author fernando-pucci
 */
@Entity
@Table(name = "VENDA")
@DynamicUpdate(true)
@SelectBeforeUpdate(true)
public class Venda implements java.io.Serializable {

    /*
    
     COD_VENDA
     COD_CLIENTE
     VALOR_TOTAL
     DATA_NOTA
     */
    
    //TODO: INSERIR COLUNA/FLAG 'VENDA_FINALIZADA' ???
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COD_VENDA")
    private Integer codVenda;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CLIENTE")
    private Cliente cliente;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "DATA_NOTA")
    @Temporal(TemporalType.TIMESTAMP)//valor padrão para date timestamp
    private Date dataNota;

    public void setDataNota(Date dataNota) {

        this.dataNota = dataNota;
    }

    public void setDataNota(java.sql.Date dataNota) {

        this.dataNota = dataNota;
    }

    public Date getDataNota() {

        return this.dataNota;
    }

    public java.sql.Date getDataNotaSql() {

        return (java.sql.Date) this.dataNota;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", cliente= [" + cliente.toString() + "], valorTotal=" + valorTotal + ", dataNota=" + dataNota + '}';
    }

}
