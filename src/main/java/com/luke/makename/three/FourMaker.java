package com.luke.makename.three;

import com.luke.makename.Maker;
import com.luke.makename.name.FourName;
import com.luke.makename.name.Name;
import com.luke.makename.util.DataBaseUtil;
import com.luke.makename.util.GossipUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class FourMaker implements Maker {
    private List<Integer> mGoodList = Arrays.asList(1, 3, 5, 7, 8, 11, 13, 15, 16, 18, 21, 23, 24, 25, 31, 32, 33, 35, 37, 39, 41, 45, 47, 48, 52, 57, 61, 63, 65, 67, 68, 81);
    private List<Three> mThreeList = new ArrayList<Three>();
    private List<Name> mNameList = new ArrayList<Name>();

    private FourMaker() {
    }


    public static FourMaker getInstance() {
        return new FourMaker();
    }

    public void make() {

        initThreeList();
        initNameList();
        DataBaseUtil.saveNameList(mNameList, "four_name");
    }


    private void initNameList() {
        for (Three three : mThreeList) {
            int secondStork = three.getPeople() - 15;
            int otherStork = three.getGround() - secondStork;
//            if (otherStork % 2 == 0) {//末尾字必须为阴
            if (GossipUtil.isGoodGossip(15, three.getGround())) {
                for (int thirdStork = 1; thirdStork < otherStork; thirdStork++) {
                    int fourthStork = otherStork - thirdStork;
                    mNameList.add(new FourName(secondStork, thirdStork, fourthStork));
                }
            }
//            }
        }
    }


    private void initThreeList() {
        for (int people : mGoodList) {
            if (people > 15 && people < 45) {
                int mod = people % 10;
                switch (mod) {
                    case 3:
                    case 4:
                        initPeopleHuo(people);
                        break;
                    case 5:
                    case 6:
                        initPeopleTu(people);
                        break;
                    case 7:
                    case 8:
                        initPeopleJin(people);
                        break;

                }
            }
        }
    }

    private void addToThreeList(int people, int ground) {
        if (mGoodList.contains(ground + 15)) {//总格大吉
            int outer = ground + 16 - people;
            if (mGoodList.contains(outer) && outer < 61) {//外格大吉
                mThreeList.add(new Three(people, ground));
            }
        }
    }

    private void initPeopleHuo(int people) {
        for (int ground : mGoodList) {
            if (ground > 3 && ground < 90) {
                int mod = ground % 10;
                switch (mod) {//去掉3 4，土火火评分不高
                    case 1://阳
//                    case 3:
                    case 5:

                    case 2://阴
//                    case 4:
                    case 6:
                        addToThreeList(people, ground);
                        break;
                }
            }
        }
    }


    private void initPeopleTu(int people) {
        for (int ground : mGoodList) {
            if (ground > 3 && ground < 90) {
                int mod = ground % 10;
                switch (mod) {
                    case 3://阳
                    case 5:
                    case 7:

                    case 4://阴
                    case 6:
                    case 8:
                        addToThreeList(people, ground);
                        break;
                }
            }
        }
    }

    private void initPeopleJin(int people) {
        for (int ground : mGoodList) {
            if (ground > 3 && ground < 90) {
                int mod = ground % 10;
                switch (mod) {
                    case 5://阳
                    case 7:
                    case 9:

                    case 6://阴
                    case 8:
                    case 0:
                        addToThreeList(people, ground);
                        break;
                }
            }
        }
    }


}
