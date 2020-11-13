package com.epam.textparser.logic.sorter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Leaf;

import java.util.Comparator;

public class ComponentLexemeLengthComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {

        int firstLength = getLeafValueLength(firstComponent);
        int secondLength = getLeafValueLength(secondComponent);

        return firstLength - secondLength;
    }

    private int getLeafValueLength(Component component) {

        Leaf leaf = (Leaf) component;

        String value = leaf.getValue();

        return value.length();
    }

}