package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Arrays;

// Understands an airport and its routes
public class Airport {

    private ArrayList<String> _myRoutes;
    private final String _myName;

    public Airport(String myName) {
        _myName = myName;
        _myRoutes = new ArrayList<>();
    }

    public Airport(String myName, String... destinations) {
        this(myName);
        addRoute(destinations);
    }

    public void addRoute(String... destinations) {
        _myRoutes.addAll(Arrays.asList(destinations));
    }

    public String name() {
        return _myName;
    }

    public ArrayList<String> getRoutes() {
        return _myRoutes;
    }

    /*public boolean goesTo(String destination) {
        if (destination.equals(_myName) || _myRoutes.contains(destination)) {
            return true;
        }
        return false;
    }*/
}
