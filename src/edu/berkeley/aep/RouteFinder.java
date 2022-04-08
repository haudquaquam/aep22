package edu.berkeley.aep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Understands ways to get from one airport to another
public class RouteFinder {

    private final List<Airport> myAirports = new ArrayList<>();
    private int hopCount = 0;
    private boolean multipleNeighbors = false;

    public RouteFinder(Airport... airports) {
        for (var airport: airports) {
            myAirports.add(airport);
        }
    }


    public boolean findRoute(String start, String destination) {
        List<String> availableList = new ArrayList<>();
        hopCount = 0;
        return findHelper(start, destination, availableList);
    }

    private int findHelper(String start, String destination, List<String> availableList) {
        /*if (validAirports.contains(start)) {
            if (start == null) {
                hopCount = INVALID_ROUTE;
                return false;
            } else if (start.equals(destination)) {
                hopCount = 0;
                return true;
            } else if (myAirports.isEmpty() || !(myAirports.containsKey(start))) {
                hopCount = INVALID_ROUTE;
                return false;
            } else {
                Airport startAirport = myAirports.get(start);

                hopCount = Math.min(findHelper(startAirport.name(), );
            }

            for (String destAirport : startAirport.getRoutes()) {
                if (startAirport.getRoutes().size() > 1)
                    multipleNeighbors = true;

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
        hopCount = INVALID_ROUTE;
        return false;
        return hopCount;*/
        boolean visited[] = new boolean[myAirports.size()];

    }

    public int numAirports() {
        return myAirports.size();
    }

    public int countHops(String start, String destination) {
        findRoute(start, destination);
        return hopCount;
    }

    public static int INVALID_ROUTE = -1;
}
