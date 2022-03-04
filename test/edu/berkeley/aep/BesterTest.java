package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BesterTest {
    @Test
    public void bestQuantityShouldBeTwelveFeet() {

        var twelveFeet = new ArithmeticQuantity(12, Unit.FOOT);
        var thirteenInches = new ArithmeticQuantity(13, Unit.INCH);
        var threeYards = new ArithmeticQuantity(3, Unit.YARD);
        var twoFeet = new ArithmeticQuantity(2, Unit.FOOT);

        var findBest = new Bester(twelveFeet, thirteenInches, threeYards, twoFeet);

        assertEquals(twelveFeet, findBest.bestQuantity());
    }

    @Test(expected = RuntimeException.class)
    public void incomparableUnitsShouldThrowException() {
        var twelveFeet = new ArithmeticQuantity(12, Unit.FOOT);
        var thirteenInches = new ArithmeticQuantity(13, Unit.INCH);
        var twoOunces = new ArithmeticQuantity(2, Unit.OZ);

        var findBest = new Bester(twelveFeet, thirteenInches, twoOunces);
        findBest.bestQuantity();
    }

    @Test
    public void bestChanceShouldBeOneOutOfOne() {
        var oneOfOne = new Chance(1 / 1);
        var twoOfThree = new Chance(2 / 3);
        var dieRoll = new Chance(1 / 6);

        var findBest = new Bester(oneOfOne, twoOfThree, dieRoll);
        assertEquals(oneOfOne, findBest.bestQuantity());
    }

    @Test(expected = NullPointerException.class)
    public void nullArgumentShouldThrowException() {
        var findBest = new Bester(null);
    }

    @Test
    public void equalValuesTest() {
        var zeroCelsius = new ScaledQuantity(0, Unit.CELSIUS);
        var thirtyTwoFahrenheit = new ScaledQuantity(32, Unit.FAHRENHEIT);

        var findBest = new Bester(zeroCelsius, thirtyTwoFahrenheit);
        assertEquals(thirtyTwoFahrenheit, findBest.bestQuantity());
        assertEquals(zeroCelsius, findBest.bestQuantity());
    }
}
