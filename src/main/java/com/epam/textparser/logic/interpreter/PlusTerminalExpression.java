package com.epam.textparser.logic.interpreter;

import java.util.function.BinaryOperator;

public class PlusTerminalExpression extends AbstractTerminalExpression {

    @Override
    public BinaryOperator<Integer> createOperator() {

        return (firstNumber, secondNumber) -> firstNumber + secondNumber;
    }

}