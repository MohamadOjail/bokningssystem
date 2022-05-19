package se.ya.bokningssystem.frontend.user;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.utils.Threader;

public class UserSearchFieldListener implements ChangeListener<String> {

    private final UserController uc;

    public UserSearchFieldListener(UserController uc) {
        this.uc = uc;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//        ResourceDAO resourceDAO = new ResourceDAO();
//        uc.getResources().clear();
//        if (!uc.getTf_search().getText().isEmpty()) {
//
//            Threader.execute(
//                    () -> {
//                        uc.getResources().clear();
//                        uc.getResources().addAll(resourceDAO.findByWildCard(uc.getTf_search().getText()));
//                    }
//            );
//        }
    }
}
