package com.epam.textparser.model;

import java.util.List;

public interface Component {

    List<Component> getChildren();

}