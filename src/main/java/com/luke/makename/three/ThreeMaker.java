package com.luke.makename.three;

import com.luke.makename.Maker;
import com.luke.makename.Name;
import com.luke.makename.util.DataBaseUtil;
import com.luke.makename.util.GossipUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class ThreeMaker implements Maker {
    private List<Integer> mGoodList = Arrays.asList(1, 3, 5, 7, 8, 11, 13, 15, 16, 18, 21, 23, 24, 25, 31, 32, 33, 35, 37, 39, 41, 45, 47, 48, 52, 57, 61, 63, 65, 67, 68, 81);
    private List<Three> mThreeList = new ArrayList<Three>();
    private List<Name> mNameList = new ArrayList<Name>();

    private ThreeMaker() {
    }

    public static ThreeMaker getInstance() {
        return new ThreeMaker();
    }

    public void make() {
        try {
            File smaliFile = new File("three.txt");
            if (!smaliFile.exists()) {
                if (!smaliFile.createNewFile()) {
                    System.err.println("Unable to create file " + smaliFile.toString() + " - skipping class");
                    return;
                }
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(smaliFile), "UTF8"));


            initThreeList();
            writeThreeList(writer);
            initNameList();
            writeNameList(writer);
            DataBaseUtil.saveNameList(mNameList);
            DataBaseUtil.saveTestNameList(mNameList);

            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeNameList(Writer writer) throws IOException {
        writer.write("\n");
        for (Name name : mNameList) {
            writer.write(name.toString() + "\n");
        }
    }

    private void initNameList() {
        for (Three three : mThreeList) {
            int midName = three.getPeople() - 15;
            int lastName = three.getGround() - midName;
//            if (lastName % 2 == 0) {//末尾字必须为阴
            if (GossipUtil.isGoodGossip(15, three.getGround())) {
                mNameList.add(new Name(midName, lastName));
            }
//            }
        }
    }

    private void writeThreeList(Writer writer) throws IOException {
        for (Three three : mThreeList) {
            writer.write(three.toString() + "\n");
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
            if (mGoodList.contains(outer) && outer < 31) {//外格大吉
                mThreeList.add(new Three(people, ground));
            }
        }
    }

    private void initPeopleHuo(int people) {
        for (int ground : mGoodList) {
            if (ground > 2 && ground < 60) {
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

    private void initPeopleJin(int people) {
        for (int ground : mGoodList) {
            if (ground > 2 && ground < 60) {
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
