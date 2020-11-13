package com.epam.textparser.logic.parser;

public class ChainParserBuilder {

    public Parser build() {

        SentenceParser sentenceParser = new SentenceParser();
        ParagraphParser paragraphParser = new ParagraphParser();

        paragraphParser.setSuccessor(sentenceParser);

        TextParser textParser = new TextParser();

        textParser.setSuccessor(paragraphParser);

        return textParser;
    }

}