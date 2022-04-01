package edu.berkeley.aep;


import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AirportTest {

    @Test
    public void aToHShouldNotBeValidRoute() {
        ArrayList<String> aRoutes = new ArrayList<>();
        Airport A = new Airport("A", aRoutes);
        assertFalse(A.goesTo("H"));
    }

    @Test
    public void cToCShouldBeValidRoute() {
        ArrayList<String> cRoutes = new ArrayList<>();
        cRoutes.add("D");
        cRoutes.add("E");
        cRoutes.add("E");
        Airport C = new Airport("C", cRoutes);
        assertTrue(C.goesTo("C"));
    }

    @Test
    public void bToCShouldBeValidRoute() {
        ArrayList<String> bRoutes = new ArrayList<>();
        bRoutes.add("A");
        bRoutes.add("C");
        Airport B = new Airport("B", bRoutes);
        assertTrue(B.goesTo("C"));
    }

    @Test
    public void bToDShouldBeValidRoute() {
        ArrayList<String> bRoutes = new ArrayList<>();
        ArrayList<String> cRoutes = new ArrayList<>();

        bRoutes.add("A");
        bRoutes.add("C");

        cRoutes.add("D");
        cRoutes.add("E");
        cRoutes.add("E");

        Airport B = new Airport("B", bRoutes);
        Airport C = new Airport("C", cRoutes);

        RouteFinder bToDRouteFinder = new RouteFinder(B, C);

        assertTrue(bToDRouteFinder.find("B", "D"));
    }
}
