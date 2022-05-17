package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.Report;
import se.ya.bokningssystem.backend.util.DataOps1;

import java.util.List;

public class ReportDAO{

    public Report add(Report report) {
        DataOps1<Report> dataOps = new DataOps1<>();
        return dataOps.add(report, Report.class);
    }


    public Report getById(long id) {
        DataOps1<Report> dataOps = new DataOps1<>();
        return dataOps.getById(id, Report.class);
    }




    public Report update(Report report) {
        DataOps1<Report> dataOps = new DataOps1<>();
        return dataOps.update(report, Report.class);
    }


    public void delete(long id) {
        DataOps1<Report> dataOps = new DataOps1<>();
        dataOps.delete(id, Report.class);

    }


    public List<Report> findAll() {
        DataOps1<Report> dataOps = new DataOps1<>();
        return dataOps.findAll(Report.class);
    }


}
