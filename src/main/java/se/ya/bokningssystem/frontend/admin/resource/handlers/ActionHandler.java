package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class ActionHandler implements EventHandler<ActionEvent> {
    private final ResourceController rc;
    private final ResourceDAO resourceDAO;
    private final FindHelper findHelper;

    public ActionHandler(ResourceController rc) {
        this.rc = rc;
        this.resourceDAO = new ResourceDAO();
        this.findHelper = new FindHelper(rc);
    }

    @Override
    public void handle(ActionEvent e) {

        if (e.getSource() == rc.getBtn_find_all()){
            rc.getTf_find_by_description().clear();
            rc.getTf_find_by_artnumber().clear();
            rc.getResources().clear();
            rc.getResources().addAll(resourceDAO.findAll());
            rc.getChoice_filter().getSelectionModel().select(null);
        }
    }
}
