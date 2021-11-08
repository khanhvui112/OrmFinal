package com.training.dao;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:13 PM
 * @mailto: sanvankhanh@gmail.com
 */

public interface BaseDao<T> {
    List<T> findAll();
    boolean insert(List<T> t);
    boolean delete(int id);
    boolean update(T t);
    T findById(int id);
}
