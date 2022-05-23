package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class ListSelectionListener implements ChangeListener<ResourceEO> {
    private final ResourceController rc;
    private final ResourceFieldsHelper resourceFieldsHelper;

    public ListSelectionListener(ResourceController rc) {
        this.rc = rc;
        this.resourceFieldsHelper = new ResourceFieldsHelper(rc);
    }

    @Override
    public void changed(ObservableValue<? extends ResourceEO> observableValue, ResourceEO resourceEO, ResourceEO t1) {
        rc.getBtn_delete().setDisable(t1 == null);
        rc.getBtn_edit().setDisable(t1 == null);
        resourceFieldsHelper.setEditFieldValues(t1);
    }
}
