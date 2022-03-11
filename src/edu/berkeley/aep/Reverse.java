package edu.berkeley.aep;

public class Reverse {
    private final String _string;
    private String _result;

    public Reverse(String string) {
        _string = string;
        _result = recursiveReverse(_string); // initial question
    }

    private String recursiveReverse(String workingString) {
        if (workingString.length() <= 1) { // end condition
            return workingString;
        } else { // recursive question
            return recursiveReverse(workingString.substring(1)) + workingString.substring(0, 1);
        }
    }

    public String result() {
        return _result;
    }
}
