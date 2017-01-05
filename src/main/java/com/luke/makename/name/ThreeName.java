package com.luke.makename.name;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/16.
 * http://blog.sina.com.cn/s/blog_5134f2be0102drqu.html
 */
public class ThreeName extends Name{
    private final int midName;
    private final int lastName;
    private final List<Word> midWordList = new ArrayList<Word>();
    private final List<Word> lastWordList = new ArrayList<Word>();

    public ThreeName(int midName, int lastName) {
        this.midName = midName;
        this.lastName = lastName;
        addWord(midName, midWordList);
        addWord(lastName, lastWordList);
        for (Word mid : midWordList) {
            for (Word last : lastWordList) {
                if (canPair(mid, last)) {
                    nameItemList.add(new ThreeNameItem(mid, last));
                }
            }
        }
    }

    private boolean canPair(Word midWord, Word lastWord) {
        if (avoidWordList1.contains(midWord.getWord())
                || avoidWordList1.contains(lastWord.getWord())) {
            return false;
        }
//        //韵腹&&韵头&&声母
//        if (avoidYunFuList.contains(midWord.getYunFu())
//                && avoidYunTouList.contains(midWord.getYunTou())
//                && avoidShengMuList.contains(midWord.getShengMu())) {
//            return false;
//        }


        //声调
        int midWordTone = midWord.getTone();
        int lastWordTone = lastWord.getTone();
        if (midWordTone == 2 && lastWordTone == 2) {
            return false;
        }

        String midFive = midWord.getFive();
        String lastFive = lastWord.getFive();
        if (FIVE_EARTH.equals(midFive) && goodFiveList.contains(lastFive)
                || FIVE_FIRE.equals(midFive) && FIVE_EARTH.equals(lastFive)) {
            return true;
        }
        return false;

    }


    @Override
    public String toString() {
        return "Name{" + midName + "," + lastName + '}';
    }
}
