package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;

public class MainConsole {

    public static void main(String[] args) {

        ResourceDAO resourceDAO = new ResourceDAO();
        for (ResourceEO resourceEO : resourceDAO.findByWildCard("mod")){
            System.out.println(resourceEO.getId() + " - " + resourceEO.getDescription());
        }
    }
}
