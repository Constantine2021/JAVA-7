package com.textparser;

import com.reader.TextReader;
import com.text_components.Sentence;
import com.text_components.Symbol;
import com.text_components.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TextParserTest {
    private final TextParser textParser;

    public TextParserTest(){
        TextReader reader = new TextReader();
        textParser = new TextParser(reader.readText());
        textParser.parseText();
    }

    @Test
    public void symbolsCountTest(){
        List<Symbol> symbolList = textParser.getSymbolList();

        Assertions.assertEquals(561, symbolList.size());
    }

    @Test
    public void wordsCountTest(){
        List<Word> wordList = textParser.getWordList();

        Assertions.assertEquals(91, wordList.size());
    }

    @Test
    public void sentenceCountTest(){
        List<Sentence> sentenceList = textParser.getSentenceList();

        Assertions.assertEquals(4, sentenceList.size());
    }

}
