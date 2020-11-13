package com.epam.textparser.logic.interpreter;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MultiplyTerminalExpressionTest extends AbstractTerminalExpressionTest {

    private final static ArrayDeque<Integer> CONTEXT_VALUES = new ArrayDeque<>(Arrays.asList(2, 5));
    private final static Context CONTEXT = new Context(CONTEXT_VALUES);

    @Override
    public AbstractTerminalExpression create() {

        return new MultiplyTerminalExpression();
    }

    @Override
    public Context getDataContext() {

        return CONTEXT;
    }

}