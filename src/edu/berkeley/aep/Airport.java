package edu.berkeley.aep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// Understands an airport and its routes
public class Airport {

    private final String _myName;
    private ArrayList<String> _myRoutes;

    public Airport(String myName, ArrayList<String> myRoutes) {
        _myName = myName;
        _myRoutes = myRoutes;
    }

    public boolean goesTo(String destination) {
        return _myName == destination || _myRoutes.contains(destination);
    }
}
