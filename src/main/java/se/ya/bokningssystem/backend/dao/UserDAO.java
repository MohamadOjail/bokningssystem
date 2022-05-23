package se.ya.bokningssystem.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.Factory;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudOps<UserEO> {
    private final SessionFactory factory = Factory.getFactory();

    @Override
    public UserEO add(UserEO userEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        if (!userExists(userEO)) {
            session.persist(userEO);
            session.getTransaction().commit();
        }
        CrudOps.endSession(session);
        return userEO;
    }

    private boolean userExists(UserEO userEO){
        boolean output = false;
        Session session = factory.openSession();
        session.beginTransaction();
        Query<UserEO> query = session.createQuery("FROM UserEO u WHERE u.firstName = :inputFirstName AND u.lastName = :inputLastName", UserEO.class);
        query.setParameter("inputFirstName", userEO.getFirstName());
        query.setParameter("inputLastName", userEO.getLastName());
        List<UserEO> resultList = query.getResultList();
        if (!resultList.isEmpty()) output = true;
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public UserEO getById(Long id) {
        UserEO userEO = null;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            userEO = session.find(UserEO.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        CrudOps.endSession(session);
        return userEO;
    }

    @Override
    public UserEO getByNamedQuery(String queryName, String param) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query<UserEO> query = session.getNamedQuery(queryName);
        query.setParameter("input", param);
        UserEO userEO = null;
        try {
            userEO = query.getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        CrudOps.endSession(session);
        return userEO;
    }

    @Override
    public List<UserEO> getListByNamedQuery(String queryName, Serializable param) {
        List<UserEO> users = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.getNamedQuery(queryName)
                        .setParameter("input", param);
        users.addAll(query.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return users;
    }

    @Override
    public List<UserEO> findAll() {
        List<UserEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        output.addAll(session.createQuery("FROM UserEO").getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public UserEO update(UserEO userEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(userEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return userEO;
    }

    @Override
    public void delete(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        UserEO userEO = session.find(UserEO.class, id);
        session.delete(userEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
    }

    public Long getUserCount(){
        Long count = 0L;
        Session session = factory.openSession();
        session.beginTransaction();
        TypedQuery<Long> query = session.createQuery("SELECT COUNT(*) FROM UserEO");
        count = query.getSingleResult();
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return count;
    }
}
