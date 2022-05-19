package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;

public class MainConsole {
    public static void main(String[] args) {

        ResourceDAO resourceDAO = new ResourceDAO();
        for (ResourceEO resourceEO : resourceDAO.getListByNamedQuery(ResourceNamedQueries.GET_BY_DESCRIPTION.queryName, "%su%")){
            System.out.println(resourceEO.getDescription());
        }
    }
}
