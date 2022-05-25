package se.ya.bokningssystem.frontend.admin.inventory.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.admin.inventory.InventoryController;



public class ListChangeListener implements ChangeListener<ResourceEO> {

    private final InventoryController ic;

    public ListChangeListener(InventoryController ic) {
        this.ic = ic;
    }


    @Override
    public void changed(ObservableValue<? extends ResourceEO> observable, ResourceEO oldValue, ResourceEO newValue) {
        ic.getBtn_delete().setDisable(newValue == null);
        if(newValue != null) populateEditSection(newValue);
        if(newValue == null) clearEditSection();

    }

    private void populateEditSection(ResourceEO newValue){
        ic.getTf_edit_art_num().setText(newValue.getArtNum());
        ic.getTd_edit_description().setText(newValue.getDescription());
        ic.getCb_edit_status().getSelectionModel().select(newValue.getStatus());
    }

    private void clearEditSection(){
        ic.getTf_edit_art_num().clear();
        ic.getTd_edit_description().clear();
        ic.getCb_edit_status().getSelectionModel().select(null);
    }
}
