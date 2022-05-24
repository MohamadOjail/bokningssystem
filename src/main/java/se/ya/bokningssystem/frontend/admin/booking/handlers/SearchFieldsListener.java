package se.ya.bokningssystem.frontend.admin.booking.handlers;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

public class SearchFieldsListener implements ChangeListener<String> {
    private final BookingController bc;

    public SearchFieldsListener(BookingController bc) {
        this.bc = bc;
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

        if (t1 != null && observableValue instanceof StringProperty field){
            if (!t1.isEmpty() && field.getBean().equals(bc.getTf_by_resource())){
                // TODO hitta med resurs
            }
            if (!t1.isEmpty() && field.getBean().equals(bc.getTf_by_user())){
                // TODO hitta med användare
            }
        }
    }
}
