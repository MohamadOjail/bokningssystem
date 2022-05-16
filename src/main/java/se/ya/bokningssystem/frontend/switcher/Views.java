package se.ya.bokningssystem.frontend.switcher;

public enum Views {
    LOGIN("../../Login.fxml"),
    USER("../../User.fxml"),
    ADMIN("../../Admin.fxml");

    final String path;

    Views(String path) {
        this.path = path;
    }
}
