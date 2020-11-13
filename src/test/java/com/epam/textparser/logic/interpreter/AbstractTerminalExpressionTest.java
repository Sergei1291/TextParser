package com.epam.textparser.logic.interpreter;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractTerminalExpressionTest {

    public abstract AbstractTerminalExpression create();

    public abstract Context getDataContext();

    @Test
    public void testInterpretShouldTrueWhenContext() {
        //given
        AbstractTerminalExpression terminalExpression = create();
        Context context = getDataContext();
        //when
        terminalExpression.interpret(context);
        //then
        Assert.assertTrue(context.popValue() == 10);
    }

}