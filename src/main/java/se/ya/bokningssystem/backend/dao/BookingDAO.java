package se.ya.bokningssystem.backend.dao;

import se.ya.bokningssystem.backend.entity.BookingEO;

import java.util.List;

public class BookingDAO implements DaoOps<BookingEO> {
    @Override
    public BookingEO add(BookingEO bookingEO) {
        return null; //TODO
    }

    @Override
    public BookingEO getById(long id) {
        return null; //TODO
    }

    @Override
    public BookingEO getByInput(String input) {
        return null;
    }

    @Override
    public BookingEO update(BookingEO bookingEO) {
        return null; //TODO
    }

    @Override
    public void delete(long id) {
        //TODO
    }

    @Override
    public List<BookingEO> findAll() {
        return null; //TODO
    }

    @Override
    public List<BookingEO> findByWildCard(String input) {
        return null; //TODO
    }
}
