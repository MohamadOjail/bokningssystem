package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.ResourceEO;

import java.util.List;

public class ResourceDAO implements DaoOps<ResourceEO> {

    @Override
    public ResourceEO add(ResourceEO resourceEO) {
        DataOps<ResourceEO> dataOps = new DataOps<>();
        return dataOps.add(resourceEO, ResourceEO.class);
    }

    @Override
    public ResourceEO getById(long id) {
        DataOps<ResourceEO> dataOps = new DataOps<>();
        return dataOps.getById(id, ResourceEO.class);
    }

    @Override
    public ResourceEO getByInput(String input) {
        return null;
    }

    @Override
    public ResourceEO update(ResourceEO resourceEO) {
        DataOps<ResourceEO> dataOps = new DataOps<>();
        return dataOps.update(resourceEO, ResourceEO.class);
    }

    @Override
    public void delete(long id) {
        // TODO fixa relationer vid borttagningen
        DataOps<ResourceEO> dataOps = new DataOps<>();
        dataOps.delete(id, ResourceEO.class);
    }

    @Override
    public List<ResourceEO> findAll() {
        DataOps<ResourceEO> dataOps = new DataOps<>();
        return dataOps.findAll(ResourceEO.class);
    }

    @Override
    public List<ResourceEO> findByWildCard(String input) {
        DataOps<ResourceEO> dataOps = new DataOps<>();
        return dataOps.findByWildCard(input, ResourceEO.class);
    }
}
