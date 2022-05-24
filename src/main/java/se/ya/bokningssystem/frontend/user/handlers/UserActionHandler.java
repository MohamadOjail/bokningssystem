package se.ya.bokningssystem.frontend.user.handlers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;
import se.ya.bokningssystem.frontend.switcher.Switcher;
import se.ya.bokningssystem.frontend.switcher.Views;
import se.ya.bokningssystem.frontend.user.UserController;
import se.ya.bokningssystem.frontend.user.setup.SetupController;
import se.ya.bokningssystem.frontend.utils.Alerter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class UserActionHandler implements EventHandler<MouseEvent> {

    private final UserController uc;
    private final BookingDAO bookingDAO = new BookingDAO();
    private final ResourceDAO resourceDAO = new ResourceDAO();
    private final UserDAO userDAO = new UserDAO();

    public UserActionHandler(UserController uc) {this.uc = uc;}

    @Override
    public void handle(MouseEvent e) {

        if (e.getSource() == uc.getLbl_log_out()){
            uc.setCurrentUser(null);
            Switcher.get().loadScene(Views.LOGIN);
        }

        if (e.getSource() == uc.getBtn_book()){
            bookResource();
        }

        if (e.getSource() == uc.getBtn_return_resource()){
            returnResource();
        }

        if (e.getSource() == uc.getBtn_cancel_booking()){
            returnResource();
        }
    }

    private void showSetup(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../BookingDatesSetup.fxml"));
        Parent root = null;
        try {
            root = loader.load();
            SetupController sc = loader.getController();
            sc.setUc(uc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Scene setupScene = new Scene(root);
        stage.setScene(setupScene);
        stage.showAndWait();
    }
    private void bookResource(){
        showSetup();
        if (uc.isSetupCanceled()) return;
        UserEO user = uc.getCurrentUser();
        ResourceEO resourceEO = uc.getTv_resources().getSelectionModel().getSelectedItem();
        BookingEO bookingEO = new BookingEO();
        bookingEO.setUser(user);
        bookingEO.setStatus(BookingStatus.ACTIVE);
        bookingEO.setBookingDate(uc.getNewBookingDate());
        bookingEO.setResource(resourceEO);
        bookingEO.setReturnDate(uc.getNewReturnDate());
        bookingEO.setReminderDate(uc.getNewReturnDate().minusDays(1));
        bookingDAO.add(bookingEO);
        user.addBooking(bookingEO);
        userDAO.update(user);
        resourceEO.setStatus(ResourceStatus.BORROWED);
        resourceDAO.update(resourceEO);
        Alerter.get().showMessage(Alert.AlertType.INFORMATION, "Bokad");
        uc.setSetupCanceled(true);
        refreshResourceList();
        refreshBookingsList();
    }
    private void refreshResourceList(){
        uc.getResources().clear();
        uc.getResources().addAll(resourceDAO.findAll());
    }

    private void refreshBookingsList(){
        uc.getBookings().clear();
        uc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_USER.queryName, uc.getCurrentUser()));
    }

    private void returnResource(){
        ResourceEO resource = uc.getTv_bookings().getSelectionModel().getSelectedItem().getResource();
        BookingEO selectedBooking = uc.getTv_bookings().getSelectionModel().getSelectedItem();
        selectedBooking.setStatus(BookingStatus.FINISHED);
        selectedBooking.setActualReturnDate(LocalDate.now());
        bookingDAO.update(selectedBooking);
        resource.setStatus(ResourceStatus.AVAILABLE);
        resourceDAO.update(resource);
        refreshBookingsList();
        refreshResourceList();
        Alerter.get().showMessage(Alert.AlertType.INFORMATION, "Bokningen avslutades");
    }
}
