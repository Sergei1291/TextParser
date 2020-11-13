package com.epam.textparser.logic.interpreter;

import java.util.function.BinaryOperator;

public class DivideTerminalExpression extends AbstractTerminalExpression {

    @Override
    public BinaryOperator<Integer> createOperator() {

        return (firstNumber, secondNumber) -> firstNumber / secondNumber;
    }

}