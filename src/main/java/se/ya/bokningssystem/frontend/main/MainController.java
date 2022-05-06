package se.ya.bokningssystem.frontend.main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.UserEO;

@Getter
public class MainController {

    @FXML private Button btn_login;
    @FXML private TextField tf_admin_code, tf_user_name;

    @FXML private void initialize(){

        MainActionHandler actionHandler = new MainActionHandler(this);
        btn_login.setOnAction(actionHandler);

        MainInputChangeHandler inputChangeHandler = new MainInputChangeHandler(this);
        tf_admin_code.setOnKeyTyped(inputChangeHandler);
        tf_user_name.setOnKeyTyped(inputChangeHandler);


    }
}