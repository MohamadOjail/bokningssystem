package se.ya.bokningssystem.frontend.admin.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.frontend.admin.user.handlers.*;

@Getter
public class UserController {
    @FXML private Button btn_add, btn_delete, btn_edit, btn_update;
    @FXML private ChoiceBox<Boolean> choice_add_status, choice_edit_status;
    @FXML private TableColumn<UserEO, String> col_email;
    @FXML private TableColumn<UserEO, String> col_f_name;
    @FXML private TableColumn<UserEO, String> col_l_name;
    @FXML private TableColumn<UserEO, Boolean> col_status;
    @FXML private TextField tf_add_email, tf_add_f_name, tf_add_l_name;
    @FXML private TextField tf_edit_email, tf_edit_f_name, tf_edit_l_name;
    @FXML private TextField tf_find_by_id, tf_find_by_name;
    @FXML private TableView<UserEO> tv;

    private final ObservableList<UserEO> users = FXCollections.observableArrayList();
    @FXML private void initialize(){
        tv.setItems(users);
        col_f_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_l_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("canBorrow"));

        tf_find_by_name.textProperty().addListener(new FindByNameListener(users));
        tf_find_by_id.textProperty().addListener(new FindByIdListener(users));
        tv.getSelectionModel().selectedItemProperty().addListener(new ListSelectionListener(this));

        choice_edit_status.getItems().addAll(true, false);
        choice_add_status.getItems().addAll(true, false);

        // button actions
        BTN_ActionListener btn_actionListener = new BTN_ActionListener(this);
        btn_delete.setOnAction(btn_actionListener);
        btn_edit.setOnAction(btn_actionListener);
        btn_update.setOnAction(btn_actionListener);
        btn_add.setOnAction(btn_actionListener);

        // Add section listener
        AddSectionListener addSectionListener = new AddSectionListener(this);
        tf_add_f_name.textProperty().addListener(addSectionListener);
        tf_add_l_name.textProperty().addListener(addSectionListener);
        tf_add_email.textProperty().addListener(addSectionListener);
        choice_add_status.getSelectionModel().selectedItemProperty().addListener(addSectionListener);
    }
}
