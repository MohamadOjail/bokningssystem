package se.ya.bokningssystem.backend.entity.enums;

public enum UserNamedQueries {
    BY_FIRST_OR_LAST_NAME("get_by_first_or_last_name"),
    BY_STATE("get_by_state"),
    BY_EMAIL("get_by_email");
    public final String queryName;

    UserNamedQueries(String queryName) {
        this.queryName = queryName;
    }
}
