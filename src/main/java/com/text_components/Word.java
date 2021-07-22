package com.text_components;

import java.util.*;

public class Word {
    private List<Symbol> symbols;

    public Word(List<Symbol> symbols){
        this.symbols = new ArrayList<>(symbols);
    }

    public Word(Symbol...symbols){
        this.symbols = Arrays.asList(symbols);
    }

    public Word(String word){
        symbols = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            char symbol = word.charAt(i);
            symbols.add(new Symbol(String.valueOf(symbol)));
        }
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return Objects.equals(getSymbols(), word.getSymbols());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbols());
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        for (Symbol symbol: symbols){
            stringBuilder.append(symbol.getSymbol());
        }
        return stringBuilder.toString();
    }

    public boolean endsWith(String suffix){
        return toString().endsWith(suffix);
    }
}
