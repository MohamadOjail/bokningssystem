package se.ya.bokningssystem.frontend.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.frontend.user.UserController;

public class ResourceListChangeListener implements ChangeListener<ResourceEO> {

    private final UserController uc;
    public ResourceListChangeListener(UserController uc) {this.uc = uc;}

    @Override
    public void changed(ObservableValue<? extends ResourceEO> observableValue, ResourceEO resourceEO, ResourceEO t1) {
        uc.getBtn_book().setDisable(
                t1 == null
//                uc.getTv_resources().getSelectionModel().getSelectedItem().getStatus() != ResourceStatus.AVAILABLE
        );
    }
}
