package se.ya.bokningssystem.frontend.user.setup;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.frontend.user.UserController;
import se.ya.bokningssystem.frontend.user.setup.handlers.ActionHandler;
import se.ya.bokningssystem.frontend.user.setup.handlers.DateChangeListener;

import java.time.LocalDate;

@Getter
public class SetupController {
    @FXML private Button btn_cancel, btn_ok;
    @FXML private DatePicker dp_booking_date, dp_return_date;
    @Setter
    private UserController uc;

    @FXML private void initialize(){
        dp_booking_date.setValue(null);
        dp_return_date.setValue(null);
        dp_booking_date.setDayCellFactory(datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (item.isBefore(LocalDate.now())) {
                    setDisable(true);
                    setId("not-allowed");
                }else setId("allowed");
            }
        });
        dp_return_date.setDayCellFactory(datePicker -> new DateCell() {
            @Override
            public void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);
                if (item.isBefore(dp_booking_date.getValue()) || item.isAfter(dp_booking_date.getValue().plusDays(360))) {
                    setDisable(true);
                    setId("not-allowed");
                }else setId("allowed");
            }
        });
        DateChangeListener dateChangeListener = new DateChangeListener(this);
        dp_booking_date.valueProperty().addListener(dateChangeListener);
        dp_return_date.valueProperty().addListener(dateChangeListener);

        // button Action event
        ActionHandler actionHandler = new ActionHandler(this);
        btn_cancel.setOnAction(actionHandler);
        btn_ok.setOnAction(actionHandler);
    }
}
