package com.epam.textparser.logic.interpreter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ComponentInterpreterTest {

    private final static String mock = "MOCK";

    @Test
    public void testInterpretExpressionsShouldCorrectComponentWhenDataComponent() {
        //given
        ExpressionInterpreter expressionInterpreter = Mockito.mock(ExpressionInterpreter.class);
        when(expressionInterpreter.interpret(anyString())).thenReturn(mock);
        ComponentInterpreter componentInterpreter = new ComponentInterpreter(expressionInterpreter);
        Composite paragraph = createDataComponent();
        //when
        Component actual = componentInterpreter.interpretExpressions(paragraph);
        Composite actualComposite = (Composite) actual;
        //then
        Composite expected = createExpectedComponent();
        Assert.assertEquals(expected, actualComposite);
    }

    private Composite createDataComponent() {

        Leaf firstLeaf = Leaf.word("first");
        Leaf secondLeaf = Leaf.expression("sss");
        Leaf thirdLeaf = Leaf.expression("qwerty");

        List<Component> firstLeaves = Arrays.asList(firstLeaf, secondLeaf);
        Composite firstSentence = new Composite(firstLeaves);
        List<Component> secondLeaves = Arrays.asList(thirdLeaf, firstLeaf);
        Composite secondSentence = new Composite(secondLeaves);

        List<Component> sentences = Arrays.asList(firstSentence, secondSentence);

        return new Composite(sentences);
    }

    private Composite createExpectedComponent() {
        Leaf firstLeaf = Leaf.word("first");
        Leaf secondLeaf = Leaf.word(mock);
        Leaf thirdLeaf = Leaf.word(mock);

        List<Component> firstLeaves = Arrays.asList(firstLeaf, secondLeaf);
        Composite firstSentence = new Composite(firstLeaves);
        List<Component> secondLeaves = Arrays.asList(thirdLeaf, firstLeaf);
        Composite secondSentence = new Composite(secondLeaves);

        List<Component> sentences = Arrays.asList(firstSentence, secondSentence);

        return new Composite(sentences);
    }

}