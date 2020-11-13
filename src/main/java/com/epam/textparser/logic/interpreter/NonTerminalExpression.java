package com.epam.textparser.logic.interpreter;

public class NonTerminalExpression extends AbstractExpression {

    private int number;

    public NonTerminalExpression(int number) {

        this.number = number;

    }

    @Override
    public void interpret(Context context) {

        context.pushValue(number);

    }

}