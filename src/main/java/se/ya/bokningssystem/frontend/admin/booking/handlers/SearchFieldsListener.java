package se.ya.bokningssystem.frontend.admin.booking.handlers;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import se.ya.bokningssystem.backend.dao.BookingDAO;
import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.BookingNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.ResourceNamedQueries;
import se.ya.bokningssystem.backend.entity.enums.UserNamedQueries;
import se.ya.bokningssystem.frontend.admin.booking.BookingController;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFieldsListener implements ChangeListener<String> {
    private final BookingController bc;
    private final BookingDAO bookingDAO;
    private final ResourceDAO resourceDAO;
    private final UserDAO userDAO;

    public SearchFieldsListener(BookingController bc) {
        this.bc = bc;
        this.bookingDAO = new BookingDAO();
        this.resourceDAO = new ResourceDAO();
        this.bc.getBookings().clear();
        this.bc.getBookings().addAll(bookingDAO.findAll());
        this.userDAO = new UserDAO();
    }

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

        if (t1 != null && observableValue instanceof StringProperty field){

            if (!t1.isEmpty() && field.getBean().equals(bc.getTf_by_resource())){
                bc.getTf_by_user().clear();
                List<ResourceEO> resources = resourceDAO.getListByNamedQuery(ResourceNamedQueries.GET_BY_DESCRIPTION.queryName, "%" + t1 + "%");
                if (!resources.isEmpty()){
                    populateWithResource(getUniqueList(resources));
                    return;
                }
                populateNoFilter();
                return;
            }
            populateNoFilter();
            if (!t1.isEmpty() && field.getBean().equals(bc.getTf_by_user())){
                bc.getTf_by_resource().clear();
                UserEO userEO = userDAO.getByNamedQuery(UserNamedQueries.SINGLE_BY_NAME.queryName, t1);
                if (userEO != null){
                    populateWithUser(userEO);
                    return;
                }
                populateNoFilter();
            }
        }
    }
    private void populateWithUser(UserEO userEO){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_USER.queryName, userEO));
    }
    private void populateNoFilter(){
        bc.getBookings().clear();
        bc.getBookings().addAll(bookingDAO.findAll());
    }

    private void populateWithResource(List<ResourceEO> resources){
        bc.getBookings().clear();
        for (ResourceEO resourceEO : resources){
            bc.getBookings().addAll(bookingDAO.getListByNamedQuery(BookingNamedQueries.GET_BY_RESOURCE.queryName, resourceEO));
        }
    }

    private List<ResourceEO> getUniqueList(List<ResourceEO> objects){
        return objects.stream().distinct().collect(Collectors.toList());
    }
}
