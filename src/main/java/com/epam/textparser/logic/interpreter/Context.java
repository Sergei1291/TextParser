package com.epam.textparser.logic.interpreter;

import java.util.ArrayDeque;

public class Context {

    private ArrayDeque<Integer> values = new ArrayDeque<>();

    public Context() {
    }

    //package private for tests
    Context(ArrayDeque<Integer> values) {

        this.values = values;

    }

    public Integer popValue() {

        return values.pop();
    }

    public void pushValue(Integer value) {

        values.push(value);

    }

}