package se.ya.bokningssystem.frontend.admin.resource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;
import se.ya.bokningssystem.frontend.admin.resource.handlers.*;

@Getter
public class ResourceController {
    @FXML private Button btn_add, btn_delete, btn_edit, btn_find_all, btn_update;
    @FXML private ChoiceBox<ResourceStatus> choice_add_status, choice_edit_status;
    @FXML private TableView<ResourceEO> tv;
    @FXML private TableColumn<ResourceEO, String> col_artnumber;
    @FXML private TableColumn<ResourceEO, String> col_description;
    @FXML private TableColumn<ResourceEO, ResourceStatus> col_status;
    @FXML private TextField tf_add_artnumber, tf_add_description;
    @FXML private TextField tf_edit_artnumber, tf_edit_description;
    @FXML private TextField tf_find_by_artnumber, tf_find_by_description;

    private final ObservableList<ResourceEO> resources = FXCollections.observableArrayList();

    @FXML private void initialize(){
        tv.setItems(resources);
        col_artnumber.setCellValueFactory(new PropertyValueFactory<>("artNum"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Search Fields observer
        SearchFieldsHandler searchFieldsHandler = new SearchFieldsHandler(this);
        tf_find_by_artnumber.focusedProperty().addListener(searchFieldsHandler);
        tf_find_by_description.focusedProperty().addListener(searchFieldsHandler);

        // implementera sök funktioner
        FindResourceListener findResourceListener = new FindResourceListener(this);
        tf_find_by_artnumber.textProperty().addListener(findResourceListener);
        tf_find_by_description.textProperty().addListener(findResourceListener);

        // enable select section
        ListSelectionListener listSelectionListener = new ListSelectionListener(this);
        tv.getSelectionModel().selectedItemProperty().addListener(listSelectionListener);

        // populate choiceBoxes
        choice_add_status.getItems().addAll(ResourceStatus.values());
        choice_edit_status.getItems().addAll(ResourceStatus.values());

        // Buttons action events
        ActionHandler actionHandler = new ActionHandler(this);
        btn_update.setOnAction(actionHandler);
        btn_edit.setOnAction(actionHandler);
        btn_delete.setOnAction(actionHandler);
        btn_add.setOnAction(actionHandler);
        btn_find_all.setOnAction(actionHandler);

        // Add section change listener
        AddSectionChangeListener addSectionChangeListener = new AddSectionChangeListener(this);
        tf_add_artnumber.textProperty().addListener(addSectionChangeListener);
        tf_add_description.textProperty().addListener(addSectionChangeListener);
        choice_add_status.getSelectionModel().selectedItemProperty().addListener(addSectionChangeListener);
    }
}
