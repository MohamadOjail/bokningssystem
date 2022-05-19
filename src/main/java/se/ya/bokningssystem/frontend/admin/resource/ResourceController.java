package se.ya.bokningssystem.frontend.admin.resource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lombok.Getter;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.BorrowStatus;

@Getter
public class ResourceController {

    ResourceDAO resDAO = new ResourceDAO();

    @FXML private Button btn_add_resource, btn_delete_resource, btn_edit_resource, btn_get_resource, btn_update_resource;
    @FXML private ChoiceBox<ResourceEO> cb_status;
    @FXML private TableColumn<ResourceEO, String> tc_art_number;
    @FXML private TableColumn<ResourceEO, String> tc_resource_name;
    @FXML private TableColumn<ResourceEO, BorrowStatus> tc_status;
    @FXML private TextField tf_art_number, tf_resource_name;
    @FXML private TableView<ResourceEO> tw_resource;
    private final ObservableList<ResourceEO> resources = FXCollections.observableArrayList();

    @FXML private void initialize(){
        tc_resource_name.setCellValueFactory(new PropertyValueFactory<>("description"));
        tc_art_number.setCellValueFactory(new PropertyValueFactory<>("artNum"));
        tc_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        ResourceActionHandler handler = new ResourceActionHandler(this);
        btn_get_resource.setOnAction(handler);

    }
    @FXML
    void add_resource(ActionEvent event) {
        ResourceDAO resDAO = new ResourceDAO();
//        btn_add_resource.setOnAction();
    }

    @FXML
    void delete_resource(MouseEvent event) {

    }

    @FXML
    void edit_resource(MouseEvent event) {

    }

    @FXML
    void get_resource() {

        tw_resource.setItems(resources);
        resources.addAll(new ResourceDAO().findAll());

    }

    @FXML
    void update_resource(MouseEvent event) {

    }

}
