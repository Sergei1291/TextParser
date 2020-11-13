package com.epam.textparser.logic.sorter;

import com.epam.textparser.model.Component;
import com.epam.textparser.model.Composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompositeSorter {

    public Composite sortTextByParagraphSize(Composite text) {

        List<Component> sortedParagraphs = text.getChildren();

        Comparator<Component> comparator = new ComponentParagraphSizeComparator();

        Collections.sort(sortedParagraphs, comparator);

        return new Composite(sortedParagraphs);
    }

    public Composite sortSentencesByLexemeLength(Composite text) {

        List<Component> paragraphs = text.getChildren();
        List<Component> sortedParagraphs = new ArrayList<>();

        for (Component paragraph : paragraphs) {

            List<Component> sentences = paragraph.getChildren();
            List<Component> sortedSentences = new ArrayList<>();

            for (Component sentence : sentences) {
                Composite sortedSentence = sortSentence(sentence);
                sortedSentences.add(sortedSentence);
            }

            Composite sortedParagraph = new Composite(sortedSentences);
            sortedParagraphs.add(sortedParagraph);

        }

        return new Composite(sortedParagraphs);
    }

    private Composite sortSentence(Component sentence) {

        List<Component> sortedLexemes = sentence.getChildren();

        Comparator<Component> comparator = new ComponentLexemeLengthComparator();
        Collections.sort(sortedLexemes, comparator);

        return new Composite(sortedLexemes);
    }

}