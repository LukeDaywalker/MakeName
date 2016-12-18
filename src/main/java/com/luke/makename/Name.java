package com.luke.makename;

import com.luke.makename.util.KangXiUtil;
import com.luke.makename.util.ZdicUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by olivia on 2016/12/16.
 */
public class Name {
    private final int midName;
    private final int lastName;
    private final List<Word> midWordList = new ArrayList<Word>();
    private final List<Word> lastWordList = new ArrayList<Word>();
    private final List<NameItem> nameItemList = new ArrayList<NameItem>();
    private final List<String> shengMuFuList = Arrays.asList("zh", "ch", "sh");
    private final List<String> shengMuList = Arrays.asList("b", "p", "m", "f", "d", "t", "n", "l", "g", "k", "h", "j", "q", "x", "z", "c", "s", "y", "w", "r");

    public Name(int midName, int lastName) {
        this.midName = midName;
        this.lastName = lastName;
//        addWord(midName, midWordList);
//        addWord(lastName, lastWordList);
        addWord(midName, midWordList, true);
        addWord(lastName, lastWordList, false);
        for (Word mid : midWordList) {
            for (Word last : lastWordList) {
                if (canPair(mid.getPinyin(), last.getPinyin())) {
                    nameItemList.add(new NameItem(mid, last));
                }
            }
        }
    }

    private boolean canPair(String midTone, String lastTone) {
        if(midTone.length()>1) {
            String tmp = midTone.substring(0, 2);
            if (shengMuFuList.contains(tmp)) {
                String ym = midTone.substring(2);
                return !lastTone.contains(ym);
            }
            tmp = midTone.substring(0, 1);
            if (shengMuList.contains(tmp)) {
                String ym = midTone.substring(1);
                return !lastTone.contains(ym);
            }
        }
        return !lastTone.contains(midTone);
    }

    public List<NameItem> getNameItemList() {
        return nameItemList;
    }

    private void addWord(int stork, List<Word> wordList) {
        Word wordJi = KangXiUtil.getWord(stork, "金");
        Word wordMu = KangXiUtil.getWord(stork, "木");
        Word wordShui = KangXiUtil.getWord(stork, "水");
        Word wordHuo = KangXiUtil.getWord(stork, "火");
        Word wordTu = KangXiUtil.getWord(stork, "土");
        addWord(wordJi, wordList);
        addWord(wordMu, wordList);
        addWord(wordShui, wordList);
        addWord(wordHuo, wordList);
        addWord(wordTu, wordList);
    }

    private void addWord(int stork, List<Word> wordList, boolean isMid) {
        List<Word> words = ZdicUtil.getWordList(stork, isMid);
        wordList.addAll(words);
    }

    private void addWord(Word word, List<Word> wordList) {
        if (word != null) {
            wordList.add(word);
        }
    }

    @Override
    public String toString() {
        return "Name{" + midName + "," + lastName + '}';
    }
}
