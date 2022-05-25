package se.ya.bokningssystem.frontend.admin.report;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ReportController {

    @FXML
    private Button btn_delete_report;

    @FXML
    private Button btn_get_report;

    @FXML
    private TableColumn<?, ?> tc_booking_id;

    @FXML
    private TableColumn<?, ?> tc_report_date;

    @FXML
    private TextField tf_find_with_bookingid;

}
