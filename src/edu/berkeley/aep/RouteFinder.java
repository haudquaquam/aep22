package edu.berkeley.aep;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
// Understands ways to get from one airport to another
public class RouteFinder {

    private HashMap<String, Airport> _myAirports = new HashMap<>();
    private ArrayList<String> _validAirports = new ArrayList<>();

    public RouteFinder(Airport... airports) {
        for (Airport airport : airports) {
            _myAirports.put(airport.name(), airport);
            _validAirports.add(airport.name());
            _validAirports.addAll(airport.getRoutes());
        }
    }

    public boolean findRoute(String start, String destination) {
        if (_validAirports.contains(start)) {
            if (start.equals(destination)) {
                return true;
            } else {
                if (_myAirports.containsKey(start)) {
                    for (String route : _myAirports.get(start).getRoutes()) {
                        if (findRoute(route, destination)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
