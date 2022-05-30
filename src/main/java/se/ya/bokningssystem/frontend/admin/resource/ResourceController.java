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

import java.util.Arrays;

@Getter
public class ResourceController {
    @FXML private Button btn_find_all;
    @FXML private ChoiceBox<ResourceStatus> choice_filter;
    @FXML private TableView<ResourceEO> tv;
    @FXML private TableColumn<ResourceEO, String> col_artnumber;
    @FXML private TableColumn<ResourceEO, String> col_description;
    @FXML private TableColumn<ResourceEO, ResourceStatus> col_status;
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

        // Buttons action events
        ActionHandler actionHandler = new ActionHandler(this);
        btn_find_all.setOnAction(actionHandler);

        // filter choicebox
        choice_filter.getItems().addAll(ResourceStatus.values());

        // filter listener
        FindHelper findHelper = new FindHelper( this);
        choice_filter.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if (t1 != null){
                findHelper.populateResourceList(t1);
            }
        });
    }
}
