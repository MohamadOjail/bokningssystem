package se.ya.bokningssystem.frontend.user;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.dao.ResourceDAO;

public class UserSearchFieldListener implements ChangeListener<String> {

    private final UserController uc;

    public UserSearchFieldListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        ResourceDAO resourceDAO = new ResourceDAO();
        uc.getResources().clear();
        if (!uc.getTf_search().getText().isEmpty()) {
            new Thread(() -> {
                uc.getResources().clear();
                uc.getResources().addAll(resourceDAO.findByWildCard(uc.getTf_search().getText()));
            }).start();
        }
    }
}
