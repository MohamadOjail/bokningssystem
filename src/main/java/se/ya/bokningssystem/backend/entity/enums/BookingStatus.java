package se.ya.bokningssystem.backend.entity.enums;

import java.io.Serializable;

public enum BookingStatus implements Serializable {
    ACTIVE,
    FINISHED,
    OVERDUE

    // ACTIVE aktiv, FINISHED slutfört, OVERDUE försanad
}
