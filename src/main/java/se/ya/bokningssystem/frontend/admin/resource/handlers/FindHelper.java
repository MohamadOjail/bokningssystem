package se.ya.bokningssystem.frontend.admin.resource.handlers;

import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class FindHelper {
    private final ResourceController rc;
    private final ResourceDAO resourceDAO;

    public FindHelper(ResourceController rc) {
        this.rc = rc;
        this.resourceDAO = new ResourceDAO();
    }
    public void populateResourceList(){
        String input = "";
        if (!rc.getTf_find_by_artnumber().getText().isEmpty()){
            input = rc.getTf_find_by_artnumber().getText();
            populate(input, true);
            return;
        }
        input = rc.getTf_find_by_description().getText();
        populate(input, false);
    }
    public void populateResourceList(String input){
        if (!rc.getTf_find_by_artnumber().getText().isEmpty()){
            populate(input, true);
            return;
        }
        populate(input, false);
    }
    private void populate(String input, boolean byArt){
        if (byArt){
            rc.getResources().clear();
            rc.getResources().addAll(resourceDAO.getListByNamedQuery(
                    ResourceNamedQueries.GET_BY_ART_NUM.queryName, "%" + input + "%"
            ));
            return;
        }
        rc.getResources().clear();
        rc.getResources().addAll(resourceDAO.getListByNamedQuery(
                ResourceNamedQueries.GET_BY_DESCRIPTION.queryName, "%" + input + "%"
        ));
    }
}
