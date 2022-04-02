package edu.berkeley.aep;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

// Tests Airport and RouteFinder classes
public class AirportTest {

    Airport A = new Airport("A");
    Airport B = new Airport("B", "C", "A");
    Airport C = new Airport("C", "E", "E", "D");
    Airport D = new Airport("D", "E");
    Airport E = new Airport("E", "B");
    Airport G = new Airport("G");
    Airport H = new Airport("H", "B");

    RouteFinder finder = new RouteFinder(A, B, C, D, E, G, H);

    @Test
    public void multiStringConstructorShouldWork() {
        Airport test = new Airport("Test", "Dest 1", "Dest 2");
        String[] correct = {"Dest 1", "Dest 2"};
        assertArrayEquals(correct, test.getRoutes().toArray(new String[0]));
    }

    @Test
    public void multiAirplaneAddRouteShouldWork() {
        Airport test = new Airport("Test");
        test.addRoute("A", "B", "C");
        String[] correctRoutes = {"A", "B", "C"};
        assertArrayEquals(correctRoutes, test.getRoutes().toArray(new String[0]));
    }

    @Test
    public void aToHShouldNotBeValidRoute() {
        assertFalse(finder.find("A", "H"));
    }

    @Test
    public void cToCShouldBeValidRoute() {
        assertTrue(finder.find("C", "C"));
    }

    @Test
    public void bToCShouldBeValidRoute() {
        assertTrue(finder.find("B", "C"));
    }

    @Test
    public void bToDShouldBeValidRoute() {
        RouteFinder bToDRouteFinder = new RouteFinder(B, C);
        assertTrue(bToDRouteFinder.find("B", "D"));
    }

    @Test
    public void bToHShouldNotBeValidRoute() {
        assertFalse(finder.find("B", "H"));
    }
}
