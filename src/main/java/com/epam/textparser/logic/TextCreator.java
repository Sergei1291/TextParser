package com.epam.textparser.logic;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Leaf;

import java.util.List;

public class TextCreator {

    private final static String LEXEMES_SEPARATOR = " ";

    //Recursion
    public String create(Component component) {

        List<Component> children = component.getChildren();

        if (children.isEmpty()) {
            Leaf leaf = (Leaf) component;
            String value = leaf.getValue();
            return LEXEMES_SEPARATOR.concat(value);
        }

        StringBuilder textBuilder = new StringBuilder();

        for (Component child : children) {

            String createdChild = create(child);
            textBuilder.append(createdChild);

        }

        return new String(textBuilder);
    }

}