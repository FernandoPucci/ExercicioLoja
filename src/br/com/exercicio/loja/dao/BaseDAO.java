/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exercicio.loja.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author fernando-pucci
 */
public interface BaseDAO<T, I extends Serializable> {

    public T save(T entity);

    public void remove(T entity);

    public T getById(Class<T> classe, I pk);

    public List<T> getAll(Class<T> classe);

    public EntityManager getEntityManager();
}
