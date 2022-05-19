package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.Report;

import java.util.List;

public class ReportDAO{

    public Report add(Report report) {
        DataOps<Report> dataOps = new DataOps<>();
        return dataOps.add(report, Report.class);
    }


    public Report getById(long id) {
        DataOps<Report> dataOps = new DataOps<>();
        return dataOps.getById(id, Report.class);
    }




    public Report update(Report report) {
        DataOps<Report> dataOps = new DataOps<>();
        return dataOps.update(report, Report.class);
    }


    public void delete(long id) {
        DataOps<Report> dataOps = new DataOps<>();
        dataOps.delete(id, Report.class);

    }


    public List<Report> findAll() {
        DataOps<Report> dataOps = new DataOps<>();
        return dataOps.findAll(Report.class);
    }


}
