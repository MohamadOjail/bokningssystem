package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;

public class FindByIdListener implements ChangeListener<String> {

    private final ObservableList<UserEO> users;

    public FindByIdListener(ObservableList<UserEO> users) {
        this.users = users;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if (t1 != null){
            Long id = parseId(t1);
            if (id != -1) {
                UserDAO userDAO = new UserDAO();
                this.users.clear();
                UserEO byId = userDAO.getById(id);
                if (byId != null) {
                    this.users.addAll(byId);
                }
                return;
            }
            this.users.clear();
            return;
        }
        this.users.clear();
    }

    private Long parseId(String input){
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }
}
