package se.ya.bokningssystem.backend.entity.enums;

public enum ResourceNamedQueries {
    GET_BY_ART_NUM("get_by_art_num"),
    GET_BY_DESCRIPTION("get_by_description"),
    GET_BY_STATUS("get_by_status");

    public final String queryName;

    ResourceNamedQueries(String queryName) {
        this.queryName = queryName;
    }
}
