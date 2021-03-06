package com.luke.makename.name;

/**
 * Created by olivia on 2016/12/17.
 */
public class Word {
    private final String word;
    private String kxWord;
    private final String five;
    private final int stork;
    private String pinyin;
    private String pyt;
    private int tone;

    private String shengMu;//声母
    private String yunTou;//韵头
    private String yunFu;//韵腹
    private String yunWei;//韵尾

    private boolean isSurName;//是否为姓

    public Word(String word, String five, int stork) {
        this.word = word;
        this.five = five;
        this.stork = stork;
    }

    public Word(String word, String five, int stork, int tone, String pinyin) {
        this.word = word;
        this.five = five;
        this.stork = stork;
        this.tone = tone;
        this.pinyin = pinyin;
    }

    public Word(String word, String kxWord, String five, int stork, int tone, String pinyin, String pyt,
                String shengMu, String yunTou, String yunFu, String yunWei, boolean isSurName) {
        this.word = word;
        this.kxWord = kxWord;
        this.five = five;
        this.stork = stork;
        this.tone = tone;
        this.pinyin = pinyin;
        this.pyt = pyt;

        this.shengMu = shengMu;
        this.yunTou = yunTou;
        this.yunFu = yunFu;
        this.yunWei = yunWei;

        this.isSurName = isSurName;
    }

    public String getWord() {
        return word;
    }

    public String getKxWord() {
        return kxWord;
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

    public String getPyt() {
        return pyt;
    }


    public String getShengMu() {
        return shengMu;
    }

    public String getYunTou() {
        return yunTou;
    }

    public String getYunFu() {
        return yunFu;
    }

    public String getYunWei() {
        return yunWei;
    }

    public boolean isSurName() {
        if (getWord().equals("柴")) {
            return false;
        }
        return isSurName;
    }
}
