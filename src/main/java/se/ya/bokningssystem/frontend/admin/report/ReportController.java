package se.ya.bokningssystem.frontend.admin.report;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import se.ya.bokningssystem.backend.entity.ReportEO;

import java.time.LocalDate;

public class ReportController {

    @FXML
    private Button btn_delete_report;

    @FXML
    private Button btn_get_report;

    @FXML
    private TableColumn<ReportEO, String> tc_booking_id;

    @FXML
    private TableColumn<ReportEO, LocalDate> tc_report_date;

    @FXML
    private TextField tf_find_with_bookingid;

}
