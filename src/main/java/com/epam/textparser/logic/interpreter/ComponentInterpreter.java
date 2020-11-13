package com.epam.textparser.logic.interpreter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import com.epam.textparser.model.LeafType;

import java.util.ArrayList;
import java.util.List;

public class ComponentInterpreter {

    private final ExpressionInterpreter expressionInterpreter;

    public ComponentInterpreter(ExpressionInterpreter expressionInterpreter) {

        this.expressionInterpreter = expressionInterpreter;

    }

    //Recursion
    public Component interpretExpressions(Component component) {

        List<Component> children = component.getChildren();

        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            return interpret(leaf);
        }

        List<Component> components = new ArrayList<>();

        for (Component child : children) {

            Component interpretedChild = interpretExpressions(child);
            components.add(interpretedChild);

        }

        return new Composite(components);
    }

    private Leaf interpret(Leaf leaf) {

        LeafType type = leaf.getType();
        String value = leaf.getValue();

        if (type == LeafType.WORD) {

            return leaf;
        }

        String word = expressionInterpreter.interpret(value);

        return Leaf.word(word);
    }

}