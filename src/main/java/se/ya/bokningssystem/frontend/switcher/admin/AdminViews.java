package se.ya.bokningssystem.frontend.switcher.admin;

public enum AdminViews {
    USER("../../../admin/User.fxml"),
    BOOKING("../../../admin/Booking.fxml"),
    RESOURCE("../../../admin/Resource.fxml"),
    REPORT("../../../admin/Report.fxml"),
    INVENTORY("../../../admin/Inventory.fxml");

    final String path;

    AdminViews(String path) {
        this.path = path;
    }
}
