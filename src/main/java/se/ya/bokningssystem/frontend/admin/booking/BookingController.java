package se.ya.bokningssystem.frontend.admin.booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;

import java.time.LocalDate;

public class BookingController {

    @FXML private Button btn_get_bookings;

    @FXML private TableColumn<BookingEO, LocalDate> tc_actual_return_date;

    @FXML private TableColumn<BookingEO, LocalDate> tc_booking_date;

    @FXML private TableColumn<BookingEO, ResourceEO> tc_booking_resource;

    @FXML private TableColumn<BookingEO, UserEO> tc_booking_user;

    @FXML private TableColumn<BookingEO, LocalDate> tc_reminder_date;

    @FXML private TableColumn<BookingEO, LocalDate> tc_return_date;

    @FXML private TableColumn<BookingEO, BookingStatus> tc_status;

    @FXML private TableView<BookingEO> tw_booking;

    private final ObservableList<BookingEO> bookings = FXCollections.observableArrayList();


    @FXML private void initialize(){
        tc_booking_user.setCellValueFactory(new PropertyValueFactory<>("user"));
        tc_booking_resource.setCellValueFactory(new PropertyValueFactory<>("resource"));
        tc_booking_date.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        tc_return_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        tc_reminder_date.setCellValueFactory(new PropertyValueFactory<>("reminderDate"));
        tc_actual_return_date.setCellValueFactory(new PropertyValueFactory<>("actualReturnDate"));
        tc_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        BookingActionHandler handler = new BookingActionHandler(this);
        btn_get_bookings.setOnAction(handler);
    }



    @FXML
    void get_bookings(ActionEvent event) {
        tw_booking.setItems(bookings);
    }
}
