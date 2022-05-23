package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class AddSectionChangeListener implements ChangeListener {
    private final ResourceController rc;

    public AddSectionChangeListener(ResourceController rc) {
        this.rc = rc;
    }

    @Override
    public void changed(ObservableValue observableValue, Object o, Object t1) {
        boolean artnumberOk = !rc.getTf_add_artnumber().getText().isEmpty();
        boolean descriptionOk = !rc.getTf_add_description().getText().isEmpty();
        boolean statusOk = rc.getChoice_add_status().getSelectionModel().getSelectedItem() != null;

        boolean allFieldsOk = artnumberOk && descriptionOk && statusOk;
        rc.getBtn_add().setDisable(!allFieldsOk);
    }
}
