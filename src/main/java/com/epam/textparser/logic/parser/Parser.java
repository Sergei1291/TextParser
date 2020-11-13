package com.epam.textparser.logic.parser;

import com.epam.textparser.model.Composite;

public interface Parser {

    Composite parse(String data);

}