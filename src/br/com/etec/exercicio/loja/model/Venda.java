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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fernando-pucci
 */
@Entity
@Table(name = "VENDA")
public class Venda implements java.io.Serializable {

    /*
    
     COD_VENDA
     COD_CLIENTE
     VALOR_TOTAL
     DATA_NOTA
     */
//    public Venda() {
//
//        //ao se instanciar o construtor de venda, 
//        //j? criamos uma nova lista de itens de venda
//        this.itensVenda = new ArrayList<ItemVenda>();
//
//    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "COD_VENDA")
    private Integer codVenda;

    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "DATA_NOTA")
    @Temporal(TemporalType.DATE)//valor padr?o para date timeS
    private Date dataNota;



    public void setDataNota(Date dataNota) {
        System.out.println("Passando a data pelo java.util.Date");
        this.dataNota = dataNota;
    }

    public void setDataNota(java.sql.Date dataNota) {
        System.out.println("Passando a data pelo metodo sobrecarregado java.sql.Date");
        this.dataNota = dataNota;
    }


    @Override
    public String toString() {
        return "Venda{" + "codVenda=" + codVenda + ", cliente=" + cliente + ", valorTotal=" + valorTotal + ", dataNota=" + dataNota + '}';
    }

}
