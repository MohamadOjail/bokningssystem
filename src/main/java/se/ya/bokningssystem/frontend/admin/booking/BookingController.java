package se.ya.bokningssystem.frontend.admin.booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.frontend.admin.booking.handlers.ActionHandler;
import se.ya.bokningssystem.frontend.admin.booking.handlers.ListChangeListener;
import se.ya.bokningssystem.frontend.admin.booking.handlers.SearchFieldsListener;

import java.time.LocalDate;

@Getter
public class BookingController {
    @FXML private Button btn_delete, btn_finish, btn_overdue;
    @FXML private TableColumn<BookingEO, LocalDate> col_actual_return_date;
    @FXML private TableColumn<BookingEO, LocalDate> col_booking_date;
    @FXML private TableColumn<BookingEO, LocalDate> col_reminder_date;
    @FXML private TableColumn<BookingEO, ResourceEO> col_resource;
    @FXML private TableColumn<BookingEO, LocalDate> col_returl_date;
    @FXML private TableColumn<BookingEO, String> col_status;
    @FXML private TableColumn<BookingEO, UserEO> col_user;
    @FXML private TextField tf_by_resource;
    @FXML private TextField tf_by_user;
    @FXML private TableView<BookingEO> tv;

    private final ObservableList<BookingEO> bookings = FXCollections.observableArrayList();
    private final ObservableList<BookingEO> filteredBookings = FXCollections.observableArrayList();
    @FXML private void initialize(){
        tv.setItems(bookings);
        ListChangeListener listChangeListener = new ListChangeListener(this);
        tv.getSelectionModel().selectedItemProperty().addListener(listChangeListener);

        // Cell factory
        col_user.setCellValueFactory(new PropertyValueFactory<>("user"));
        col_resource.setCellValueFactory(new PropertyValueFactory<>("resource"));
        col_booking_date.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        col_returl_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        col_reminder_date.setCellValueFactory(new PropertyValueFactory<>("reminderDate"));
        col_actual_return_date.setCellValueFactory(new PropertyValueFactory<>("actualReturnDate"));
//        col_status.setCellValueFactory(booking -> {
//            SimpleStringProperty property = new SimpleStringProperty();
//            property.setValue(booking.getValue().getStatus().value);
//            return property;
//        });

        col_status.setCellFactory(param -> new TableCell<BookingEO, String>()
        {
            @Override
            protected void updateItem(String item, boolean empty)
            {
                if (!empty)
                {
                    int currentIndex = indexProperty()
                            .getValue() < 0 ? 0
                            : indexProperty().getValue();

                    BookingStatus status = param
                            .getTableView().getItems()
                            .get(currentIndex).getStatus();
                    if (status.equals(BookingStatus.OVERDUE))
                    {
                        setId("overdue");
                    } else
                    {
                        setId("");
                    }
                        setText(status.value);
                }
            }
        });


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
