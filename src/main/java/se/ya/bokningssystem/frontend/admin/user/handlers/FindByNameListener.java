package se.ya.bokningssystem.frontend.admin.user.handlers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.UserNamedQueries;

public class FindByNameListener implements ChangeListener<String> {

    private final ObservableList<UserEO> users;

    public FindByNameListener(ObservableList<UserEO> users) {
        this.users = users;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        if (t1 != null){
            if (t1.isEmpty()) {
                this.users.clear();
                return;
            }
            UserDAO userDAO = new UserDAO();
            this.users.clear();
            this.users.addAll(userDAO.getListByNamedQuery(UserNamedQueries.BY_FIRST_OR_LAST_NAME.queryName, "%" + t1 + "%"));
        }
    }
}
