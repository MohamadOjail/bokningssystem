package se.ya.bokningssystem.backend.dao;

import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.Factory;
import se.ya.bokningssystem.frontend.utils.Alerter;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResourceDAO implements CrudOps<ResourceEO> {

    private final SessionFactory factory = Factory.getFactory();

    @Override
    public ResourceEO add(ResourceEO resourceEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(resourceEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return resourceEO;
    }

    @Override
    public ResourceEO getById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        ResourceEO resourceEO = session.find(ResourceEO.class, id);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return resourceEO;
    }

    @Override
    public ResourceEO getByNamedQuery(String queryName, String param) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query<ResourceEO> query = session.getNamedQuery(queryName);
        query.setParameter("input", param);
        ResourceEO resourceEO = null;
        try {
            resourceEO = query.getSingleResult();
            Alerter.get().showMessage(Alert.AlertType.INFORMATION, resourceEO.getDescription());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        CrudOps.endSession(session);
        return resourceEO;
    }

    @Override
    public List<ResourceEO> getListByNamedQuery(String queryName, Serializable param) {
        List<ResourceEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<ResourceEO> query = session.getNamedQuery(queryName);
        query.setParameter("input", param);
        output.addAll(query.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public List<ResourceEO> findAll() {
        List<ResourceEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<ResourceEO> query = session.createQuery("FROM ResourceEO");
        output.addAll(query.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public ResourceEO update(ResourceEO resourceEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(resourceEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return resourceEO;
    }

    @Override
    public void delete(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        ResourceEO resourceEO = session.find(ResourceEO.class, id);
        session.delete(resourceEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
    }

    public Long getResourceCount(){
        Long count = 0L;
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<Long> query = session.createQuery("SELECT COUNT(*) FROM ResourceEO ");
        count = (Long)query.getSingleResult();
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return count;
    }
}
