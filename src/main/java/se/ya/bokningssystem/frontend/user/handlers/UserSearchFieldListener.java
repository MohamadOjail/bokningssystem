package se.ya.bokningssystem.frontend.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;
import se.ya.bokningssystem.frontend.user.UserController;
import se.ya.bokningssystem.frontend.utils.Threader;

public class UserSearchFieldListener implements ChangeListener<String> {

    private final UserController uc;
    private final ResourceDAO resourceDAO = new ResourceDAO();
    public UserSearchFieldListener(UserController uc) {
        this.uc = uc;
        uc.getResources().addAll(resourceDAO.findAll());
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        uc.getResources().clear();
        if (!uc.getTf_search().getText().isEmpty()) {
            Threader.execute(
                    () -> {
                        uc.getResources().clear();
                        uc.getResources().addAll(resourceDAO.getListByNamedQuery(ResourceNamedQueries.GET_BY_DESCRIPTION.queryName, "%" + uc.getTf_search().getText() + "%"));
                    }
            );
            return;
        }
        uc.getResources().addAll(resourceDAO.findAll());
    }
}
