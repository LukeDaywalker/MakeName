package com.luke.makename.word;

import com.luke.makename.Maker;
import com.luke.makename.definition.Definition;
import com.luke.makename.util.DataBaseUtil;
import com.luke.makename.util.DefinitionUtil;
import com.luke.makename.util.Util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class WordMaker2 implements Maker {
    List<MetaLibItem> itemList = new ArrayList<MetaLibItem>();

    private WordMaker2() {

    }

    public static WordMaker2 getInstance() {
        return new WordMaker2();
    }

    public void make() {
        try {
            String textFilePath = String.format("%s%sword.txt", "text", File.separatorChar);
            FileReader fr = null;//获取文件流

            fr = new FileReader(Util.findResource(textFilePath));

            BufferedReader br = new BufferedReader(fr); //将流整体读取。
            String str;
            while ((str = br.readLine()) != null) {//判断是否是最后一行
                String[] items=str.split(",");
                itemList.add(new MetaLibItem(Integer.parseInt(items[1]), items[0], items[2]));
            }
            DataBaseUtil.saveWordList(itemList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
