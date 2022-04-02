package edu.berkeley.aep;


import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// Tests Airport and RouteFinder classes
public class AirportTest {
    @Test
    public void cToCShouldBeValidRoute() {
        Airport C = new Airport("C", new ArrayList<>());
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void cToEShouldBeValidRoute() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        Airport C = new Airport("C", cRoutes);
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void addRouteFunctionShouldWork() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        Airport C = new Airport("C", cRoutes);
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
        Airport C = new Airport("C", cRoutes);
        cRoutes.add("F");
        C.add("F", "K", "P");
        for (String dest : cRoutes) {
            assertTrue(C.goesTo(dest));
        }
    }

    @Test
    public void routeFinderShouldFindRouteFromCToC() {
        Airport C = new Airport("C", new ArrayList<>());
        RouteFinder finder = new RouteFinder(C);
        assertTrue(finder.findRoute("C", "C"));
    }

}
