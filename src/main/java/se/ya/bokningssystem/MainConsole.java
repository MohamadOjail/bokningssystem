package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.UserEO;

public class MainConsole {
    public static void main(String[] args) {

        DummyData.generateUsers();

        UserDAO userDAO = new UserDAO();
        for (UserEO userEO : userDAO.findAll()){
            System.out.println(userEO.getFirstName() + " " + userEO.getEmail());
        }
    }
}
