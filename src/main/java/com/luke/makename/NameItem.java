package com.luke.makename;

/**
 * Created by olivia on 2016/12/17.
 */
public class NameItem {
    private final Word midWord;
    private final Word lastWord;

    public NameItem(Word midWord, Word lastWord) {
        this.midWord = midWord;
        this.lastWord = lastWord;
        this.midWord.setPreStork(15);
        this.lastWord.setPreStork(midWord.getStork());
    }

    public String getName() {
        return midWord.getWord() + lastWord.getWord();
    }

    public int getMidStork(){
        return midWord.getStork();
    }

    public int getLastStork(){
        return lastWord.getStork();
    }

    public int getMidTone(){
        return midWord.getTone();
    }

    public int getLastTone(){
        return lastWord.getTone();
    }

    public String getMidPinyin(){
        return midWord.getPinyin();
    }

    public String getLastPinyin(){
        return lastWord.getPinyin();
    }

    public String getTotalThree() {
        return "(土" + midWord.getThree() + midWord.getGrid() + lastWord.getThree() + lastWord.getGrid() + ")"
                + (15 + midWord.getStork() + lastWord.getStork());
    }

    public String getTotalFive() {
        return "[火" + midWord.getFive() + midWord.getStork() + lastWord.getFive() + lastWord.getStork() + "]";
    }
}
