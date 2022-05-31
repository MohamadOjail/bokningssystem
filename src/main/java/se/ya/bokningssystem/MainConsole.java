package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.util.BookingService;
import se.ya.bokningssystem.backend.util.ResourceService;

public class MainConsole {
    public static void main(String[] args) {

        ResourceService resourceService = new ResourceService();
        resourceService.refreshAllResource();
    }
}
