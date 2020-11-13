package com.epam.textparser.logic.sorter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;

import java.util.Comparator;
import java.util.List;

public class ComponentParagraphSizeComparator implements Comparator<Component> {

    @Override
    public int compare(Component firstComponent, Component secondComponent) {

        int firstSize = getChildrenSize(firstComponent);
        int secondSize = getChildrenSize(secondComponent);

        return firstSize - secondSize;
    }

    private int getChildrenSize(Component component) {

        Composite composite = (Composite) component;

        List<Component> children = composite.getChildren();

        return children.size();
    }

}