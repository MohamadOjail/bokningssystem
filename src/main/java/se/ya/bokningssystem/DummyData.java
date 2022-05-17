package se.ya.bokningssystem;

import se.ya.bokningssystem.backend.dao.ResourceDAO;
import se.ya.bokningssystem.backend.dao.UserDAO;
import se.ya.bokningssystem.backend.entity.ResourceEO;
import se.ya.bokningssystem.backend.entity.UserEO;
import se.ya.bokningssystem.backend.entity.enums.ResourceStatus;

import java.util.Random;

public class DummyData {

    public static void generateUsers(){
        UserDAO userDAO = new UserDAO();
        for (int i = 0; i <= 5; i++) {
            UserEO user = new UserEO();
            user.setFirstName(generateWord(6));
            user.setLastName(generateWord(6));
            user.setEmail(generateWord(5) + "@" + generateWord(5) + "." + generateWord(3));
            userDAO.add(user);
        }
    }

    public static void generateResources(){
        ResourceDAO resourceDAO = new ResourceDAO();
        for (int i = 0; i<= 5; i++) {
            ResourceEO resourceEO = new ResourceEO();
            resourceEO.setStatus(ResourceStatus.AVAILABLE);
            resourceEO.setArtNum(generateWord(3));
            resourceEO.setDescription(generateWord(10));
            resourceDAO.add(resourceEO);
        }
    }

    private static String generateWord(int length) {
        Random rnd = new Random();
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = lexicon.charAt(rnd.nextInt(lexicon.length()));
        }
        return new String(text);
    }
}
