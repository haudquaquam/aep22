package edu.berkeley.aep;


import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

// Tests Airport and RouteFinder classes
public class AirportTest {
    @Test
    public void cToCShouldBeValidRoute() {
        Airport C = new Airport("C", null);
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void cToEShouldBeValidRoute() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("E");
        Airport C = new Airport("C", cRoutes);

    }

}
