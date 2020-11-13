package com.epam.textparser.logic.interpreter;

import java.util.function.BinaryOperator;

public abstract class AbstractTerminalExpression extends AbstractExpression {

    public abstract BinaryOperator<Integer> createOperator();

    @Override
    public void interpret(Context context) {

        BinaryOperator<Integer> mathOperator = createOperator();

        int secondNumber = context.popValue();
        int firstNumber = context.popValue();

        int resultNumber = mathOperator.apply(firstNumber, secondNumber);

        context.pushValue(resultNumber);

    }

}