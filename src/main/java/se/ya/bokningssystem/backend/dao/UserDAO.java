package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.util.DataOps;

import java.util.List;

public class UserDAO implements DaoOps<UserEO> {

    @Override
    public UserEO add(UserEO userEO) {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.add(userEO, UserEO.class);
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
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.update(userEO, UserEO.class);
    }

    @Override
    public void delete(long id) {
        DataOps<UserEO> dataOps = new DataOps<>();
        dataOps.delete(id, UserEO.class);
    }

    @Override
    public List<UserEO> findAll() {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.findAll(UserEO.class);
    }

    @Override
    public List<UserEO> findByWildCard(String input) {
        DataOps<UserEO> dataOps = new DataOps<>();
        return dataOps.findByWildCard(input, UserEO.class);
    }
}
