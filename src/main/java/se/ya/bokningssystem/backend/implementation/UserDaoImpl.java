package se.ya.bokningssystem.backend.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.Factory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements CrudOps<UserEO> {
    private final SessionFactory factory = Factory.getFactory();

    @Override
    public UserEO add(UserEO userEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(userEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return userEO;
    }

    @Override
    public UserEO getById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        UserEO userEO = session.find(UserEO.class, id);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return userEO;
    }

    @Override
    public UserEO getByNamedQuery(String queryName, String param) {
        return null; //todo
    }

    @Override
    public List<UserEO> getListByNamedQuery(String queryName, String param) {
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
}
