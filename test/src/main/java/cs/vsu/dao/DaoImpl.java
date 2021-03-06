package cs.vsu.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DaoImpl<T> implements Dao<T> {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public T findById(Integer id, Class<T> tClass) {
        Session session = sessionFactory.openSession();
        T res = session.get(tClass, id);
        session.close();
        return res;
    }

    @Override
    @Transactional
    public void save(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    @Transactional
    public void delete(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }

    @Override
    @Transactional
    public void update(T t) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    @Override
    @Transactional
    public List <T> getAll(Class<T> tClass) {
        Session session = sessionFactory.openSession();
        String table = tClass.getName();
        List<T> res = session.createQuery("FROM "+table, tClass).getResultList();
        session.close();
        return res;
    }

    @Override
    public List <T> getByField(Class <T> tClass, String column, String value) {
        Session session = sessionFactory.openSession();
        String table = tClass.getName();
        List<T> res = session.createQuery("FROM "+table+" WHERE "+column+"="+value, tClass).getResultList();
        session.close();
        return res;
    }
}
