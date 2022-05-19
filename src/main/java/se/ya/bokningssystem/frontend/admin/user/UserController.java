package se.ya.bokningssystem.frontend.admin.user;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BorrowStatus;

public class UserController {

    UserDAO useDAO = new UserDAO();

    @FXML
    private Button btn_add_user, btn_delete_user, btn_edit_user, btn_get_user, btn_update_user;

    @FXML
    private ChoiceBox<UserEO> cb_state;

    @FXML
    private TableColumn<UserEO, String> tc_email;

    @FXML
    private TableColumn<UserEO, String> tc_first_name;

    @FXML
    private TableColumn<UserEO, String> tc_last_name;

    @FXML
    private TableColumn<UserEO, BorrowStatus> tc_state;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_first_name;

    @FXML
    private TextField tf_last_name;

    @FXML
    private TableView<UserEO> tw_user;

    private final ObservableList<UserEO> users = FXCollections.observableArrayList();

    @FXML private void initialize(){
        tc_first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tc_last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tc_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        tc_state.setCellValueFactory(new PropertyValueFactory<>("state"));

        UserActionHandler handler = new UserActionHandler(this);
        btn_get_user.setOnAction(handler);

    }

    @FXML
    void add_user(ActionEvent e) {

    }

    @FXML
    void delete_user(ActionEvent e) {

    }

    @FXML
    void edit_user(ActionEvent e) {

    }

    @FXML
    void get_user() {
        tw_user.setItems(users);
        users.addAll(new UserDAO().findAll());

    }

    @FXML
    void update_user() {

    }


}

