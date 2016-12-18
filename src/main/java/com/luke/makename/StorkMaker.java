package com.luke.makename;

import com.luke.makename.util.DataBaseUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class StorkMaker implements Maker {
    private List<Integer> mGoodList = Arrays.asList(1, 3, 5, 7, 8, 11, 13, 15, 16, 18, 21, 23, 24, 25, 31, 32, 33, 35, 37, 39, 41, 45, 47, 48, 52, 57, 61, 63, 65, 67, 68, 81);
    private List<Integer> mHalfGoodList = Arrays.asList(6, 17, 26, 27, 29, 30, 38, 49, 51, 55, 58, 71, 73, 75);
    private List<Integer> mLastList = new ArrayList<Integer>();
    private List<Name> mNameList = new ArrayList<Name>();

    private StorkMaker() {
    }

    public static StorkMaker getInstance() {
        return new StorkMaker();
    }

    public void make() {
        try {
            File smaliFile = new File("storks.txt");
            if (!smaliFile.exists()) {
                if (!smaliFile.createNewFile()) {
                    System.err.println("Unable to create file " + smaliFile.toString() + " - skipping class");
                    return;
                }
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(smaliFile), "UTF8"));


            addLast(writer, mGoodList);
            addLast(writer, mHalfGoodList);
            addMid(writer, mGoodList);
            addMid(writer, mHalfGoodList);
            writeName(writer);
//            DataBaseUtil.saveNameList(mNameList);
//            DataBaseUtil.printName();
            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeName(BufferedWriter writer) throws IOException {
        for (Name name : mNameList) {
            writer.write(name.toString()+"\n");
//            for (NameItem nameItem : name.getNameItemList()) {
//                writer.write(nameItem.getName() + " " + nameItem.getTotalThree() + " " + nameItem.getTotalFive()+"\n");
//            }
        }
    }

    private void addLast(BufferedWriter writer, List<Integer> list) throws IOException {
        for (Integer num : list) {
            if (num < 30) {
                int out = num + 1;
                if (mGoodList.contains(out) || mHalfGoodList.contains(out)) {
                    mLastList.add(num);
//                    writer.write(num + "\n");
                }
            }
        }
    }

    private void addMid(BufferedWriter writer, List<Integer> list) throws IOException {
        for (Integer num : list) {
            if (num < 30) {
                int people = 15 + num;//人格
                if (mGoodList.contains(people) || mHalfGoodList.contains(people)) {
                    for (Integer last : mLastList) {
                        int floor = num + last;//地格
                        if (mGoodList.contains(floor) || mHalfGoodList.contains(floor)) {
                            int all = 15 + num + last;//总格
                            if (mGoodList.contains(all) || mHalfGoodList.contains(all)) {
                                Name name = new Name(num, last);
                                mNameList.add(name);
//                                writer.write(name + "\n");
                            }
                        }
                    }
                }
            }
        }
    }
}
