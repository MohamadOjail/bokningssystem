package se.ya.bokningssystem.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.Factory;

import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements CrudOps<BookingEO> {

    private final SessionFactory factory = Factory.getFactory();

    @Override
    public BookingEO add(BookingEO bookingEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.persist(bookingEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return bookingEO;
    }

    @Override
    public BookingEO getById(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        BookingEO bookingEO = session.find(BookingEO.class, id);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return bookingEO;
    }

    @Override
    public BookingEO getByNamedQuery(String queryName, String param) {
        Session session = factory.openSession();
        session.beginTransaction();
        Query<BookingEO> namedQuery = session.getNamedQuery(queryName);
        namedQuery.setParameter("input", param);
        BookingEO bookingEO = namedQuery.getSingleResult();
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return bookingEO;
    }

    @Override
    public List<BookingEO> getListByNamedQuery(String queryName, Serializable param) {
        List<BookingEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query<BookingEO> namedQuery = session.getNamedQuery(queryName);
        namedQuery.setParameter("input", param);
        output.addAll(namedQuery.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    public List<BookingEO> getListByNamedQuery(String queryName) {
        List<BookingEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query<BookingEO> namedQuery = session.getNamedQuery(queryName);
        output.addAll(namedQuery.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public List<BookingEO> findAll() {
        List<BookingEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query<BookingEO> query = session.createQuery("FROM BookingEO");
        output.addAll(query.getResultList());
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    @Override
    public BookingEO update(BookingEO bookingEO) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.update(bookingEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return bookingEO;
    }

    @Override
    public void delete(Long id) {
        Session session = factory.openSession();
        session.beginTransaction();
        BookingEO bookingEO = session.find(BookingEO.class, id);
        UserEO userEO = bookingEO.getUser();
        userEO.removeBooking(bookingEO);
        session.update(userEO);

        session.delete(bookingEO);
        session.getTransaction().commit();
        CrudOps.endSession(session);
    }

    public List<BookingEO> recheckStatus(){
        List<BookingEO> output = new ArrayList<>();
        Session session = factory.openSession();
        session.beginTransaction();
        Query<BookingEO> query = session.createQuery("FROM BookingEO");
        for (BookingEO bookingEO : query.getResultList()){
            if (isOverdue(bookingEO)){
                bookingEO.setStatus(BookingStatus.OVERDUE);
                session.update(bookingEO);
                ResourceEO resourceEO = bookingEO.getResource();
                resourceEO.setAvailableDate(null);
                session.update(resourceEO);
                output.add(bookingEO);
            }
        }
        session.getTransaction().commit();
        CrudOps.endSession(session);
        return output;
    }

    private boolean isOverdue(BookingEO booking){
       return LocalDate.now().isAfter(booking.getReturnDate());
    }
}
