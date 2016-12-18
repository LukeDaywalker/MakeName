package com.luke.makename.definition;

import com.luke.makename.Maker;
import com.luke.makename.util.DefinitionUtil;
import com.luke.makename.util.Util;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/18.
 */
public class DefinitionMaker implements Maker {
    private List<Definition> definitionList = new ArrayList<Definition>();

    private DefinitionMaker() {

    }

    public static DefinitionMaker getInstance() {
        return new DefinitionMaker();
    }

    public void make() {
        try {
            String textFilePath = String.format("%s%sming.txt", "text", File.separatorChar);
            FileReader fr = null;//获取文件流

            fr = new FileReader(Util.findResource(textFilePath));

            BufferedReader br = new BufferedReader(fr); //将流整体读取。
            String str;
            while ((str = br.readLine()) != null) {//判断是否是最后一行
                String word = str.substring(0, 1);
                definitionList.add(new Definition(word, str));
            }
            DefinitionUtil.saveDefinition(definitionList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
