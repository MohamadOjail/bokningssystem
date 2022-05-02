module se.ya.bokningssystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.ya.bokningssystem to javafx.fxml;
    exports se.ya.bokningssystem;
}