package edu.berkeley.aep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Understands the "best" quantity of a list of quantities
public final class BestQuantity {
    private final List<ScaledQuantity> _quantities = new ArrayList<>();
    private ScaledQuantity _bestQuantity;

    public BestQuantity(ScaledQuantity... quantities) {
        _quantities.addAll(Arrays.asList(quantities));
        findBest();
    }

    private void findBest() {
        while (_quantities.size() > 1) {
            if (_quantities.get(0).betterThan(_quantities.get(1))) {
                _quantities.remove(1);
            } else {
                _quantities.remove(0);
            }
        }
        _bestQuantity =  _quantities.get(0);
    }

    public ScaledQuantity bestQuantity() {
        return _bestQuantity;
    }

}
