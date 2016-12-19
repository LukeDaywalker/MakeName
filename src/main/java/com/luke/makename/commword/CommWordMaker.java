package com.luke.makename.commword;

import com.luke.makename.Maker;
import com.luke.makename.util.CommWordUtil;
import com.luke.makename.util.Util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/19.
 */
public class CommWordMaker implements Maker {
    List<CommWord> commWordList = new ArrayList<CommWord>();

    private CommWordMaker() {

    }

    public static CommWordMaker getInstance() {
        return new CommWordMaker();
    }

    public void make() {
        try {
            String textFilePath = String.format("%s%scommon.txt", "text", File.separatorChar);
            FileReader fr = null;//获取文件流

            fr = new FileReader(Util.findResource(textFilePath));

            BufferedReader br = new BufferedReader(fr); //将流整体读取。
            String str;
            while ((str = br.readLine()) != null) {//判断是否是最后一行
                for (int i = 0; i < str.length(); i++) {
                    commWordList.add(new CommWord(str.substring(i, i + 1)));
                }
            }
            CommWordUtil.saveWordList(commWordList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
