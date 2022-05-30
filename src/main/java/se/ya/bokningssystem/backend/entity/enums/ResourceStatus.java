package se.ya.bokningssystem.backend.entity.enums;

public enum ResourceStatus {
    AVAILABLE("Tillgänglig"),
    NOT_AVAILABLE("Otillgänglig"),
    BORROWED("Utlånad"),
    REPAIR("Trasig");

    public final String value;

    ResourceStatus(String value) {
        this.value = value;
    }
}
