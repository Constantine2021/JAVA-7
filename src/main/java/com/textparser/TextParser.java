package com.textparser;

import com.text_components.Sentence;
import com.text_components.Symbol;
import com.text_components.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private String text;
    private List<Symbol> symbolList;
    private List<Word> wordList;
    private List<Sentence> sentenceList;

    public TextParser(String text){
        this.text = text;
    }

    public List<Symbol> getSymbolList() {
        return symbolList;
    }

    public List<Word> getWordList() {
        return wordList;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void parseText(){
        getAllSymbols();
        formWords();
        formSentences();
    }

    private void getAllSymbols(){
        Pattern pattern = Symbol.getPattern();
        Matcher matcher = pattern.matcher(text);
        symbolList = new ArrayList<>();
        while(matcher.find()){
            String matchingWord = text.substring(matcher.start(), matcher.end());
            symbolList.add(new Symbol(matchingWord));
        }

    }

    private void formWords(){
        wordList = new ArrayList<>();
        List<Symbol> symbolsToFormWord = new ArrayList<>();
        for (Symbol symbol : symbolList) {
            symbolsToFormWord.add(symbol);

            if (isWordEnding(symbol)) {
                Word word = new Word(symbolsToFormWord);
                wordList.add(word);
                symbolsToFormWord.clear();
            }
        }

    }

    private void formSentences(){
        sentenceList = new ArrayList<>();
        List<Word> sentenceToForm = new ArrayList<>();
        for(Word word: wordList){
            if(word.endsWith(".")){
                word = cleanWordFromPunctuationMark(word);
                sentenceToForm.add(word);
                Sentence sentence = new Sentence(sentenceToForm);
                sentenceList.add(sentence);
                sentenceToForm.clear();
            }
            word = cleanWordFromPunctuationMark(word);
            sentenceToForm.add(word);
        }
    }

    private Word cleanWordFromPunctuationMark(Word word){
        Pattern pattern = Pattern.compile("\\p{Punct}|\\s");
        Matcher matcher = pattern.matcher(word.toString());
        if(matcher.find()){
            String cleanWord = word.toString().substring(0, matcher.start());
            return new Word(cleanWord);
        }
        return word;
    }

    private boolean isWordEnding(Symbol symbol){
        return symbol.toString().matches("\\p{Punct}|\\s");
    }
}
