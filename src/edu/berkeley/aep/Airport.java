package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Arrays;

// Understands an airport and its routes
public class Airport {

    private final String _myName;

    public Airport(String myName) {
        _myName = myName;
    }

    public boolean goesTo(String destination) {
        return _myName == destination;
    }
}
