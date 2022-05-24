package se.ya.bokningssystem.frontend.admin.booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.frontend.admin.booking.handlers.ActionHandler;
import se.ya.bokningssystem.frontend.admin.booking.handlers.ListChangeListener;
import se.ya.bokningssystem.frontend.admin.booking.handlers.SearchFieldsListener;

@Getter
public class BookingController {
    @FXML private Button btn_delete, btn_finish, btn_overdue;
    @FXML private TableColumn<BookingEO, ?> col_actual_return_date;
    @FXML private TableColumn<BookingEO, ?> col_booking_date;
    @FXML private TableColumn<BookingEO, ?> col_reminder_date;
    @FXML private TableColumn<BookingEO, ?> col_resource;
    @FXML private TableColumn<BookingEO, ?> col_returl_date;
    @FXML private TableColumn<BookingEO, ?> col_status;
    @FXML private TableColumn<BookingEO, ?> col_user;
    @FXML private TextField tf_by_resource;
    @FXML private TextField tf_by_user;
    @FXML private TableView<BookingEO> tv;

    private final ObservableList<BookingEO> bookings = FXCollections.observableArrayList();
    @FXML private void initialize(){
        tv.setItems(bookings);
        ListChangeListener listChangeListener = new ListChangeListener(this);
        tv.getSelectionModel().selectedItemProperty().addListener(listChangeListener);

        // Buttons Action handler
        ActionHandler actionHandler = new ActionHandler(this);
        btn_delete.setOnAction(actionHandler);
        btn_finish.setOnAction(actionHandler);
        btn_overdue.setOnAction(actionHandler);

        // TextField listener
        SearchFieldsListener searchFieldsListener = new SearchFieldsListener(this);
        tf_by_resource.textProperty().addListener(searchFieldsListener);
        tf_by_user.textProperty().addListener(searchFieldsListener);
    }
}
