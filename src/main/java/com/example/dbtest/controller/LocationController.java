package com.example.dbtest.controller;

import com.example.dbtest.model.Location;
import com.example.dbtest.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return new ResponseEntity<>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long locationId) {
        return new ResponseEntity<>(locationService.getLocationById(locationId), HttpStatus.OK);
    }

   @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        return new ResponseEntity<>(locationService.addLocation(location), HttpStatus.CREATED);
    }

    @PatchMapping("/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long locationId, @RequestBody Location location) {
       return new ResponseEntity<>(locationService.updateLocation(locationId,location), HttpStatus.OK);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long locationId) {
        return new ResponseEntity<>(locationService.deleteLocation(locationId), HttpStatus.OK);
    }
}