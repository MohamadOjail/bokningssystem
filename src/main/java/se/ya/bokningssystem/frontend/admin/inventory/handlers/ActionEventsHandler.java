package se.ya.bokningssystem.frontend.admin.inventory.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.admin.inventory.InventoryController;
import se.ya.bokningssystem.frontend.utils.Alerter;

public class ActionEventsHandler implements EventHandler<ActionEvent> {
    private final InventoryController ic;
    private final ResourceDAO rd = new ResourceDAO();

    public ActionEventsHandler(InventoryController ic) {
        this.ic = ic;
    }

    @Override
    public void handle(ActionEvent e) {
        if(e.getSource()== ic.getBtn_get_resource()){
            refreshResourceList();
            return;
        }
        if(e.getSource() == ic.getBtn_delete()){
            deleteResource();
            refreshResourceList();
            return;
        }
        if(e.getSource()== ic.getBtn_add_resource()){
            addNewResource();
            refreshResourceList();
            return;
        }
        if(e.getSource() == ic.getBtn_edit_resource()){
            editResource();
            refreshResourceList();
        }

    }

    private void editResource() {
        ResourceEO ed = ic.getTv().getSelectionModel().getSelectedItem();
        ed.setArtNum(ic.getTf_edit_art_num().getText());
        ed.setDescription(ic.getTd_edit_description().getText());
        ed.setStatus(ic.getCb_edit_status().getValue());
        rd.update(ed);

    }

    private void addNewResource() {
        ResourceEO eo = new ResourceEO();
        eo.setArtNum(ic.getTf_add_art_num().getText());
        eo.setDescription(ic.getTf_add_description().getText());
        eo.setStatus(ic.getCb_add_status().getValue());
        rd.add(eo);

    }

    private void deleteResource(){
        rd.delete(
                ic.getTv().getSelectionModel().getSelectedItem().getId()
        );
    }
    private void refreshResourceList(){
        ic.getResourceEOS().clear();
        ic.getResourceEOS().addAll(rd.findAll());
    }
}
