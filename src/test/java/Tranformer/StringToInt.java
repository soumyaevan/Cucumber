package Tranformer;

import cucumber.api.Transformer;

public class StringToInt extends Transformer<Integer> {

    @Override
    public Integer transform(String salary) {
        return salary.length();
    }
}
