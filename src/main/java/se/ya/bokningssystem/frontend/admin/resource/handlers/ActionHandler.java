package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;
import se.ya.bokningssystem.frontend.utils.Alerter;

public class ActionHandler implements EventHandler<ActionEvent> {
    private final ResourceController rc;
    private final ResourceDAO resourceDAO;
    private final ResourceFieldsHelper resourceFieldsHelper;
    private final FindHelper findHelper;

    public ActionHandler(ResourceController rc) {
        this.rc = rc;
        this.resourceDAO = new ResourceDAO();
        this.resourceFieldsHelper = new ResourceFieldsHelper(rc);
        this.findHelper = new FindHelper(rc);
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == rc.getBtn_edit()){
            rc.getBtn_edit().setDisable(true);
            rc.getBtn_update().setDisable(false);
        }
        if (e.getSource() == rc.getBtn_update()){
            rc.getBtn_update().setDisable(true);
            ResourceEO selectedItem = rc.getTv().getSelectionModel().getSelectedItem();
            selectedItem.setArtNum(rc.getTf_edit_artnumber().getText());
            selectedItem.setDescription(rc.getTf_edit_description().getText());
            selectedItem.setStatus(rc.getChoice_edit_status().getSelectionModel().getSelectedItem());
            resourceDAO.update(selectedItem);
            rc.getTv().getSelectionModel().select(null);
            rc.getTv().refresh();
            Alerter.get().showMessage(Alert.AlertType.INFORMATION, "Resurs uppdaterats");
        }
        if (e.getSource() == rc.getBtn_delete()){
            ResourceEO selectedItem = rc.getTv().getSelectionModel().getSelectedItem();
            resourceDAO.delete(selectedItem.getId());
            Alerter.get().showMessage(Alert.AlertType.WARNING, "Resurs raderats");
            findHelper.populateResourceList();
        }
        if (e.getSource() == rc.getBtn_add()){
            ResourceEO newResource = new ResourceEO();
            newResource.setArtNum(rc.getTf_add_artnumber().getText());
            newResource.setDescription(rc.getTf_add_description().getText());
            newResource.setStatus(rc.getChoice_add_status().getValue());
            resourceDAO.add(newResource);
            Alerter.get().showMessage(Alert.AlertType.WARNING, "Resurs raderats");
            resourceFieldsHelper.clearAddSection();
        }
        if (e.getSource() == rc.getBtn_find_all()){
            rc.getTf_find_by_description().clear();
            rc.getTf_find_by_artnumber().clear();
            rc.getResources().clear();
            rc.getResources().addAll(resourceDAO.findAll());
        }
    }
}
