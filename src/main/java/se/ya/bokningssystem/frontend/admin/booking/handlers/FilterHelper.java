package se.ya.bokningssystem.frontend.admin.booking.handlers;

import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.BookingStatus;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

import java.util.List;
import java.util.stream.Collectors;

public class FilterHelper {
    private final BookingController bc;
    private final BookingDAO bookingDAO = new BookingDAO();

    public FilterHelper(BookingController bc) {
        this.bc = bc;
    }

    public void populateWithUser(UserEO userEO){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_USER.queryName, userEO));
        bc.getChoice_filter_status().getSelectionModel().select(null);
        bc.getTv().refresh();
    }
    public void populateNoFilter(){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.findAll());
        bc.getTv().refresh();
    }

    public void populateWithResource(List<ResourceEO> resources){
        bc.getBookings().clear();
        for (ResourceEO resourceEO : resources){
            bc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resourceEO));
        }
        bc.getChoice_filter_status().getSelectionModel().select(null);
        bc.getTv().refresh();
    }

    public List<ResourceEO> getUniqueList(List<ResourceEO> objects){
        return objects.stream().distinct().collect(Collectors.toList());
    }

    public void populateWithStatus(BookingStatus status){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_STATUS.queryName, status));
        bc.getTv().refresh();
    }

    public void resetFilterFields(){
        bc.getTf_by_resource().clear();
        bc.getTf_by_user().clear();
        bc.getChoice_filter_status().getSelectionModel().select(null);
    }
}
