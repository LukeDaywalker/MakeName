package com.luke.makename.definition;

/**
 * Created by olivia on 2016/12/18.
 */
public class Definition {
    private String word;
    private String definition;

    public Definition(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }
}
