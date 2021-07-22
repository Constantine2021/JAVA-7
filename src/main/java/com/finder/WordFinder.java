package com.finder;

import com.text_components.Sentence;
import com.text_components.Word;

import java.util.*;
import java.util.stream.Collectors;

public class WordFinder {
    Hashtable<Word, Integer> hashtable;
    List<Word> words;

    public WordFinder(String...words){
        this.words = new ArrayList<>();
        hashtable = new Hashtable<>();
        this.words = Arrays.stream(words).map(Word::new).collect(Collectors.toList());

        for (String word: words){
            hashtable.put(new Word(word), 0);
        }
    }

    public List<Word> find(List<Sentence> sentenceList){
        countWords(sentenceList);
        return sortCountedWords();
    }

    public void countWords(List<Sentence> sentenceList){
        for (Sentence sentence: sentenceList){
            List<Word> wordList = sentence.getWords();
            for (Word word: wordList){
                if (hashtable.containsKey(word)){
                    int currentCounter = hashtable.get(word);
                    hashtable.replace(word, currentCounter + 1);
                }
            }
        }
    }

    public List<Word> sortCountedWords(){
        return words
                .stream()
                .sorted(Comparator.comparing(word -> hashtable.get(word)))
                .collect(Collectors.toList());
    }

    public Hashtable<Word, Integer> getHashtable() {
        return hashtable;
    }
}
