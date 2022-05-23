package se.ya.bokningssystem.frontend.admin.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lombok.Getter;
import ojail.mohamad.TypeTextField;
import se.ya.bokningssystem.backend.entity.UserEO;
@Getter
public class UserController {
    @FXML  private Button btn_add, btn_delete, btn_edit, btn_save;
    @FXML  private ChoiceBox<Boolean> choice_add_status, coice_edit_status;
    @FXML  private TableColumn<UserEO, String> col_email;
    @FXML  private TableColumn<UserEO, String> col_f_name;
    @FXML  private TableColumn<UserEO, String> col_l_name;
    @FXML  private TableColumn<UserEO, Boolean> col_status;
    @FXML  private TableView<UserEO> tv;
    @FXML  private TypeTextField tf_add_email, tf_add_f_name, tf_add_l_name, tf_edit_email,
            tf_edit_f_name, tf_edit_l_name, tf_find_by_id, tf_find_by_name;
    private final ObservableList<UserEO> users = FXCollections.observableArrayList();
    @FXML private void initialize(){

    }
}