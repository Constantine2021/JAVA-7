package com.text_components;

import java.util.Objects;
import java.util.regex.Pattern;

public class PunctuationMark {
    private String mark;
    private static final Pattern pattern = Pattern.compile("\\p{Punct}");

    public PunctuationMark(String mark){
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public static Pattern getPattern(){
        return pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PunctuationMark)) return false;
        PunctuationMark that = (PunctuationMark) o;
        return Objects.equals(getMark(), that.getMark());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMark());
    }

    @Override
    public String toString(){
        return mark;
    }
}
