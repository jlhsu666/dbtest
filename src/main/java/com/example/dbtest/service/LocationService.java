package com.example.dbtest.service;

import com.example.dbtest.model.Location;
import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocationById(Long locationId);
    Location addLocation(Location location);
    Location updateLocation(Long locationId, Location location);
    String deleteLocation(Long locationId);
}
