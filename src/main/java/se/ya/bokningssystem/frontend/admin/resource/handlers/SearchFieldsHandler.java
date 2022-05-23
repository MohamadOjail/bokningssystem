package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class SearchFieldsHandler implements ChangeListener<Boolean> {
    private final ResourceController rc;

    public SearchFieldsHandler(ResourceController rc) {
        this.rc = rc;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
        if (t1 != null && observableValue instanceof ReadOnlyBooleanProperty field){
            if (t1) {
                if (field.getBean() == rc.getTf_find_by_artnumber()) rc.getTf_find_by_description().clear();
                if (field.getBean() == rc.getTf_find_by_description()) rc.getTf_find_by_artnumber().clear();
            }
        }
    }
}
