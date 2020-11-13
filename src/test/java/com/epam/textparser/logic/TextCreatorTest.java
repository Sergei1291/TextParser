package com.epam.textparser.logic;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TextCreatorTest {

    private final static Leaf FIRST_LEXEME = Leaf.word("A");
    private final static Leaf SECOND_LEXEME = Leaf.word("B");

    private final static List<Component> FIRST_COMPONENTS = Arrays.asList(FIRST_LEXEME, SECOND_LEXEME);
    private final static Composite FIRST_SENTENCE = new Composite(FIRST_COMPONENTS);

    private final static List<Component> SECOND_COMPONENTS = Arrays.asList(SECOND_LEXEME, SECOND_LEXEME);
    private final static Composite SECOND_SENTENCE = new Composite(SECOND_COMPONENTS);

    private final static List<Component> SENTENCES = Arrays.asList(FIRST_SENTENCE, SECOND_SENTENCE);
    private final static Composite PARAGRAPH = new Composite(SENTENCES);

    private final static List<Component> PARAGRAPHS = Arrays.asList(PARAGRAPH);
    private final static Composite TEXT = new Composite(PARAGRAPHS);

    private final TextCreator textCreator = new TextCreator();

    @Test
    public void testCreateShouldTextWhenCompositeText() {
        //when
        String actual = textCreator.create(TEXT);
        //then
        Assert.assertEquals(" A B B B", actual);
    }

}