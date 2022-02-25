package edu.berkeley.aep;

import java.util.HashMap;
import java.util.Map;

//compare length in different units
public class Measurement {
    private final static Map<String,Integer> conversions = new HashMap<>(){
        {
            put("inch",1);
            put("foot",12);
            put("yard",12*3);
            put("mile",12*3*1760);
        }
    };
    private final String unit;
    private final int value;
    public Measurement(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public int convertToInches(){
        if (conversions.containsKey(unit)) {
            return value * conversions.get(unit);
        }
        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Measurement)) return false;
        return convertToInches() == ((Measurement) other).convertToInches();
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(convertToInches());
    }
}
