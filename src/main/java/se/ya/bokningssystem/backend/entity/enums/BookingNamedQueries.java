package se.ya.bokningssystem.backend.entity.enums;

public enum BookingNamedQueries {
    GET_OVERDUE("by_overdue"),
    GET_OVERDUE_BY_USER("by_overdue_by_user"),
    GET_OVERDUE_BY_RESOURCE("by_overdue_by_resource"),
    GET_BY_USER("by_user"),
    GET_BY_RESOURCE("by_resource"),
    GET_BY_STATUS("by_status");

    public final String queryName;

    BookingNamedQueries(String queryName) {
        this.queryName = queryName;
    }
}
