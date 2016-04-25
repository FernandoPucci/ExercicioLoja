/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.view;

import br.com.etec.exercicio.loja.model.Venda;

/**
 *
 * @author fernando-pucci
 */
public class Principal {
    
    public static void main (String [] args){
    
    //Classe Principal - View Console
        
        Venda v = new Venda(); 
        java.util.Date dataJavaUtil = null;
        java.sql.Date dataJavaSql = null;
        
        dataJavaUtil = new java.util.Date(System.currentTimeMillis());
        dataJavaSql = new java.sql.Date(System.currentTimeMillis());
        
        
        //v.setDataNota(dataJavaUtil);       
       v.setDataNota(dataJavaSql);
        
        
     //   System.out.println("Data Nota: " + v.getDataNota());
        
        
        
        
    
    
    }
    
}
