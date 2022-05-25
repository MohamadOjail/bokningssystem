package se.ya.bokningssystem.frontend.admin.inventory.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;
import se.ya.bokningssystem.frontend.admin.inventory.InventoryController;

public class SearchChangeListener implements ChangeListener<String> {

    private final InventoryController ic;

    private final ResourceDAO rd = new ResourceDAO();

    public SearchChangeListener(InventoryController ic) {
        this.ic = ic;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if(newValue != null || !newValue.isEmpty()){
            populatefilter(newValue);
            return ;
        }
        populatenofilter();
    }
    private void populatefilter(String input){
        ic.getResourceEOS().clear();
        ic.getResourceEOS().addAll(rd.getListByNamedQuery(ResourceNamedQueries.GET_BY_ART_NUM.queryName, "%" + input + "%"));
    }

    private void populatenofilter(){
        ic.getResourceEOS().clear();
        ic.getResourceEOS().addAll(rd.findAll());

    }
}
