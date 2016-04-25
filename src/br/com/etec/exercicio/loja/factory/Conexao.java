/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.exercicio.loja.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fernando-pucci
 */
public class Conexao {
 
 //nome da unidade de persistencia definia no persistence.xml
 private static final String UNIT_NAME = "PersistenciaPU";
  
 private EntityManagerFactory emf = null;
  
 private EntityManager em = null;
  
 public EntityManager getEntityManager() {
   
  if (emf == null) {
   emf = Persistence.createEntityManagerFactory(UNIT_NAME);
  }
   
  if (em == null) {
   em = emf.createEntityManager();
  }
   
  return em;
 }
}
