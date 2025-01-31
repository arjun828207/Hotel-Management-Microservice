package com.lcwd.hotel.services;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public Hotel create(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public Hotel get(String id) {
        return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No record such found"));
    }

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @Override
    public Hotel updateHotel(String id, Hotel hotel) {
        Hotel existingHotel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with ID " + id + " not found"));
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setAbout(hotel.getAbout());
        return repository.save(existingHotel);
    }

    @Override
    public void deleteHotel(String id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with ID " + id + " not found"));
        repository.deleteById(id);
    }
}

