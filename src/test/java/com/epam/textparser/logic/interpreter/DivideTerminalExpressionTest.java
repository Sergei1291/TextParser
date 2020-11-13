package com.epam.textparser.logic.interpreter;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DivideTerminalExpressionTest extends AbstractTerminalExpressionTest {

    private final static ArrayDeque<Integer> CONTEXT_VALUES = new ArrayDeque<>(Arrays.asList(2, 20));
    private final static Context CONTEXT = new Context(CONTEXT_VALUES);

    @Override
    public AbstractTerminalExpression create() {

        return new DivideTerminalExpression();
    }

    @Override
    public Context getDataContext() {

        return CONTEXT;
    }

}