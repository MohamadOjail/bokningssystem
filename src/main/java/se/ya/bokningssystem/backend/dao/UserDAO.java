package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.DataOps;

import java.util.List;

public class UserDAO implements DaoOps<UserEO> {

    @Override
    public UserEO add(UserEO userEO) {
        return null; //TODO
    }

    @Override
    public UserEO getById(long id) {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.getById(id, UserEO.class);
    }

    @Override
    public UserEO getByInput(String input) {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.getByInput(input, UserEO.class);
    }

    @Override
    public UserEO update(UserEO userEO) {
        return null; //TODO
    }

    @Override
    public void delete(long id) {
        //TODO
    }

    @Override
    public List<UserEO> findAll() {
        return null; //TODO
    }

    @Override
    public List<UserEO> findByWildCard(String input) {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.findByWildCard(input, UserEO.class);
    }
}
