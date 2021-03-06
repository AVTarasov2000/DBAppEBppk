package cs.vsu.dao;

import cs.vsu.config.HibernateConfig;
import cs.vsu.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

@Repository
public class DaoImpl<T> implements Dao<T> {

    SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Override
    @Transactional
    public T findById(Integer id, Class<T> tClass) {
        Session session = sessionFactory.openSession();
        T res = sessionFactory.getCurrentSession().get(tClass, id);
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
    @SuppressWarnings("unchecked")
    public List <T> getAll(Integer id, Class<T> tClass) {
        Session session = sessionFactory.openSession();
        String table = tClass.getAnnotation(Table.class).name();
        List res = sessionFactory.getCurrentSession().createQuery("FROM "+table).list();
        session.close();
        return res;
    }
}
