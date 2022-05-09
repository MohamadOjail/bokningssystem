package se.ya.bokningssystem.frontend.switcher.admin;

public enum Views {
    USER("../../../admin/User.fxml"),
    BOOKING("../../../admin/Booking.fxml"),
    RESOURCE("../../../admin/Resource.fxml");

    final String path;

    Views(String path) {
        this.path = path;
    }
}
