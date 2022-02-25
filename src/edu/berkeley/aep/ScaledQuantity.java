package edu.berkeley.aep;

public class ScaledQuantity {
    protected final int amount;
    protected final Unit unit;

    public ScaledQuantity(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public boolean betterThan(ScaledQuantity other) { // strictly looks at magnitude, greater magnitude is "better"
        if (this.amount > other.convert(this.unit)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity)) return false;
        ScaledQuantity otherQuantity = (ScaledQuantity) other;
        return otherQuantity.convert(this.unit) == amount;
    }

    private int convert(Unit desiredUnit) {
        if (this.unit.isComparableTo(desiredUnit)) {
            return this.unit.convertTo(desiredUnit, amount);
        } else {
            throw new RuntimeException("These units are not comparable to each other!");
        }

    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }
}
