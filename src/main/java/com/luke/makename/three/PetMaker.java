package com.luke.makename.three;

import com.luke.makename.Maker;
import com.luke.makename.name.Name;
import com.luke.makename.name.PetName;
import com.luke.makename.util.DataBaseUtil;
import com.luke.makename.util.GossipUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class PetMaker implements Maker {
    private List<Integer> mGoodList = Arrays.asList(1, 3, 5, 7, 8, 11, 13, 15, 16, 18, 21, 23, 24, 25, 31, 32, 33, 35, 37, 39, 41, 45, 47, 48, 52, 57, 61, 63, 65, 67, 68, 81);
    private List<Three> mThreeList = new ArrayList<Three>();
    private List<Name> mNameList = new ArrayList<Name>();

    private PetMaker() {
    }


    public static PetMaker getInstance() {
        return new PetMaker();
    }

    public void make() {
//        initThreeList();
        initNameList();
        DataBaseUtil.saveNameList(mNameList, "pet_name");
    }

    private void initNameList() {
//        for (Three three : mThreeList) {
//            int midName = three.getPeople() - 3;
//            int lastName = three.getGround() - midName;
//            if (GossipUtil.isGoodGossip(3, three.getGround())) {
//                mNameList.add(new PetName(midName, lastName));
//            }
//        }

        for (int midStork : mGoodList) {
            if (midStork < 30) {
//                for (int lastStork : mGoodList) {
//                    if (lastStork < 30) {
                        mNameList.add(new PetName(midStork, midStork));
//                    }
//                }
            }
        }

    }

    private void initThreeList() {
        for (int people : mGoodList) {
            if (people > 3 && people < 33) {
                int mod = people % 10;
                switch (mod) {
                    case 1:
                    case 2:
                        initPeopleMu(people);
                        break;
                    case 3:
                    case 4:
                        initPeopleHuo(people);
                        break;
                    case 5:
                    case 6:
                        initPeopleTu(people);
                        break;

                }
            }
        }
    }

    private void addToThreeList(int people, int ground) {
        if (mGoodList.contains(ground + 15)) {//总格大吉
            int outer = ground + 16 - people;
            if (mGoodList.contains(outer) && outer < 31) {//外格大吉
                mThreeList.add(new Three(people, ground));
            }
        }
    }

    private void initPeopleMu(int people) {
        for (int ground : mGoodList) {
            if (ground > 2 && ground < 60) {
                int mod = ground % 10;
                switch (mod) {
                    case 1://阳
                    case 3:
                    case 5:

                    case 2://阴
                    case 4:
                    case 6:
                        addToThreeList(people, ground);
                        break;
                }
            }
        }
    }

    private void initPeopleHuo(int people) {
        for (int ground : mGoodList) {
            if (ground > 2 && ground < 60) {
                int mod = ground % 10;
                switch (mod) {
                    case 1://阳
                    case 5:

                    case 2://阴
                    case 6:
                        addToThreeList(people, ground);
                        break;
                }
            }
        }
    }


    private void initPeopleTu(int people) {
        for (int ground : mGoodList) {
            if (ground > 2 && ground < 60) {
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

}
