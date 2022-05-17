package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.implementation.UserDaoImpl;
import se.ya.bokningssystem.backend.util.CrudOps;
import se.ya.bokningssystem.backend.util.DataOps1;

import java.util.List;

public class UserDAO implements CrudOps<UserEO> {
    private final UserDaoImpl daoImpl = new UserDaoImpl();
    @Override
    public UserEO add(UserEO userEO) {
        return daoImpl.add(userEO);
    }

    @Override
    public UserEO getById(Long id) {
        return daoImpl.getById(id);
    }

    @Override
    public UserEO getByNamedQuery(String queryName, String param) {
        return null; // todo
    }

    @Override
    public List<UserEO> getListByNamedQuery(String queryName, String param) {
        return daoImpl.getListByNamedQuery(queryName, param);
    }

    @Override
    public List<UserEO> findAll() {
        return null;
    }

    @Override
    public UserEO update(UserEO userEO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
