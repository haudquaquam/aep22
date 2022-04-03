package edu.berkeley.aep;


import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// Tests Airport and RouteFinder classes
public class AirportTest {
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

}
