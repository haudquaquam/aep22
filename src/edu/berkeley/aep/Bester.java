package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Understands the "best" quantity of a list of quantities
public final class Bester {
    private final List<Bestable> _quantities = new ArrayList<>();
    private Bestable _bestQuantity;

    public Bester(Bestable... quantities) {
        if (quantities == null) throw new NullPointerException();
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

    public Bestable bestQuantity() {
        return _bestQuantity;
    }

}
