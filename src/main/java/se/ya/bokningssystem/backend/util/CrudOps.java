package se.ya.bokningssystem.backend.util;

import javafx.scene.control.Alert;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public interface CrudOps<T> {
    T add(T t);
    T getById(Long id);
    T getByNamedQuery(String queryName, String param);
    List<T> getListByNamedQuery(String queryName, String param);
    List<T> findAll();
    T update(T t);
    void delete(Long id);

    static void endSession( Session session ){
        try {
            session.close();
            System.out.println("Session Closed successfully!"); // TODO ta bort vid produktion
        } catch (HibernateException e) {
            new Alert(Alert.AlertType.ERROR, e.getLocalizedMessage()).show();
        }
    }
}
