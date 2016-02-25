
package com.br.lp3.DAO;

import java.util.List;

/**
 *
 * @author 31240550
 * @param <E> Entidade
 */
public interface GenericDAO<E> {
    public boolean create(E e);
    public List<E> readAll();
    public E readByID(long id);
    public boolean update(E e);
    public boolean delete(E e);
}
