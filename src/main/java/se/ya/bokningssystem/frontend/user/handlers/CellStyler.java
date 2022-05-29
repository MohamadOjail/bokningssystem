package se.ya.bokningssystem.frontend.user.handlers;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

public class CellStyler {

    public static TableCell<BookingEO, String> call(TableColumn<BookingEO, String> param) {
        return new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                if (!empty) {
                    int currentIndex = indexProperty()
                            .getValue() < 0 ? 0
                            : indexProperty().getValue();

                    BookingStatus status = param
                            .getTableView().getItems()
                            .get(currentIndex).getStatus();
                    if (status.equals(BookingStatus.OVERDUE)) {
                        setId("overdue");
                    } else {
                        setId("");
                    }
                    setText(status.value);
                }
            }
        };
    }
}
