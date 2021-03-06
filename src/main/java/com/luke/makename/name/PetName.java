package com.luke.makename.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by olivia on 2016/12/16.
 * http://blog.sina.com.cn/s/blog_5134f2be0102drqu.html
 */
public class PetName extends Name {
    private final int midName;
    private final int lastName;
    private final List<Word> midWordList = new ArrayList<Word>();
    private final List<Word> lastWordList = new ArrayList<Word>();
    private final List<String> goodYunFuList = Arrays.asList("a", "e", "o", "u", "v");
    private final List<String> avoidShengMuList = Arrays.asList("l", "n");
    private final List<String> avoidYunFuList = Arrays.asList("o", "u", "v");
    private final List<String> avoidYunTouList = Arrays.asList("i");
    private final List<String> avoidWordList = Arrays.asList("刘", "一", "二", "三", "乙", "七", "卜", "己", "已", "巳", "小", "干", "于", "卡", "门", "口", "人", "入", "儿", "大", "飞", "女", "兴", "长", "也", "企", "亢", "犬", "夕", "戈", "矛", "气", "衣", "圆", "囤", "团", "国", "围", "闭", "间", "闲", "闺", "阁", "明", "国", "文", "华", "德", "建", "志", "永", "林", "成", "军", "平", "福", "荣", "生", "海", "金", "忠", "伟", "玉", "兴", "祥", "强", "清", "春", "庆", "宝", "新", "东", "光", "英", "秀", "玉", "华", "珍", "兰", "芳", "丽", "淑", "桂", "凤", "素", "梅", "美", "玲", "红", "春", "云", "琴", "惠", "霞", "金", "萍", "荣", "清", "燕", "小", "艳", "文", "娟", "杀", "毙", "死", "亡", "尸", "丧", "埋", "葬", "坟", "墓", "祭", "奠", "鬼", "魅", "魂", "魄", "灾", "祸", "患", "殃", "害", "难", "病", "疾", "恙", "痛", "痒", "疮", "伤", "残", "羸", "弱", "歪", "斜", "邪", "恶", "歹", "毒", "凶", "狠", "坏", "匪", "盗", "贼", "偷", "乱", "哭", "啼", "泣", "泪", "涕", "厌", "烦", "躁", "闷", "恼", "冻", "僵", "硬", "烫", "烤", "煎", "熬", "堵", "塞", "酸", "辣", "涩", "短", "萎", "缩", "迂", "腐", "痴", "呆", "孤", "寡", "悲", "扭", "捏", "恍", "惚", "羸", "颓", "废", "崩", "溃", "缺", "漏", "陋", "卑", "鄙", "混", "沌", "晕", "浑", "眩", "沮", "屎", "尿", "粪", "痰", "污", "秽", "脏", "臭", "腐", "烂", "霉", "膻", "腥", "臊", "骚", "屁", "糟", "肝", "胆", "肺", "肠", "胃", "脾", "臀", "血", "肉", "脑", "脸", "颊", "鼻", "眼", "睛", "脚", "趾", "头", "脸", "眼", "脚", "鸟", "也", "奸", "姦", "妨", "妒", "妬", "姘", "奴", "妓", "婊", "妖", "嫌", "牝", "雌", "虫", "蛇", "蠖", "蚝", "蛙", "蚌", "蚊", "蝇", "蚤", "鼠", "猪", "狗", "猫", "鸡", "鸭", "鹅", "豺", "狼", "狈", "罴", "狍", "猴", "獾", "狸", "缸", "罐", "碗", "筷", "锯", "铲", "钳", "锹", "菜", "葱", "蒜", "韭", "豪", "强", "猛", "刚", "烈", "闯", "彪");

    public PetName(int midName, int lastName) {
        this.midName = midName;
        this.lastName = lastName;
        addWord(midName, midWordList);
        addWord(lastName, lastWordList);
//        for (Word mid : midWordList) {
//            for (Word last : lastWordList) {
//                if (canPair(mid, last)) {
//                    nameItemList.add(new PetNameItem(mid, last));
//                }
//            }
//        }
        for (Word mid : midWordList) {
            if (goodFiveList.contains(mid.getFive())) {
                nameItemList.add(new PetNameItem(mid, mid));
            }
        }
    }

    private boolean canPair(Word midWord, Word lastWord) {
//        if (avoidWordList.contains(midWord.getWord())
//                || avoidWordList.contains(lastWord.getWord())) {
//            return false;
//        }
//        //韵腹&&韵头&&声母
//        if (avoidYunFuList.contains(midWord.getYunFu())
//                && avoidYunTouList.contains(midWord.getYunTou())
//                && avoidShengMuList.contains(midWord.getShengMu())) {
//            return false;
//        }
//
//        //声调
//        int midWordTone = midWord.getTone();
//        int lastWordTone = lastWord.getTone();
//        if (midWordTone == 2 && lastWordTone == 2) {
//            return false;
//        }
//        if (lastWordTone > 2) {
//            return false;
//        }
//
//        if (goodYunFuList.contains(midWord.getYunFu())
//                && goodYunFuList.contains(lastWord.getYunFu())) {
//            String midFive = midWord.getFive();
//            String lastFive = lastWord.getFive();
//            if (FIVE_EARTH.equals(midFive) && goodYunFuList.contains(lastFive)
//                    || FIVE_FIRE.equals(midFive) && FIVE_EARTH.equals(lastFive)) {
//                return true;
//            }
//        }
//        return false;

        return goodFiveList.contains(midWord.getFive()) && goodFiveList.contains(lastWord.getFive());
    }


    @Override
    public String toString() {
        return "Name{" + midName + "," + midName + '}';
    }
}
