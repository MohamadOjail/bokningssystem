package se.ya.bokningssystem.frontend.user.setup.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import se.ya.bokningssystem.frontend.user.setup.SetupController;

public class ActionHandler implements EventHandler<ActionEvent> {
    private final SetupController sc;

    public ActionHandler(SetupController sc) {this.sc = sc;}

    @Override
    public void handle(ActionEvent e) {
        Stage thisStage = (Stage) sc.getBtn_ok().getScene().getWindow();
        if (e.getSource() == sc.getBtn_ok()){
            sc.getUc().setNewBookingDate(sc.getDp_booking_date().getValue());
            sc.getUc().setNewReturnDate(sc.getDp_return_date().getValue());
            sc.getUc().setSetupCanceled(false);
            thisStage.close();
            return;
        }
        sc.getUc().setSetupCanceled(true);
        thisStage.close();
    }
}
