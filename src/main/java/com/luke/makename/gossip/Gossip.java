package com.luke.makename.gossip;

import java.util.*;

/**
 * 八卦凶吉
 * Created by LukeSkywalker on 2016/12/19.
 */
public class Gossip {
    //乾(1)兑(2)离(3)震(4)巽(5)坎(6)艮(7)坤(8)
    //上上卦
    private final Map<Integer, List<Integer>> mGoodGossipList = new HashMap<Integer, List<Integer>>();//key为上卦，value为下卦列表
    //中上卦
    private final Map<Integer, List<Integer>> mMidGoodGossipList = new HashMap<Integer, List<Integer>>();//key为上卦，value为下卦列表

    private final int up;
    private final int down;
    private final int symbol;//爻
    private final int surnameStork;
    private final int nameStork;

    {
        mGoodGossipList.put(1, Arrays.asList(1));
        mGoodGossipList.put(2, Arrays.asList(1, 2, 3));
        mGoodGossipList.put(3, Arrays.asList(1, 4));
        mGoodGossipList.put(4, Arrays.asList(3));
        mGoodGossipList.put(5, Arrays.asList(4, 7));
        mGoodGossipList.put(6, Arrays.asList(2, 5, 8));
        mGoodGossipList.put(7, Arrays.asList(4));
        mGoodGossipList.put(8, Arrays.asList(5, 8));

        mMidGoodGossipList.put(1, Arrays.asList(2, 3, 5));
        mMidGoodGossipList.put(2, Arrays.asList(6, 7, 8));
        mMidGoodGossipList.put(3, Arrays.asList(3, 8));
        mMidGoodGossipList.put(4, Arrays.asList(1, 4, 5, 6, 7));
        mMidGoodGossipList.put(5, Arrays.asList(5, 8));
        mMidGoodGossipList.put(6, Arrays.asList(1, 3));
        mMidGoodGossipList.put(7, Arrays.asList(1, 3));
        mMidGoodGossipList.put(8, Arrays.asList(2, 6));
    }

    /**
     * @param surnameStork 姓笔画
     * @param nameStork    名笔画
     */
    public Gossip(int surnameStork, int nameStork) {
        this.surnameStork = surnameStork;
        this.nameStork = nameStork;
        int upTmp = surnameStork % 8;
        int downTmp = nameStork % 8;
        int symbolTmp = (surnameStork + nameStork) % 6;
        up = upTmp == 0 ? 8 : upTmp;
        down = downTmp == 0 ? 8 : downTmp;
        symbol = symbolTmp == 0 ? 6 : symbolTmp;
    }

    public boolean isGoodGossip() {
        int upTmp = up;
        int downTmp = down;
        //生成变卦
        if (symbol > 3) {
            upTmp = getChangedInt(upTmp, symbol);
        } else {
            downTmp = getChangedInt(downTmp, symbol);
        }
        //判断变卦凶吉
        return isGoodGossip(upTmp, downTmp);
    }

    private boolean isGoodGossip(int up, int down) {
        return mGoodGossipList.get(up).contains(down)
                || mMidGoodGossipList.get(up).contains(down);
    }

    /**
     * 获取爻变之后的值
     *
     * @param oldInt 爻变之前的值
     * @param symbol 爻变位置
     * @return
     */
    private int getChangedInt(int oldInt, int symbol) {
        int mod = symbol % 3;
        switch (mod) {
            case 0:
                return getTopChangedInt(oldInt);
            case 2:
                return getMiddleChangedInt(oldInt);
            case 1:
                return getBottomChangedInt(oldInt);
        }
        return oldInt;
    }

    private int getBottomChangedInt(int oldInt) {
        switch (oldInt) {
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 8;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 3;
            case 8:
                return 4;
        }
        return oldInt;
    }

    private int getMiddleChangedInt(int oldInt) {
        switch (oldInt) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 5;
            case 8:
                return 6;
        }
        return oldInt;
    }

    private int getTopChangedInt(int oldInt) {
        switch (oldInt) {
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 5;
            case 7:
                return 8;
            case 8:
                return 7;
        }
        return oldInt;
    }

}
