package com.text_components;

import java.util.regex.Pattern;

public class Paragraph {
    private static final Pattern pattern = Pattern.compile("\\p{Blank}");
    public static Pattern getPattern(){
        return pattern;
    }
}
