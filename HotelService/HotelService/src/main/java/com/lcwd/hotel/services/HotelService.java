package com.lcwd.hotel.services;
import com.lcwd.hotel.entities.Hotel;
import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    Hotel get(String id);

    List<Hotel> getAll();

    Hotel updateHotel(String id, Hotel hotel);

    void deleteHotel(String id);
}
