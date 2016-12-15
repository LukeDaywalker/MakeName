package com.luke.makename;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

import com.google.common.io.Resources;

/**
 * Created by olivia on 2016/12/16.
 */
public class MakeName {

    private static List<Integer> mGoodList = Arrays.asList(1, 3, 5, 7, 8, 11, 13, 15, 16, 18, 21, 23, 24, 25, 31, 32, 33, 35, 37, 39, 41, 45, 47, 48, 52, 57, 61, 63, 65, 67, 68, 81);
    private static List<Integer> mHalfGoodList = Arrays.asList(6, 17, 26, 27, 29, 30, 38, 49, 51, 55, 58, 71, 73, 75);
    private static List<Integer> mLastList = new ArrayList<Integer>();
    private static List<Name> mNameList = new ArrayList<Name>();

    private static File findResource(String resource) throws URISyntaxException {
        URL resUrl = Resources.getResource(resource);
        return new File(resUrl.toURI());
    }

    public static void main(String[] args) {

        try {


            File smaliFile = new File("namelines.txt");
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
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void addLast(BufferedWriter writer, List<Integer> list) throws IOException {
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

    private static void addMid(BufferedWriter writer, List<Integer> list) throws IOException {
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
                                writer.write(name + "\n");
                            }
                        }
                    }
                }
            }
        }
    }

}
