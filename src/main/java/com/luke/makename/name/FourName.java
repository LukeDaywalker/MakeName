package com.luke.makename.name;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/16.
 * http://blog.sina.com.cn/s/blog_5134f2be0102drqu.html
 */
public class FourName extends Name {
    private final int secondStork;
    private final int thirdStork;
    private final int fourthStork;
    private final List<Word> secondWordList = new ArrayList<Word>();
    private final List<Word> thirdWordList = new ArrayList<Word>();
    private final List<Word> fourthWordList = new ArrayList<Word>();

    public FourName(int secondStork, int thirdStork, int fourthStork) {
        this.secondStork = secondStork;
        this.thirdStork = thirdStork;
        this.fourthStork = fourthStork;
        addWord(secondStork, secondWordList);
        addWord(thirdStork, thirdWordList);
        addWord(fourthStork, fourthWordList);
        for (Word secondWord : secondWordList) {
            for (Word thirdWord : thirdWordList) {
                for (Word fourthWord : fourthWordList) {
                    if (canPair(secondWord, thirdWord, fourthWord)) {
                        nameItemList.add(new FourNameItem(secondWord, thirdWord, fourthWord));
                    }
                }
            }
        }
    }

    private boolean canPair(Word secondWord, Word thirdWord, Word fourthWord) {
        if (avoidWordList.contains(secondWord.getWord())
                || avoidWordList.contains(thirdWord.getWord())
                || avoidWordList.contains(fourthWord.getWord())) {
            return false;
        }
        if (secondWord.isSurName() || thirdWord.isSurName() || fourthWord.isSurName()) {
            return false;
        }

//        //韵腹&&韵头&&声母
//        if (avoidYunFuList.contains(secondWord.getYunFu())
//                && avoidYunTouList.contains(secondWord.getYunTou())
//                && avoidShengMuList.contains(secondWord.getShengMu())) {
//            return false;
//        }

        //声调
        int secondWordTone = secondWord.getTone();
        int thirdWordTone = thirdWord.getTone();
        int fourthWordTone = fourthWord.getTone();

        int level=getToneCount(0,3,secondWordTone,thirdWordTone,fourthWordTone);
        int oblique=getToneCount(2,5,secondWordTone,thirdWordTone,fourthWordTone);
        if(level+oblique!=3){
            return false;
        }
        if(oblique>1){
            return false;
        }

        String secondFive = secondWord.getFive();
        String thirdFive = thirdWord.getFive();
        String fourthFive = fourthWord.getFive();
        int earthCount = getFiveCount(FIVE_EARTH, secondFive, thirdFive, fourthFive);
        int fireCount = getFiveCount(FIVE_FIRE, secondFive, thirdFive, fourthFive);
        if (earthCount + fireCount < 3) {
            return false;
        }
        if (earthCount > 2) {
            return false;
        }
        if (fireCount > 1) {
            return false;
        }

        return true;
    }

    private int getToneCount(int bottom, int top, int... tones) {
        int count = 0;
        for (int tone : tones) {
            if (tone > bottom && tone < top) {
                count++;
            }
        }
        return count;
    }

    private int getFiveCount(String targetFive, String... originFives) {
        int count = 0;
        for (String originFive : originFives) {
            if (targetFive.equals(originFive)) {
                count++;
            }
        }
        return count;
    }



    @Override
    public String toString() {
        return "Name{" + secondStork + "," + thirdStork + "," + fourthStork + '}';
    }
}
