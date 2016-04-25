/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio.loja.dao;

import br.com.etec.exercicio.loja.factory.Conexao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author fernando-pucci
 */
public abstract class BaseDAOImpl <T, I extends Serializable> implements BaseDAO<T, I>{
 
 private Conexao conexao;
  
 @Override
 public T save(T entity) {
   
  T saved = null;
   
  getEntityManager().getTransaction().begin();
  saved = getEntityManager().merge(entity);
  getEntityManager().getTransaction().commit();
   
  return saved;
 }
 
 @Override
 public void remove(T entity) {
  getEntityManager().getTransaction().begin();
  getEntityManager().remove(entity);
  getEntityManager().getTransaction().commit();
   
 }
 
 @Override
 public T getById(Class<T> classe, I pk) {
   
  try {
   return getEntityManager().find(classe, pk);
  } catch (NoResultException e) {
   return null;
  }
   
 }
 
 @SuppressWarnings("unchecked")
 @Override
 public List<T> getAll(Class<T> classe) {
   
  return getEntityManager().createQuery("select o from " + classe.getSimpleName() + " o").getResultList();
 }
 
 @Override
 public EntityManager getEntityManager() {
   
  if (conexao == null) {
   conexao = new Conexao();
  }
  return conexao.getEntityManager();
 }
 
}
