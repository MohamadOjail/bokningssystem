package se.ya.bokningssystem.backend.entity.enums;

public enum UserEoNamedQueries {
    BY_FIRST_OR_LAST_NAME("get_by_first_or_last_name"),
    BY_IS_ALLOWED("get_by_is_allowed");
    public final String queryName;

    UserEoNamedQueries(String queryName) {
        this.queryName = queryName;
    }
}
