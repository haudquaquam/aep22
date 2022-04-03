package edu.berkeley.aep;
import java.util.ArrayList;
import java.util.HashMap;
// Understands ways to get from one airport to another
public class RouteFinder {

    private final HashMap<String, Airport> _myAirports = new HashMap<>();
    private final ArrayList<String> _validAirports = new ArrayList<>();

    public RouteFinder(Airport... airports) {
        for (Airport airport : airports) {
            _myAirports.put(airport.name(), airport);
            _validAirports.add(airport.name());
            _validAirports.addAll(airport.getRoutes());
        }
    }


    public boolean findRoute(String start, String destination) {
        ArrayList<String> availableList = new ArrayList<>();
        return findHelper(start, destination, availableList);
    }

    private boolean findHelper(String start, String destination, ArrayList<String> availableList) {
        if (_validAirports.contains(start)) {
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
        }
        return false;
    }

    public int numAirports() {
        return _myAirports.size();
    }

}
