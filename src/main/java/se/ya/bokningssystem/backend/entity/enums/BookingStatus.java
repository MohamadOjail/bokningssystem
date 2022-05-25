package se.ya.bokningssystem.backend.entity.enums;

import java.io.Serializable;

public enum BookingStatus implements Serializable {
    ACTIVE("aktiv"),
    FINISHED("avslutad"),
    OVERDUE("försenad");

    public final String value;

    BookingStatus(String value) {
        this.value = value;
    }
}
