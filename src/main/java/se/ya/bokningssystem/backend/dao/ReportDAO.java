package se.ya.bokningssystem.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.ReportEO;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.Factory;

import java.util.ArrayList;
import java.util.List;

public class ReportDAO implements CrudOps<ReportEO> {

    private final SessionFactory factory = Factory.getFactory();

    @Override
    public ReportEO add(ReportEO reportEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(reportEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return reportEO;
    }

    @Override
    public ReportEO getById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        ReportEO reportEO = session.find(ReportEO.class, id);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return reportEO;
    }

    @Override
    public ReportEO getByNamedQuery(String queryName, String param) {
        return null;
    }

    @Override
    public List<ReportEO> getListByNamedQuery(String queryName, String param) {
        return null;
    }

    @Override
    public List<ReportEO> findAll() {
        List<ReportEO> reports = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query<ReportEO> query = session.createQuery("FROM ReportEO");
        reports.addAll(query.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return reports;
    }

    @Override
    public ReportEO update(ReportEO reportEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(reportEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return reportEO;
    }

    @Override
    public void delete(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        ReportEO reportEO = session.find(ReportEO.class, id);
        session.delete(reportEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
    }
}
