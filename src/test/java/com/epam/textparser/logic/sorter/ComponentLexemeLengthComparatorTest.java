package com.epam.textparser.logic.sorter;

import com.epam.textparser.model.Leaf;
import org.junit.Assert;
import org.junit.Test;

public class ComponentLexemeLengthComparatorTest {

    private final static Leaf FIRST_COMPONENT = Leaf.word("lengthOne");
    private final static Leaf SECOND_COMPONENT = Leaf.word("lengthTwo");
    private final static Leaf THIRD_COMPONENT = Leaf.word("lengthThree");

    private final ComponentLexemeLengthComparator comparator = new ComponentLexemeLengthComparator();

    @Test
    public void testCompareShouldPositiveWhenLengthThirdMoreLengthFirst() {
        //when
        int actual = comparator.compare(THIRD_COMPONENT, FIRST_COMPONENT);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldNegativeWhenLengthFirstLessLengthThird() {
        //when
        int actual = comparator.compare(FIRST_COMPONENT, THIRD_COMPONENT);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldZeroWhenLengthFirstEqualLengthSecond() {
        //when
        int actual = comparator.compare(FIRST_COMPONENT, SECOND_COMPONENT);
        //then
        Assert.assertTrue(actual == 0);
    }

}