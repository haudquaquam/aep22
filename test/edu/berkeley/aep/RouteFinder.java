package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashMap;
// Understands ways to get from one airport to another
public class RouteFinder {

    public HashMap<String, Airport> _myAirports = new HashMap<>();

    public RouteFinder(Airport... airports) {
        for (Airport airport : airports) {
            _myAirports.put(airport._myName, airport);
        }
    }

    public boolean find(String start, String destination) {
        if (start == null) {
            return false;
        }
        if (start.equals(destination)) {
            return true;
        } else if (!(_myAirports.containsKey(start))) {
            return false;
        }

        Airport startAirport = _myAirports.get(start);
        for (String destAirport : startAirport._myRoutes) {
            return (destAirport.equals(destination) ||
                    find(destAirport, destination));
        }
        return false;
    }
}
