package edu.berkeley.aep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Understands ways to get from one airport to another
public class RouteFinder {

    private final Map<String, Airport> myAirports = new HashMap<>();
    private final List<String> validAirports = new ArrayList<>();
    private int hopCount = 0;

    public RouteFinder(Airport... airports) {
        for (var airport: airports) {
            myAirports.put(airport.name(), airport);
            validAirports.add(airport.name());
            validAirports.addAll(airport.getRoutes());
        }
    }


    public boolean findRoute(String start, String destination) {
        List<String> availableList = new ArrayList<>();
        hopCount=0;
        return findHelper(start, destination, availableList);
    }

    private boolean findHelper(String start, String destination, List<String> availableList) {
        if (validAirports.contains(start)) {
            if (start == null) {
                hopCount = 0;
                return false;
            } else if (start.equals(destination)) {
                return true;
            } else if (myAirports.isEmpty() || !(myAirports.containsKey(start))) {
                hopCount = 0;
                return false;
            }
            Airport startAirport = myAirports.get(start);

            for (String destAirport : startAirport.getRoutes()) {
                if (destAirport.equals(destination)) {
                    hopCount++;
                    return true;
                } else if (!availableList.contains(destAirport)) {
                    availableList.add(destAirport);
                    if (findHelper(destAirport, destination, availableList)) {
                        hopCount++;
                        return true;
                    }
                }
            }
        }
        hopCount = 0;
        return false;
    }

    public int numAirports() {
        return myAirports.size();
    }

    public int countHops(String start, String destination) {
        findRoute(start, destination);
        return hopCount;
    }
}
