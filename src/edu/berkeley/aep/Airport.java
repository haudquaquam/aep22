package edu.berkeley.aep;

import java.util.ArrayList;
// Understands an airport and its routes
public class Airport {

    public ArrayList<String> _myRoutes;
    public String _myName;

    public Airport(String myName, ArrayList<String> myRoutes) {
        _myName = myName;
        _myRoutes = myRoutes;
    }

    public boolean goesTo(String destination) {
        if (destination.equals(_myName) || _myRoutes.contains(destination)) {
            return true;
        }
        return false;
    }
}
