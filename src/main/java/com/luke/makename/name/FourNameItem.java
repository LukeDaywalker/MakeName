package com.luke.makename.name;

/**
 * Created by olivia on 2016/12/17.
 */
public class FourNameItem extends NameItem {
    private final Word secondWord;
    private final Word thirdWord;
    private final Word fourthWord;

    public FourNameItem(Word secondWord, Word thirdWord, Word fourthWord) {
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
        this.fourthWord = fourthWord;
    }

    public Word getSecondWord() {
        return secondWord;
    }

    public Word getThirdWord() {
        return thirdWord;
    }

    public Word getFourthWord() {
        return fourthWord;
    }

    public String getName() {
        return "刘" + secondWord.getWord() + thirdWord.getWord() + fourthWord.getWord();
    }

    public String getKxName() {
        return "劉" + secondWord.getKxWord() + thirdWord.getKxWord() + fourthWord.getKxWord();
    }


    public String getPinyin() {
        return "liú " + secondWord.getPyt() + " " + thirdWord.getPyt() + " " + fourthWord.getPyt();
    }

    public int getPeopleGrid() {
        return 15 + secondWord.getStork();
    }

    public int getGroundGrid() {
        return secondWord.getStork() + thirdWord.getStork() + fourthWord.getStork();
    }


    public String getTotalFive() {
        return "[火" + secondWord.getFive() + secondWord.getStork() + thirdWord.getFive() + thirdWord.getStork() + fourthWord.getFive() + fourthWord.getStork() + "]";
    }

    public String getSecondPinyin() {
        return getSecondWord().getPinyin();
    }

    public String getOtherPinyin() {
        return getThirdWord().getPinyin() + " " + getFourthWord().getPinyin();
    }

    public int getSecondStork() {
        return getSecondWord().getStork();
    }

    public int getOtherStork() {
        return getThirdWord().getStork() + getFourthWord().getStork();
    }

    public int getSecondTone() {
        return getSecondWord().getTone();
    }

    public int getOtherTone() {
        return getThirdWord().getTone() * 10 + getFourthWord().getTone();
    }
}
