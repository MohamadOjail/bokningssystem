package se.ya.bokningssystem.frontend.switcher;

import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.user.UserController;

public class ObjectHolder {
    private static final ObjectHolder instance = new ObjectHolder();
    public static ObjectHolder get(){return instance;}
    private ObjectHolder() {}
    private UserEO currentUser = null;
    private ResourceEO userSelectedResource = null;

    public ResourceEO getUserSelectedResource() {
        return this.userSelectedResource;
    }

    public void setUserSelectedResource(ResourceEO userSelectedResource) {
        this.userSelectedResource = userSelectedResource;
    }

    public void setCurrentUser(UserEO user) {
        this.currentUser = user;
    }

    public void getCurrentUser(UserController uc) {
        uc.setCurrentUser(this.currentUser);
        this.currentUser = null;
    }

}
