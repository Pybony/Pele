/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.chamados.control;

import br.com.chamados.config.HibernateUtil;
import br.com.chamados.config.LogChamados;
import br.com.chamados.genericos.Cookies;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
    private static Session session;

    public DAO() {
        openSession();
    }

    public boolean save(Object object) {
        openSession();
        Transaction transacion = null;
        try {
            session.createSQLQuery("SET @username = " + Cookies.usuario.getId()).executeUpdate();
            transacion = session.beginTransaction();
            session.flush();
            session.clear();
            session.saveOrUpdate(object);
            transacion.commit();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso.");
            return true;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o registro.");
            transacion.rollback();
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }

    public void delete(Object object) {
        openSession();
        Transaction transacion = null;
        try {
            if (object != null) {
                session.createSQLQuery("SET @username = " + Cookies.usuario.getId()).executeUpdate();
                transacion = session.beginTransaction();
                session.delete(object);
                transacion.commit();
                JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Registro não encontrado.");
            }
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exluir este registro. Ele pode possuir ligações com outros cadastros.");
            transacion.rollback();
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            session.close();
        }
    }

    public T queryById(String campo, Serializable valor, Class clazz) {
        openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq(campo, valor));
        return (T) criteria.uniqueResult();
    }

    public List<T> queryList(Class clazz) {
        openSession();
        Criteria criteria = session.createCriteria(clazz);
        return (List<T>) criteria.list();
    }

    public List<T> query(String sql) {
        openSession();
        Query query = session.createQuery(sql);
        return (List<T>) query.list();
    }

    public Object querySQL(String sql) {
        openSession();
        SQLQuery query = session.createSQLQuery(sql);
        return query.uniqueResult();
    }
    
    public void nrQuerySQL(String sql){
        openSession();
        session.createSQLQuery(sql);
    }

    public Object count(String sql) {
        openSession();
        Query query = session.createQuery(sql);
        return query.uniqueResult();
    }

    private void openSession() {
        if (session == null) {
            session = HibernateUtil.getSessionFactory().openSession();
        } else {
            if (!session.isOpen()) {
                session = HibernateUtil.getSessionFactory().openSession();
            }
        }
    }
}
