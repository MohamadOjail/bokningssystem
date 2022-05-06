package se.ya.bokningssystem.frontend.switcher.admin;

import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.user.UserController;

public class ObjectHolder {
    private static final ObjectHolder instance = new ObjectHolder();
    public static ObjectHolder get(){return instance;}
    private ObjectHolder() {}
    private UserEO currentUser = null;

    public void setCurrentUser(UserEO user) {
        this.currentUser = user;
    }

    public void getCurrentUser(UserController uc) {
        uc.setCurrentUser(this.currentUser);
        this.currentUser = null;
    }
}
