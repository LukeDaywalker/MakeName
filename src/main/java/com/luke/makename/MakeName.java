package com.luke.makename;

import com.luke.makename.commword.CommWordMaker;
import com.luke.makename.definition.DefinitionMaker;
import com.luke.makename.word.WordMaker2;

/**
 * Created by olivia on 2016/12/16.
 */
public class MakeName {


    public static void main(String[] args) {
        //生成康熙字典中的吉祥字
//        KangXiMaker.getInstance().make();

        //生成汉字
//        WordMaker.getInstance().make();
//        WordMaker2.getInstance().make();
        //生成最佳笔画
//        StorkMaker.getInstance().make();
//        StorkMaker2.getInstance().make();

        //生成三才配
        ThreeMaker.getInstance().make();

        //生成释义数据库
//        DefinitionMaker.getInstance().make();

        //生成常用字数据库
//        CommWordMaker.getInstance().make();
    }


}
