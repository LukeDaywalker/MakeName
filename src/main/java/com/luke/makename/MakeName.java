package com.luke.makename;

import com.luke.makename.three.ThreeMaker;

/**
 * Created by olivia on 2016/12/16.
 */
public class MakeName {


    public static void main(String[] args) {
        //生成康熙字典中的吉祥字
//        KangXiMaker.getInstance().make();

        //生成最佳笔画
//        StorkMaker.getInstance().make();

        //生成释义数据库
//        DefinitionMaker.getInstance().make();

        //生成常用字数据库
//        CommWordMaker.getInstance().make();

        //生成汉字
//        WordMaker.getInstance().make();

        //生成三才配
        ThreeMaker.getInstance().make();
    }


}
