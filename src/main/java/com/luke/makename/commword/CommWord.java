package com.luke.makename.commword;

/**
 * Created by olivia on 2016/12/19.
 */
public class CommWord {
    private final String word;

    public CommWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getUnicode() {
        return Integer.toHexString(word.charAt(0));
    }
}
