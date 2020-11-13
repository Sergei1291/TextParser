package com.epam.textparser.logic.parser;

public class SentenceParser extends AbstractParser {

    private final static String LEXEME_REGEX = "([^ ]+)";

    @Override
    public String getRegex() {

        return LEXEME_REGEX;
    }

}