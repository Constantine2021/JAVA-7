package com.text_components;

import java.util.Objects;
import java.util.regex.Pattern;

public class Symbol {
    private String symbol;
    private static final Pattern pattern = Pattern.compile("\\p{Print}");

    public Symbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static Pattern getPattern(){
        return pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol1 = (Symbol) o;
        return getSymbol().equals(symbol1.getSymbol());
    }

    public boolean equals(String string){
        return string.equals(getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSymbol());
    }

    @Override
    public String toString(){
        return symbol;
    }
}
