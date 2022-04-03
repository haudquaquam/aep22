package edu.berkeley.aep;
import java.util.ArrayList;
import java.util.Arrays;
// Understands an airport and its routes
public class Airport {

    private final String _myName;
    private final ArrayList<String> _myRoutes;

    public Airport(String myName, String... myRoutes) {
        _myName = myName;
        _myRoutes = new ArrayList<>();
        _myRoutes.addAll(Arrays.asList(myRoutes));
    }

    public String name() {
        return _myName;
    }

    public ArrayList<String> getRoutes() {
        return _myRoutes;
    }

    public void add(String... destination) {
        _myRoutes.addAll(Arrays.asList(destination));
    }

    public boolean goesTo(String destination) {
        return destination.equals(_myName) || _myRoutes.contains(destination);
    }

}
