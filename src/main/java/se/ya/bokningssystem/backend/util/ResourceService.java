package se.ya.bokningssystem.backend.util;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.entity.BookingEO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;

import java.util.ArrayList;
import java.util.List;

public class ResourceService {
    private final ResourceDAO resourceDAO = new ResourceDAO();
    private final BookingDAO bookingDAO = new BookingDAO();

    public void refreshResourceStatus(ResourceEO resource){
        List<BookingEO> overdueOrActiveBookings = new ArrayList<>();
        for (BookingEO bookingEO : bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resource)){
            if (bookingEO.getStatus() == BookingStatus.ACTIVE || bookingEO.getStatus() == BookingStatus.OVERDUE)
                overdueOrActiveBookings.add(bookingEO);
        }
        if (overdueOrActiveBookings.isEmpty()) resource.setStatus(ResourceStatus.AVAILABLE);
        else resource.setStatus(ResourceStatus.BOOKED);
        resourceDAO.update(resource);
    }

    public void refreshAllResource(){
        for (ResourceEO resourceEO : resourceDAO.findAll()){
            refreshResourceStatus(resourceEO);
        }
    }

    public void addResource(String description, String artNum){
        ResourceEO resource = new ResourceEO();
        resource.setDescription(description);
        resource.setArtNum(artNum);
        resource.setStatus(ResourceStatus.AVAILABLE);
        resourceDAO.add(resource);
    }

    public void deleteResource(ResourceEO resource){
        for (BookingEO bookingEO : bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resource)){
            bookingDAO.delete(bookingEO.getId());
        }
        resourceDAO.delete(resource.getId());
    }
}
