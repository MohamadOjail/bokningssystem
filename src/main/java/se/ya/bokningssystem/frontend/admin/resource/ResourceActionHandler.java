package se.ya.bokningssystem.frontend.admin.resource;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import se.ya.bokningssystem.backend.dao.ResourceDAO;

public class ResourceActionHandler implements EventHandler<ActionEvent> {

    private final ResourceController rc;

    public ResourceActionHandler(ResourceController rc) {
        this.rc = rc;
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == rc.getBtn_get_resource()){
            // använder Dao för att hämta data
            ResourceDAO resourceDAO = new ResourceDAO();
            // rensa rent ObservableListan
            rc.getResources().clear();
            // ligga till data ifrån DAo
            rc.getResources().addAll(resourceDAO.findAll());
        }
    }
}
