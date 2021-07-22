package com.text_components;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentence {
    private List<Word> words;

    public Sentence(List<Word> words){
        this.words = new ArrayList<>(words);
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sentence)) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(getWords(), sentence.getWords());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWords());
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }
}
