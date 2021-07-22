package com.dictionary;

import com.text_components.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
Добавить к программе из предыдущего примера возможность переноса
слов по слогам. Предполагается, что есть доступ к словарю, в котором
для каждого слова указано, как оно разбивается на слоги.
 */
public class WordDictionaryTest {
    private WordDictionary wordDictionary;

    public  WordDictionaryTest(){
        wordDictionary = new WordDictionary();
    }

    @Test
    public void wordWith2SyllablesTest(){
        Word word = new Word("Limbo");
        wordDictionary.addWord(word, 2);
        String wordSyllables = wordDictionary.getWordSyllables(word);

        Assertions.assertEquals("Lim-bo", wordSyllables);
    }

    @Test
    public void wordWithMoreThan2SyllablesTest(){
        Word word = new Word("Construction");
        wordDictionary.addWord(word, 2, 7);
        String wordSyllables = wordDictionary.getWordSyllables(word);

        Assertions.assertEquals("Con-struc-tion", wordSyllables);
    }
}
