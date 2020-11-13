package com.epam.textparser.logic.interpreter;

import java.util.ArrayList;
import java.util.List;

public class ExpressionInterpreter {

    private final static String EXPRESSION_SEPARATOR = "[_]+";

    public String interpret(String expression) {

        List<AbstractExpression> abstractExpressions = parse(expression);

        int resultNumber = calculate(abstractExpressions);

        return String.valueOf(resultNumber);
    }

    private List<AbstractExpression> parse(String expression) {

        List<AbstractExpression> abstractExpressions = new ArrayList<>();

        String[] lexemes = expression.split(EXPRESSION_SEPARATOR);

        for (String lexeme : lexemes) {

            AbstractExpression abstractExpression;

            switch (lexeme) {
                case "+":
                    abstractExpression = new PlusTerminalExpression();
                    break;
                case "-":
                    abstractExpression = new MinusTerminalExpression();
                    break;
                case "*":
                    abstractExpression = new MultiplyTerminalExpression();
                    break;
                case "/":
                    abstractExpression = new DivideTerminalExpression();
                    break;
                default:
                    int number = Integer.valueOf(lexeme);
                    abstractExpression = new NonTerminalExpression(number);
            }

            abstractExpressions.add(abstractExpression);

        }

        return abstractExpressions;
    }

    private int calculate(List<AbstractExpression> abstractExpressions) {

        Context context = new Context();

        for (AbstractExpression abstractExpression : abstractExpressions) {
            abstractExpression.interpret(context);
        }

        return context.popValue();
    }

}