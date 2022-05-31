package se.ya.bokningssystem;

public class MainConsole {
    public static void main(String[] args) {

        DummyData.generateUsers();
        DummyData.generateResources();
        DummyData.generateBookings();

    }
}
