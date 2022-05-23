package se.ya.bokningssystem.frontend.admin.resource.handlers;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.resource.ResourceController;

public class FindResourceListener implements ChangeListener<String> {
    private final ResourceController rc;
    private final FindHelper findHelper;
    public FindResourceListener(ResourceController rc) {
        this.rc = rc;
        this.findHelper = new FindHelper(rc);
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if (t1 != null && observableValue instanceof StringProperty field && !t1.isEmpty()){
            findHelper.populateResourceList(t1);
            return;
        }
        rc.getResources().clear();
    }
}
