package com.finder;

import com.reader.TextReader;
import com.text_components.Word;
import com.textparser.TextParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
/*
Существует текст и список слов. Для каждого слова из заданного списка
найти, сколько раз оно встречается в каждом предложении, и рассортировать слова по убыванию общего количества вхождений.
 */
public class WordFinderTest {
    private WordFinder wordFinder;

    public WordFinderTest(){
        wordFinder = new WordFinder("Lorem", "Ipsum", "text", "been","took");
    }

    @Test
    public void find(){
        TextParser textParser = new TextParser(new TextReader().readText());
        textParser.parseText();

        System.out.println(wordFinder.find(textParser.getSentenceList()));

        Hashtable<Word, Integer> hashtable = wordFinder.getHashtable();
        Assertions.assertEquals(4, hashtable.get(new Word("Lorem")));
        Assertions.assertEquals(3, hashtable.get(new Word("Ipsum")));
    }
}
