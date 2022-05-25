package se.ya.bokningssystem.frontend.admin.inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;
import se.ya.bokningssystem.frontend.admin.inventory.handlers.*;


@Getter
public class InventoryController {

    @FXML private Button btn_add_resource, btn_delete, btn_edit_resource, btn_get_resource;

    @FXML private ChoiceBox<ResourceStatus> cb_add_status, cb_edit_status;


    @FXML private TableColumn<ResourceEO, String> tc_art_number;

    @FXML private TableColumn<ResourceEO, String> tc_description;

    @FXML private TableColumn<ResourceEO, String> tc_status;

    @FXML private TextField td_edit_description, tf_add_art_num, tf_add_description, tf_edit_art_num, tf_find_by_artnum;

    @FXML
    private TableView<ResourceEO> tv;

    private final ObservableList<ResourceEO> resourceEOS = FXCollections.observableArrayList();

    @FXML private void initialize(){
        tv.setItems(resourceEOS);
        cb_add_status.getItems().addAll(ResourceStatus.values());
        cb_edit_status.getItems().addAll(ResourceStatus.values());
        //actionHandler
        ActionEventsHandler actionEventsHandler = new ActionEventsHandler(this);
        btn_get_resource.setOnAction(actionEventsHandler);
        btn_add_resource.setOnAction(actionEventsHandler);
        btn_delete.setOnAction(actionEventsHandler);
        btn_edit_resource.setOnAction(actionEventsHandler);
        //cellfactory
        tc_art_number.setCellValueFactory(new PropertyValueFactory<>("artNum"));
        tc_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        tc_status.setCellValueFactory(resource -> {
            SimpleStringProperty property = new SimpleStringProperty();
            property.setValue(resource.getValue().getStatus().value);
            return property;
        });
        //searchChangeListener
        SearchChangeListener searchChangeListener = new SearchChangeListener(this);
        tf_find_by_artnum.textProperty().addListener(searchChangeListener);
        //listChangeListener
        ListChangeListener listChangeListener = new ListChangeListener(this);
        tv.getSelectionModel().selectedItemProperty().addListener(listChangeListener);
        //addSectionOkay
        AddSectionListener addSectionListener = new AddSectionListener(this);
        tf_add_art_num.textProperty().addListener(addSectionListener);
        tf_add_description.textProperty().addListener(addSectionListener);
        cb_add_status.getSelectionModel().selectedItemProperty().addListener(addSectionListener);

        //editSectionChangeListener
        EditSectionChangeListener editSectionChangeListener = new EditSectionChangeListener(this);
        tf_edit_art_num.textProperty().addListener(editSectionChangeListener);
        td_edit_description.textProperty().addListener(editSectionChangeListener);
        cb_edit_status.getSelectionModel().selectedItemProperty().addListener(editSectionChangeListener);
    }


}
