package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.util.DataOps1;

import java.util.List;

public class ResourceDAO implements DaoOps<ResourceEO> {

    @Override
    public ResourceEO add(ResourceEO resourceEO) {
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        return dataOps.add(resourceEO, ResourceEO.class);
    }

    @Override
    public ResourceEO getById(long id) {
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        return dataOps.getById(id, ResourceEO.class);
    }

    @Override
    public ResourceEO getByInput(String input) {
        return null;
    }

    @Override
    public ResourceEO update(ResourceEO resourceEO) {
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        return dataOps.update(resourceEO, ResourceEO.class);
    }

    @Override
    public void delete(long id) {
        // TODO fixa relationer vid borttagningen
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        dataOps.delete(id, ResourceEO.class);
    }

    @Override
    public List<ResourceEO> findAll() {
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        return dataOps.findAll(ResourceEO.class);
    }

    @Override
    public List<ResourceEO> findByWildCard(String input) {
        DataOps1<ResourceEO> dataOps = new DataOps1<>();
        return dataOps.findByWildCard(input, ResourceEO.class);
    }
}
