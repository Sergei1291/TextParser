package com.epam.textparser.logic.parser;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParagraphParserTest {

    private final static String PARAGRAPH = "    First. second...";

    private final static Leaf LEAF_FIRST = Leaf.word("    First.");
    private final static Leaf LEAF_SECOND = Leaf.word(" second...");

    private final static List<Component> LEAVES = Arrays.asList(LEAF_FIRST, LEAF_SECOND);
    private final static Composite COMPOSITE = new Composite(LEAVES);

    @Test
    public void testParseShouldCreateCompositeWhenParagraphSuccessorNull() {
        //given
        ParagraphParser paragraphParser = new ParagraphParser();
        //when
        Composite actual = paragraphParser.parse(PARAGRAPH);
        //then
        Assert.assertEquals(COMPOSITE, actual);
    }

}