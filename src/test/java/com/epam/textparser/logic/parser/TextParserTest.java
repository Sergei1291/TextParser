package com.epam.textparser.logic.parser;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TextParserTest {

    private final static String TEXT = "    First. asd...\n    Second - 2()!";

    private final static Leaf LEAF_FIRST = Leaf.word("    First. asd...\n");
    private final static Leaf LEAF_SECOND = Leaf.word("    Second - 2()!");

    private final static List<Component> COMPONENTS = Arrays.asList(LEAF_FIRST, LEAF_SECOND);
    private final static Composite COMPOSITE = new Composite(COMPONENTS);

    private TextParser textParser = new TextParser();

    @Test
    public void testParseShouldCreateCompositeWhenText() {
        //when
        Composite actual = textParser.parse(TEXT);
        //then
        Assert.assertEquals(COMPOSITE, actual);
    }

}