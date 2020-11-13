package com.epam.textparser.logic.parser;

public class ParagraphParser extends AbstractParser {

    private final static String SENTENCE_REGEX = "[^.!?]+[.!?]{1,3}";

    @Override
    public String getRegex() {

        return SENTENCE_REGEX;
    }

}