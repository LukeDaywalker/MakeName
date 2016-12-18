package com.luke.makename;

/**
 * Created by olivia on 2016/12/17.
 */
public class Word {
    private final String word;
    private final String five;
    private final int stork;
    private String pinyin;
    private int tone;
    private int preStork;

    public Word(String word, String five, int stork) {
        this.word = word;
        this.five = five;
        this.stork = stork;
    }
    public Word(String word, String five, int stork,int tone,String pinyin) {
        this.word = word;
        this.five = five;
        this.stork = stork;
        this.tone=tone;
        this.pinyin=pinyin;
    }

    public String getWord() {
        return word;
    }

    public String getFive() {
        return five;
    }

    public int getStork() {
        return stork;
    }

    public int getTone() {
        return tone;
    }

    public String getPinyin() {
        return pinyin;
    }

    public int getPreStork() {
        return preStork;
    }

    public void setPreStork(int preStork) {
        this.preStork = preStork;
    }

    public int getGrid() {
        return preStork + stork;
    }

    public String getThree() {
        int mod = (preStork + stork) % 10;
        switch (mod) {
            case 1:
            case 2:
                return "木";
            case 3:
            case 4:
                return "火";
            case 5:
            case 6:
                return "土";
            case 7:
            case 8:
                return "金";
            case 9:
            case 0:
                return "水";
        }
        return "";
    }
}