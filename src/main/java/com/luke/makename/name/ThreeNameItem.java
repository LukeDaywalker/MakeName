package com.luke.makename.name;

/**
 * Created by olivia on 2016/12/17.
 */
public class ThreeNameItem extends NameItem{
    private final Word secondWord;
    private final Word thirdWord;

    public ThreeNameItem(Word secondWord, Word thirdWord) {
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }

    public Word getSecondWord() {
        return secondWord;
    }

    public Word getThirdWord() {
        return thirdWord;
    }

    @Override
    public String getName() {
        return secondWord.getWord() + thirdWord.getWord();
    }

    @Override
    public String getKxName() {
        return secondWord.getKxWord() + thirdWord.getKxWord();
    }

    public String getPinyin() {
        return secondWord.getPyt() + " " + thirdWord.getPyt();
    }

    public int getPeopleGrid() {
        return 15 + secondWord.getStork();
    }

    public int getGroundGrid() {
        return secondWord.getStork() + thirdWord.getStork();
    }

    public String getTotalFive() {
        return "[火" + secondWord.getFive() + secondWord.getStork() + thirdWord.getFive() + thirdWord.getStork() + "]";
    }
}
