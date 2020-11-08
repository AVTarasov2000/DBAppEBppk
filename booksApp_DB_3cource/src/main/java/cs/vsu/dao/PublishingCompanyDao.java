package cs.vsu.dao;

import cs.vsu.models.PublishingCompany;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PublishingCompanyDao implements Dao<PublishingCompany>{

    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public PublishingCompany findById(Integer id, Class tClass) {
        return null;
    }

    @Override
    @Transactional
    public void save(PublishingCompany publishingCompany) {

    }

    @Override
    @Transactional
    public void delete(PublishingCompany publishingCompany) {

    }

    @Override
    @Transactional
    public void update(PublishingCompany publishingCompany) {

    }

    @Override
    @Transactional
    public List <PublishingCompany> getAll(Integer id, Class tClass) {
        return null;
    }
}
