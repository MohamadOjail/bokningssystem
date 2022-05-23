package se.ya.bokningssystem.frontend.admin.resource.handlers;

import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class ResourceFieldsHelper {
    private final ResourceController rc;

    public ResourceFieldsHelper(ResourceController rc) {
        this.rc = rc;
    }

    public void setEditFieldValues(ResourceEO resource){
        if (resource != null){
            rc.getTf_edit_artnumber().setText(resource.getArtNum());
            rc.getTf_edit_description().setText(resource.getDescription());
            rc.getChoice_edit_status().getSelectionModel().select(resource.getStatus());
            return;
        }
        rc.getTf_edit_artnumber().clear();
        rc.getTf_edit_description().clear();
        rc.getChoice_edit_status().getSelectionModel().select(null);
    }

    public void clearAddSection(){
        rc.getTf_add_artnumber().clear();
        rc.getTf_add_description().clear();
        rc.getChoice_add_status().getSelectionModel().select(null);
    }
}
