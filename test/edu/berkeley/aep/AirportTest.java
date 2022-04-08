package edu.berkeley.aep;


import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// Tests Airport and RouteFinder classes
public class AirportTest {

    Airport H = new Airport("H", "B");
    Airport B = new Airport("B", "A", "C");
    Airport C = new Airport("C", "D", "E");
    Airport D = new Airport("D", "E");
    Airport E = new Airport("E", "B");
    Airport A = new Airport("A", "F");
    Airport F = new Airport("F");
    Airport G = new Airport("G");
    RouteFinder fullMap = new RouteFinder(H, B, A, F, G, C, E, D);

    @Test
    public void cToCShouldBeValidRoute() {
        Airport C = new Airport("C");
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void cToEShouldBeValidRoute() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        Airport C = new Airport("C", String.valueOf(cRoutes));
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void addRouteFunctionShouldWork() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        Airport C = new Airport("C", "E");
        cRoutes.add("F");
        C.add("F");
        for (String dest : cRoutes) {
            assertTrue(C.goesTo(dest));
        }
    }

    @Test
    public void multipleAddRouteFunctionShouldWork() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        cRoutes.add("K");
        cRoutes.add("P");
        cRoutes.add("F");
        Airport C = new Airport("C");
        C.add("F", "K", "P", "E");
        for (String dest : cRoutes) {
            assertTrue(C.goesTo(dest));
        }
    }

    @Test
    public void routeFinderShouldFindRouteFromCToC() {
        Airport C = new Airport("C");
        RouteFinder finder = new RouteFinder(C);
        assertTrue(finder.findRoute("C", "C"));
    }

    @Test
    public void findRouteThroughTwoAirports() {
        Airport C = new Airport("C", "D");
        Airport D = new Airport("D", "E");
        RouteFinder finder = new RouteFinder(C, D);
        assertTrue(finder.findRoute("C", "E"));
    }

    @Test
    public void findRouteThroughManyAirports() {
        Airport A = new Airport("A", "B");
        Airport B = new Airport("B", "C");
        Airport C = new Airport("C", "D");
        Airport D = new Airport("D", "E");
        Airport E = new Airport("E", "F");
        RouteFinder finder = new RouteFinder(A, B, C, D, E);
        assertTrue(finder.findRoute("A", "F"));
    }

    @Test
    public void invalidRoutesShouldNotWork() {
        Airport A = new Airport("A", "B");
        Airport B = new Airport("B", "C");
        Airport C = new Airport("C", "D");
        Airport D = new Airport("D", "E");
        Airport E = new Airport("E", "F");
        RouteFinder finder = new RouteFinder(A, B, C, D, E);
        assertFalse(finder.findRoute("F", "A"));
        assertFalse(finder.findRoute("P", "K"));
        assertFalse(finder.findRoute("L", "L"));
    }

    @Test
    public void airportInCycleShouldNotSearchForever() {
        Airport A = new Airport("A");
        Airport B = new Airport("B", "C", "A");
        Airport C = new Airport("C", "E", "E", "D");
        Airport D = new Airport("D", "E");
        Airport E = new Airport("E", "B");
        Airport G = new Airport("G");
        Airport H = new Airport("H", "B");
        RouteFinder finder = new RouteFinder(A, B, C, D, E, G, H);
        assertFalse(finder.findRoute("B", "G"));
    }

    @Test
    public void shouldOnlyAddEachAirportOnceIntoRouteFinder() {
        Airport C = new Airport("C", "E", "E", "D");
        RouteFinder finder = new RouteFinder(C, C, C);
        assertEquals(1, finder.numAirports());
    }

    @Test
    public void fullMapTest() {
        assertTrue(fullMap.findRoute("H", "F"));
        assertTrue(fullMap.findRoute("H", "E"));
        assertTrue(fullMap.findRoute("B", "F"));
        assertTrue(fullMap.findRoute("G", "G"));
        assertTrue(fullMap.findRoute("E", "F"));
        assertTrue(fullMap.findRoute("C", "F"));
        assertTrue(fullMap.findRoute("D", "C"));

        assertFalse(fullMap.findRoute("G", "A"));
        assertFalse(fullMap.findRoute("F", "D"));
        assertFalse(fullMap.findRoute("H", "G"));
    }

    @Test
    public void hToHShouldBeZeroHops() {
        assertEquals(0, fullMap.countHops("H", "H"));
    }

    @Test
    public void bToFShouldBeTwoHops() {
        assertEquals(2, fullMap.countHops("B", "F"));
    }

    @Test
    public void cToBShouldBeTwoOrThreeHops() {
        assertEquals(2, fullMap.countHops("C", "B"));
    }

    @Test
    public void aToFShouldBeOneHops() {
        assertEquals(1, fullMap.countHops("A", "F"));
    }

    @Test
    public void hToDShouldBeThreeHops() {
        assertEquals(3, fullMap.countHops("H", "D"));
    }

    @Test
    public void hToGShouldBeInvalid() {
        assertEquals(RouteFinder.INVALID_ROUTE, fullMap.countHops("H", "G"));
    }



}
