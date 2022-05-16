package se.ya.bokningssystem.backend.dao;

import java.util.List;

public interface DaoOps<T> {
    T add(T t);

    T getById(long id);
    T getByInput(String input);

    T update(T t);

    void delete(long id);

    List<T> findAll();

    List<T> findByWildCard(String input);
}
