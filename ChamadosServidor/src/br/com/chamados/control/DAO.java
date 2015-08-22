/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.control;

import br.com.chamados.config.HibernateUtil;
import br.com.chamados.config.LogChamados;
import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lksbr
 * @param <T>
 */
public class DAO<T> {

    private final Logger logger = Logger.getLogger(LogChamados.class);

    public DAO() {
    }

    public void insert(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacion = null;
        try {
            transacion = session.beginTransaction();
            session.save(object);
            transacion.commit();
        } catch (HibernateException e) {
            transacion.rollback();
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void update(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacion = null;
        try {
            transacion = session.beginTransaction();
            session.update(object);
            transacion.commit();
        } catch (HibernateException e) {
            transacion.rollback();
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    public void delete(Object object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transacion = null;
        try {
            transacion = session.beginTransaction();
            session.delete(object);
            transacion.commit();
        } catch (HibernateException e) {
            transacion.rollback();
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    public T queryById(String campo, Serializable valor, Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq(campo, valor));
        return (T) criteria.uniqueResult();
    }

    public List<T> queryList(Class clazz) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        return (List<T>) criteria.list();
    }

    public List<T> query(String sql) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(sql);
        return (List<T>) query.list();
    }
}
