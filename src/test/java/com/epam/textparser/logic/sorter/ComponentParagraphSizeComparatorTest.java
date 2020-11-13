package com.epam.textparser.logic.sorter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;
import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ComponentParagraphSizeComparatorTest {

    private final static Leaf SENTENCE = Leaf.word("");

    private final static List<Component> FIRST_SENTENCES = Arrays.asList(SENTENCE);
    private final static Composite FIRST_PARAGRAPH = new Composite(FIRST_SENTENCES);

    private final static List<Component> SECOND_SENTENCES = Arrays.asList(SENTENCE, SENTENCE);
    private final static Composite SECOND_PARAGRAPH = new Composite(SECOND_SENTENCES);

    private final static List<Component> THIRD_SENTENCES = Arrays.asList(SENTENCE);
    private final static Composite THIRD_PARAGRAPH = new Composite(THIRD_SENTENCES);

    private final ComponentParagraphSizeComparator comparator = new ComponentParagraphSizeComparator();

    @Test
    public void testCompareShouldPositiveWhenSizeSecondMoreSizeFirst() {
        //when
        int actual = comparator.compare(SECOND_PARAGRAPH, FIRST_PARAGRAPH);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldNegativeWhenSizeFirstLessSizeSecond() {
        //when
        int actual = comparator.compare(FIRST_PARAGRAPH, SECOND_PARAGRAPH);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldZeroWhenSizeThirdEqualSizeFirst() {
        //when
        int actual = comparator.compare(THIRD_PARAGRAPH, FIRST_PARAGRAPH);
        //then
        Assert.assertTrue(actual == 0);
    }

}