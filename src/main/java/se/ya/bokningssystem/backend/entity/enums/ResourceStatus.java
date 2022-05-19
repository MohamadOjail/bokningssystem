package se.ya.bokningssystem.backend.entity.enums;

public enum ResourceStatus {
    AVAILABLE("tillgänglig"),
    NOT_AVAILABLE("-XX-"),
    BORROWED("utlånad"),
    REPAIR("trasig");

    public final String value;

    ResourceStatus(String value) {
        this.value = value;
    }
}
