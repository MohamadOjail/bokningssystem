package se.ya.bokningssystem.frontend.admin.inventory.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.inventory.InventoryController;

public class EditSectionChangeListener implements ChangeListener {

    private final InventoryController ic;

    public EditSectionChangeListener(InventoryController ic) {
        this.ic = ic;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        ic.getBtn_edit_resource().setDisable(!editSectionOkay());
    }

    private boolean editSectionOkay(){
        boolean artnumok=! ic.getTf_edit_art_num().getText().isEmpty();
        boolean descok =! ic.getTd_edit_description().getText().isEmpty();
        boolean statusok= ic.getCb_edit_status().getValue() != null;
        return artnumok && descok && statusok;
    }
}
