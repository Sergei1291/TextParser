package com.epam.textparser.model;

import java.util.ArrayList;
import java.util.List;

public final class Leaf implements Component {

    private final String value;
    private final LeafType type;

    private Leaf(String value, LeafType type) {

        this.value = value;
        this.type = type;

    }

    public static Leaf word(String value) {

        return new Leaf(value, LeafType.WORD);
    }

    public static Leaf expression(String value) {

        return new Leaf(value, LeafType.EXPRESSION);
    }

    public String getValue() {

        return value;
    }

    public LeafType getType() {

        return type;
    }

    @Override
    public List<Component> getChildren() {

        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Leaf leaf = (Leaf) o;

        if ((value != null) ? (!value.equals(leaf.value)) : (leaf.value != null)) {
            return false;
        }
        return type == leaf.type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = value.hashCode();
        result = prime * result + type.hashCode();
        return result;
    }

}