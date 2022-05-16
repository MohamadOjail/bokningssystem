package se.ya.bokningssystem.backend.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.UserEO;

import java.util.ArrayList;
import java.util.List;

public class DataOps<T> implements CrudOps<T>{

    private final SessionFactory factory = Factory.getFactory();
    private final Session session = factory.openSession();

    @Override
    public T add(T t, Class<T> xClass) {
        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
        return t;
    }

    @Override
    public T getById(long id, Class<T> xClass) {
        T t = null;
        try {
            session.beginTransaction();
            t = session.get(xClass, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
        return t;
    }



    @Override
    public T getByInput(String input, Class<T> xClass) {
        T t = null;
        String queryString = findByInputQuery(input, xClass);
        try {
            session.beginTransaction();
            t = session.createQuery(queryString, xClass).getSingleResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
        return t;
    }

    private String findByInputQuery(String input,Class<T> xClass) {
        String output = "";
        switch (xClass.getSimpleName().toLowerCase()){
            case "usereo" -> output = "FROM UserEO WHERE firstName = '" + input + "' OR lastName = '" + input + "'";
            case "resourceeo" -> output = "FROM ResourceEO WHERE description LIKE '%" + input + "%'";
            case "bookingeo" -> output = "FROM BookingEO "; //TODO

        }
        return output;
    }

    @Override
    public T update(T t, Class<T> xClass) {
        try {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
        return t;
    }

    @Override
    public void delete(long id, Class<T> xClass) {
        try {
            session.beginTransaction();
            T t = session.find(xClass, id);

            switch (xClass.getSimpleName().toLowerCase()){
                case "usereo" -> {
                    UserEO userEO = session.get(UserEO.class, id);
                    userEO.clearBookings();
                }
                case "bookingeo" -> {
                    BookingEO bookingEO = session.get(BookingEO.class, id);
                    UserEO userEO = bookingEO.getUser();
                    userEO.clearBookings();
                }
            }

//            UserEO userEO = session.get(UserEO.class, 1L);
//            userEO.removeBooking(session.get(BookingEO.class, 2L));

            session.delete(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
    }

    @Override
    public List<T> findAll(Class<T> xClass) {
        List<T> output = new ArrayList<>();
        String queryString = findAllQuery(xClass);
        return getTs(xClass, output, queryString);
    }

    @Override
    public List<T> findByWildCard(String input, Class<T> xClass) {
        List<T> output = new ArrayList<>();
        String queryString = findByWildCardQuery(input, xClass);
        return getTs(xClass, output, queryString);
    }

    private List<T> getTs(Class<T> xClass, List<T> output, String queryString) {
        try {
            session.beginTransaction();
            output.addAll(session.createQuery(queryString, xClass).getResultList());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
//            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
            System.out.println("Error! " + e.getLocalizedMessage());
        }
        CrudOps.endSession(factory, session);
        return output;
    }

    private String findAllQuery(Class<T> xClass) {
        String output = "";
        switch (xClass.getSimpleName().toLowerCase()){
            case "usereo" -> output = "FROM UserEO";
            case "resourceeo" -> output = "FROM ResourceEO";
            case "bookingeo" -> output = "FROM BookingEO";
            case "report" -> output = "FROM Report";
        }
        return output;
    }

    private String findByWildCardQuery(String input,Class<T> xClass) {
        String output = "";
        switch (xClass.getSimpleName().toLowerCase()){
            case "usereo" -> output = "FROM UserEO"; //TODO
            case "resourceeo" -> output = "FROM ResourceEO WHERE description LIKE '%" + input + "%'";
            case "bookingeo" -> output = "FROM BookingEO"; //TODO
        }
        return output;
    }
}
