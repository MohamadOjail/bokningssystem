package se.ya.bokningssystem.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.CrudOps1;
import se.ya.bokningssystem.backend.util.DataOps1;
import se.ya.bokningssystem.backend.util.Factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookingDAO {

    public BookingEO add(BookingEO bookingEO) {
        DataOps1<BookingEO> dataOps = new DataOps1<>();
        return dataOps.add(bookingEO, BookingEO.class);
    }

    public BookingEO getById(long id) {
        return null; //TODO
    }

    public BookingEO update(BookingEO bookingEO) {
        DataOps1<BookingEO> dataOps = new DataOps1<>();
        return dataOps.update(bookingEO, BookingEO.class);
    }

    public void delete(long id) {
        DataOps1<BookingEO> dataOps = new DataOps1<>();
        dataOps.delete(id, BookingEO.class);
    }

    public List<BookingEO> findAll() {
        return null; //TODO
    }

    // TODO this needs to be reviewed
    public List<BookingEO> getByNamedQuery(Serializable obj) {
        final SessionFactory factory = Factory.getFactory();
        final Session session = factory.openSession();
        List<BookingEO> output = new ArrayList<>();
        Query query;
        try {
            session.beginTransaction();
            switch (BookingEO.class.getSimpleName().toLowerCase(Locale.ROOT)){
                case "byuser" -> {
                    UserEO userEO = session.get(UserEO.class, obj);
                    query = session.getNamedQuery("byUser").setParameter("user", userEO);
                    output.addAll(query.getResultList());
                }
                case "resource" -> {
                    ResourceEO resourceEO = session.get(ResourceEO.class, obj);
                    query = session.getNamedQuery("byResource").setParameter("resource", resourceEO);
                    output.addAll(query.getResultList());
                }
                case "status" -> {
                    query = session.getNamedQuery("byStatus").setParameter("status", obj);
                    output.addAll(query.getResultList());
                }
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps1.endSession(factory, session);
        return output;
    }
}
