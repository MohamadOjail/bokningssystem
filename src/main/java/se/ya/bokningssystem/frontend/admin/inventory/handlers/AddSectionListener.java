package se.ya.bokningssystem.frontend.admin.inventory.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.inventory.InventoryController;

public class AddSectionListener implements ChangeListener {

    private final InventoryController ic;

    public AddSectionListener(InventoryController ic) {
        this.ic = ic;
    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        ic.getBtn_add_resource().setDisable(!addSectionOkay());
    }

    private boolean addSectionOkay(){
        boolean artnumok=! ic.getTf_add_art_num().getText().isEmpty();
        boolean descok =! ic.getTf_add_description().getText().isEmpty();
        boolean statusok= ic.getCb_add_status().getValue() != null;
        return artnumok && descok && statusok;
    }
}
