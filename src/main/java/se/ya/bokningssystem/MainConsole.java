package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;

public class MainConsole {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        UserEO userEO = new UserEO();
        userEO.setFirstName("xc");
        userEO.setLastName("xc");
        userEO.setEmail("xc@tt.ee");

        userDAO.add(userEO);

    }
}
