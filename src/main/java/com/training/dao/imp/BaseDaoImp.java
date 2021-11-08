package com.training.dao.imp;

import com.training.dao.BaseDao;
import com.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author: VuiSK
 * @created: 08/11/2021-2:15 PM
 * @mailto: sanvankhanh@gmail.com
 */

public class BaseDaoImp<T> implements BaseDao<T> {
    private Class<T> classTyper;
    public BaseDaoImp(Class<T> classTyper) {
        this.classTyper = classTyper;
    }
    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtils.getSession()){
            return session.createQuery("FROM "+classTyper.getName(), this.classTyper).list();
        }
    }

    @Override
    public boolean insert(List<T> t) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            for (T t1 : t){
                session.merge(t1);
            }
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(int id) {
        try(Session session = HibernateUtils.getSession()) {
            Transaction transaction = session.beginTransaction();
            T t = session.load(this.classTyper, id);
            if(t!= null){
                session.delete(t);
                transaction.commit();
                return true;
            }else {
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean update(T t) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtils.getSession();
            transaction = session.beginTransaction();
            session.update(t);
            transaction.commit();
            return true;
        }catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public T findById(int id) {
        try (Session session = HibernateUtils.getSession()){
            return session.get(this.classTyper, id);
        }catch(Exception e){
            return null;
        }
    }
}
