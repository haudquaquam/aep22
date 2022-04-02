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

    public boolean find(String start, String destination) {
        ArrayList<String> availableList = new ArrayList<>();
        /*availableList.addAll(_myAirports.keySet());*/
        return findHelper(start, destination, availableList);
    }

    private boolean findHelper(String start, String destination, ArrayList<String> availableList) {
        if (start == null) {
            return false;
        } else if (start.equals(destination)) {
            return true;
        } else if (_myAirports.isEmpty() || !(_myAirports.containsKey(start))) {
            return false;
        }
        Airport startAirport = _myAirports.get(start);

        for (String destAirport : startAirport.getRoutes()) {
            if (destAirport.equals(destination)) {
                return true;
            } else if (!availableList.contains(destAirport)) {
                availableList.add(destAirport);
                if (findHelper(destAirport, destination, availableList)) {
                    return true;
                }
            }
        }
        return false;
    }
}
