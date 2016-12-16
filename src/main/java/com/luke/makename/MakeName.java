package com.luke.makename;

/**
 * Created by olivia on 2016/12/16.
 */
public class MakeName {


    public static void main(String[] args) {
        //生成康熙字典中的吉祥字
        KangXiMaker.getInstance().make();
        //生成最佳笔画
        StorkMaker.getInstance().make();
    }


}
