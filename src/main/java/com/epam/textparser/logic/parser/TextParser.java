package com.epam.textparser.logic.parser;

public class TextParser extends AbstractParser {

    private final static String PARAGRAPH_REGEX = "([ ]{3})([ ][^ ].+?[.!?]{1,3})+\n?";

    @Override
    public String getRegex() {

        return PARAGRAPH_REGEX;
    }

}