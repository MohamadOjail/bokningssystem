package se.ya.bokningssystem.frontend.admin.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;

public class UserController {
    @FXML private Button btn_add, btn_delete, btn_edit, btn_update;
    @FXML private ChoiceBox<Boolean> choice_add_status, choice_add_status1;
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
    }
}
