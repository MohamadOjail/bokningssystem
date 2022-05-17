package se.ya.bokningssystem.backend.util;

import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface CrudOps1<T> {

    T add(T t, Class<T> xClass);

    T getById(long id, Class<T> xClass);

    T getByInput(String input, Class<T> xClass);

    T update(T t, Class<T> xClass);

    void delete(long id, Class<T> xClass);

    List<T> findAll(Class<T> xClass);

    List<T> findByWildCard(String input, Class<T> xClass);

    // statisk metod för att stänga session och factory ropas vid CRUD operationer
    static void endSession(SessionFactory factory, Session session){
        try {
            session.close();
            factory.close();
            System.out.println("Factory / Session Closed successfully!");
        } catch (HibernateException e) {
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
        }
    }
}
