package se.ya.bokningssystem.frontend.admin.inventory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class InventoryController {

    @FXML
    private Button btn_add_resource;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_edit_resource;

    @FXML
    private Button btn_get_resource;

    @FXML
    private ChoiceBox<?> cb_add_status;

    @FXML
    private ChoiceBox<?> cb_edit_status;

    @FXML
    private TableColumn<?, ?> tc_art_number;

    @FXML
    private TableColumn<?, ?> tc_description;

    @FXML
    private TableColumn<?, ?> tc_status;

    @FXML
    private TextField td_edit_description, tf_add_art_num, tf_add_description, tf_edit_art_num, tf_find_by_resource_name;


}
