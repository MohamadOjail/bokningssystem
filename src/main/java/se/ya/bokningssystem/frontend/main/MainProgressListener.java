package se.ya.bokningssystem.frontend.main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressIndicator;

public class MainProgressListener implements ChangeListener {

    private final MainController mc;

    public MainProgressListener(MainController mc) {
        this.mc = mc;
    }


    @Override
    public void changed(ObservableValue observableValue, Object o, Object t1) {
        if (t1.equals(ProgressIndicator.INDETERMINATE_PROGRESS)){
            mc.getInfo().setText("Laddar data ur databasen ..");
        }else mc.getInfo().setText("");
    }
}
