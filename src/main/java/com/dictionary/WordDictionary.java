package com.dictionary;

import com.text_components.Word;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WordDictionary {
    private Hashtable<Word, List<Integer>> dictionary;

    public WordDictionary(){
        dictionary = new Hashtable<>();
    }

    public void addWord(Word word, Integer...positions) throws KeyAlreadyExistsException{
        if (dictionary.containsKey(word)){
            throw new KeyAlreadyExistsException("Word " + word + " already exists in dictionary");
        }
        List<Integer> positionsList = List.of(positions)
                .stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        dictionary.put(word, positionsList);
    }

    public void deleteWord(Word word){
        dictionary.remove(word);
    }

    public List<Integer> getPositions(Word word) throws NoSuchElementException{
        if (!dictionary.containsKey(word)){
            throw new NoSuchElementException("No such element " + word);
        }
        return dictionary.get(word);
    }

    public String getWordSyllables(Word word){
        List<Integer> positions = getPositions(word);
        String wordString = word.toString();
        StringBuilder syllablesStringBuilder = new StringBuilder();
        int index = 0;

        for (Integer position: positions){
            if (index == 0){
                syllablesStringBuilder.append(wordString.substring(0, position + 1)).append(" ");
            }
            else{
                int lastPosition = positions.get(index - 1);
                syllablesStringBuilder.append(wordString.substring(lastPosition + 1, position + 1)).append(" ");
            }
            index++;
        }

        int lastPosition = positions.get(positions.size() - 1);
        syllablesStringBuilder.append(wordString.substring(lastPosition + 1));
        return syllablesStringBuilder.toString().replace(" ", "-");
    }
}
