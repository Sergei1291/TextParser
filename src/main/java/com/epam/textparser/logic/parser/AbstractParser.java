package com.epam.textparser.logic.parser;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractParser implements Parser {

    private final static String EXPRESSION = "[-]?\\d+([_]\\d+[_][/*-+])+";

    private Parser successor;

    public void setSuccessor(Parser parser) {

        successor = parser;

    }

    public abstract String getRegex();

    //Recursion
    @Override
    public Composite parse(String data) {

        List<String> parts = split(data);
        List<Component> components = new ArrayList<>();

        for (String part : parts) {

            Component component;

            if (successor != null) {
                component = successor.parse(part);
            } else {
                component = createLeaf(part);
            }

            components.add(component);

        }

        return new Composite(components);
    }

    private List<String> split(String data) {

        String parserRegex = this.getRegex();

        Pattern pattern = Pattern.compile(parserRegex);
        Matcher matcher = pattern.matcher(data);

        List<String> parts = new ArrayList<>();

        while (matcher.find()) {
            String part = matcher.group(0);
            parts.add(part);
        }

        return parts;
    }

    private Leaf createLeaf(String value) {

        if (value.matches(EXPRESSION)) {
            return Leaf.expression(value);
        }

        return Leaf.word(value);
    }

}