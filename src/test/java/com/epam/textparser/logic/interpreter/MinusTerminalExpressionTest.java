package com.epam.textparser.logic.interpreter;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MinusTerminalExpressionTest extends AbstractTerminalExpressionTest {

    private final static ArrayDeque<Integer> CONTEXT_VALUES = new ArrayDeque<>(Arrays.asList(3, 13));
    private final static Context CONTEXT = new Context(CONTEXT_VALUES);

    @Override
    public AbstractTerminalExpression create() {

        return new MinusTerminalExpression();
    }

    @Override
    public Context getDataContext() {

        return CONTEXT;
    }

}