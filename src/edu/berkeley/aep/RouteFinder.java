package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashMap;
// Understands ways to get from one airport to another
public class RouteFinder {

    public HashMap<String, Airport> _myAirports = new HashMap<>();

    public RouteFinder(Airport... airports) {
        for (Airport airport : airports) {
            _myAirports.put(airport.name(), airport);
        }
    }

    public boolean findRoute(String start, String destination) {
        return start.equals(destination);
    }

}
