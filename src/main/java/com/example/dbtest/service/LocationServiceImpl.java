package com.example.dbtest.service;

import com.example.dbtest.model.Location;
import com.example.dbtest.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(Long locationId) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        return optionalLocation.orElse(null);
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long locationId, Location location) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if (optionalLocation.isPresent()) {
            Location existingLocation = optionalLocation.get();
            existingLocation.setStreet(location.getStreet());
            existingLocation.setCity(location.getCity());
            existingLocation.setState(location.getState());
            return locationRepository.save(existingLocation);
        }
        return null;
    }

    @Override
    public String deleteLocation(Long locationId) {
        Optional<Location> optionalLocation = locationRepository.findById(locationId);
        if(optionalLocation.isPresent()){
            locationRepository.delete(optionalLocation.get());
            return "Location deleted successfully from ID: " + locationId;
        }
        return "Location not found";

    }
}