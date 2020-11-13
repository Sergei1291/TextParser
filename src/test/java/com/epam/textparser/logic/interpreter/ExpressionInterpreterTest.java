package com.epam.textparser.logic.interpreter;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionInterpreterTest {

    private final static String EXPRESSION = "86_2_/_3_-_10_+_2_*";

    private ExpressionInterpreter expressionInterpreter = new ExpressionInterpreter();

    @Test
    public void test() {
        //when
        String actual = expressionInterpreter.interpret(EXPRESSION);
        //then
        Assert.assertEquals("100", actual);
    }

}