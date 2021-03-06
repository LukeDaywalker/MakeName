package com.luke.makename;

import com.luke.makename.name.Name;
import com.luke.makename.name.ThreeName;
import com.luke.makename.util.DataBaseUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class StorkMaker implements Maker {
    private List<Name> mNameList = new ArrayList<Name>();

    {
        mNameList.add(new ThreeName(1,23));
        mNameList.add(new ThreeName(1,15));
        mNameList.add(new ThreeName(8,24));
        mNameList.add(new ThreeName(1,17));
        mNameList.add(new ThreeName(3,15));
        mNameList.add(new ThreeName(1,7));
    }
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

            writeName(writer);
            DataBaseUtil.saveNameList(mNameList, "user_name");
//            DataBaseUtil.printName();
            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeName(BufferedWriter writer) throws IOException {
        for (Name name : mNameList) {
            writer.write(name.toString()+"\n");
//            for (ThreeNameItem nameItem : name.getThreeNameItemList()) {
//                writer.write(nameItem.getName() + " " + nameItem.getTotalThree() + " " + nameItem.getTotalFive()+"\n");
//            }
        }
    }


}
