package se.ya.bokningssystem.frontend.user;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lombok.Getter;
import lombok.Setter;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.frontend.switcher.ObjectHolder;

import java.time.LocalDateTime;
@Getter
@Setter
public class UserController {

    @FXML private Button btn_book, btn_cancel_booking, btn_return_resource;
    @FXML private TableColumn<BookingEO, String> col_bkngs_resources;
    @FXML private TableColumn<BookingEO, LocalDateTime> col_bkngs_return_date;
    @FXML private TableColumn<BookingEO, BookingStatus> col_bkngs_status;
    @FXML private TableColumn<ResourceEO, LocalDateTime> col_rscs_available_date;
    @FXML private TableColumn<ResourceEO, String> col_rscs_resources;
    @FXML private TableColumn<ResourceEO, String> col_rscs_status;
    @FXML private Label lbl_log_out, lbl_user_name;
    @FXML private TextField tf_search;
    @FXML private TableView<BookingEO> tv_bookings;
    @FXML private TableView<ResourceEO> tv_resources;

    private UserEO currentUser;

    private final ObservableList<ResourceEO> resources = FXCollections.observableArrayList();
    private final ObservableList<BookingEO> bookings = FXCollections.observableArrayList();

    @FXML private void initialize(){
        ObjectHolder.get().getCurrentUser(this);
        lbl_user_name.setText(currentUser.getFirstName() + " " + currentUser.getLastName());

        UserActionHandler mouseActionHandler = new UserActionHandler(this);
        lbl_log_out.setOnMouseClicked(mouseActionHandler);
        btn_book.setOnMouseClicked(mouseActionHandler);

        tv_bookings.setItems(bookings);

        tv_resources.setItems(resources);
        col_rscs_resources.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_rscs_status.setCellValueFactory(resource -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(resource.getValue().getStatus().value);
            return property;
        });
        col_rscs_available_date.setCellValueFactory(new PropertyValueFactory<>("availableDate"));

        UserSearchFieldListener searchFieldListener = new UserSearchFieldListener(this);
        tf_search.textProperty().addListener(searchFieldListener);
    }
}
