package se.ya.bokningssystem.frontend.user;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.frontend.switcher.ObjectHolder;
import se.ya.bokningssystem.frontend.user.handlers.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
public class UserController {

    @FXML private Button btn_book, btn_cancel_booking, btn_return_resource;
    @FXML private TableColumn<BookingEO, String> col_bkngs_resources;
    @FXML private TableColumn<BookingEO, LocalDateTime> col_bkngs_return_date;
    @FXML private TableColumn<BookingEO, String> col_bkngs_status;
    @FXML private TableColumn<ResourceEO, LocalDateTime> col_rscs_available_date;
    @FXML private TableColumn<ResourceEO, String> col_rscs_resources;
    @FXML private TableColumn<ResourceEO, String> col_rscs_status;
    @FXML private Label lbl_log_out, lbl_user_name;
    @FXML private TextField tf_search;
    @FXML private TableView<BookingEO> tv_bookings;
    @FXML private TableView<ResourceEO> tv_resources;
    @Setter
    private UserEO currentUser;
    @Setter
    private boolean setupCanceled;
    @Setter
    private LocalDate newBookingDate;
    @Setter
    private LocalDate newReturnDate;

    private final ObservableList<ResourceEO> resources = FXCollections.observableArrayList();
    private final ObservableList<BookingEO> bookings = FXCollections.observableArrayList();

    @FXML private void initialize(){
        ObjectHolder.get().getCurrentUser(this);
        lbl_user_name.setText(currentUser.getFirstName() + " " + currentUser.getLastName());

        // Buttons Action handler
        UserActionHandler mouseActionHandler = new UserActionHandler(this);
        lbl_log_out.setOnMouseClicked(mouseActionHandler);
        btn_book.setOnMouseClicked(mouseActionHandler);
        btn_cancel_booking.setOnMouseClicked(mouseActionHandler);
        btn_return_resource.setOnMouseClicked(mouseActionHandler);

        // Booking List Setup
        tv_bookings.setItems(bookings);
        bookings.addAll(new BookingDAO().getListByNamedQuery(BookingNamedQueries.GET_BY_USER.queryName, currentUser));
        col_bkngs_resources.setCellValueFactory(new PropertyValueFactory<>("resource"));
        col_bkngs_return_date.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        col_bkngs_status.setCellFactory(CellStyler::call);

        // Resource List Setup
        tv_resources.setItems(resources);
        col_rscs_resources.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_rscs_status.setCellValueFactory(resource -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(resource.getValue().getStatus().value);
            return property;
        });
        col_rscs_available_date.setCellValueFactory(new PropertyValueFactory<>("artNum"));

        UserSearchFieldListener searchFieldListener = new UserSearchFieldListener(this);
        tf_search.textProperty().addListener(searchFieldListener);

        // resource list change listener
        ResourceListChangeListener resourceListChangeListener = new ResourceListChangeListener(this);
        tv_resources.getSelectionModel().selectedItemProperty().addListener(resourceListChangeListener);

        // booking list selection change listener'
        BookingListChangeListener bookingListChangeListener = new BookingListChangeListener(this);
        tv_bookings.getSelectionModel().selectedItemProperty().addListener(bookingListChangeListener);
    }
}
