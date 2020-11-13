package com.epam.textparser.logic.parser;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SentenceParserTest {

    private final static String SENTENCE = "    Word 23_17_+ second...";

    private final static Leaf LEAF_FIRST = Leaf.word("Word");
    private final static Leaf LEAF_SECOND = Leaf.expression("23_17_+");
    private final static Leaf LEAF_THIRD = Leaf.word("second...");

    private final static List<Component> COMPONENTS = Arrays.asList(LEAF_FIRST, LEAF_SECOND, LEAF_THIRD);
    private final static Composite COMPOSITE = new Composite(COMPONENTS);

    private SentenceParser sentenceParser = new SentenceParser();

    @Test
    public void testParseShouldCreateCompositeWhenSentence() {
        //when
        Composite actual = sentenceParser.parse(SENTENCE);
        //then
        Assert.assertEquals(COMPOSITE, actual);
    }

}