package com.luke.makename.util;

import com.luke.makename.Word;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.*;

/**
 * Created by olivia on 2016/12/18.
 */
public class UnionUtil {
    private static Set<String> mAvoidWordSet = new HashSet<String>();

    static {
        List<String> nameList = Arrays.asList(
                "xiao,wei", "jing",
                "kai,hai", "hui,qin",
                "bing,lie", "chong,wen",
                "hao", "kai,jun", "shao,wen",
                "ting", "yu", "lian,min", "xi,zhang",
                "qing", "xia", "lian,hua", "xiu,pin",

                "yu,an", "xiu,lan",
                "na", "jin,feng", "yong,hong",
                "peng", "hui,zhen", "de,yuan",
                "xiao,dong", "hui,fang", "qing,jun",

                "hai,yang",

                "lin", "yan", "ping", "chong,yu",

                "zhen,wei", "qing", "zhen,guo", "zhen,zhong",
                "kai,ji", "kai,kun", "kai,zhang",

                "shi,bo", "ming,de", "yan,fen",
                "xin,ying", "ming,feng", "qing,ju",
                "yu,ye", "xue,wen", "ming,zhen", "de,hua",
                "ming,guang",
                "yan,de", "yan,wen",
                "jin,quan", "jin,hua", "bao,xin", "yu,mei",

                "yong,bo", "yong,tao", "ji,min"
        );
        for (String name : nameList) {
            String[] words = name.split(",");
            for (String word : words) {
                mAvoidWordSet.add(word);
            }
        }
    }

    public static List<Word> getWordList(int stork, boolean isMid) {
        List<Word> wordList = new ArrayList<Word>();
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名union.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:union.db");

            Statement stat = conn.createStatement();
            String toneStr = isMid ? "IN ('3','4')" : "IN ('1','2')";

            ResultSet rs = stat.executeQuery("SELECT * FROM union_word WHERE ty=1 AND duoYin=1 AND goodOrIll='吉' AND kxAllStork=" + stork + " AND tone " + toneStr + ";");
            while (rs.next()) {
                String pinyin = rs.getString("py");
                if (mAvoidWordSet.contains(pinyin)) {
                    continue;
                }
                String wordStr = rs.getString("word");
                String kxWord = rs.getString("kxWord");
                String fiveStr = rs.getString("fiveElements");
                int storkInt = rs.getInt("kxAllStork");
                int tone = Integer.parseInt(rs.getString("tone"));
                String pyt = rs.getString("pyt");

                String shengMu = rs.getString("shengMu");
                String yunTou = rs.getString("yunTou");
                String yunFu = rs.getString("yunFu");
                String yunWei = rs.getString("yunWei");

                Word word = new Word(wordStr, kxWord, fiveStr, storkInt, tone, pinyin, pyt,
                        shengMu, yunTou, yunFu, yunWei);
                wordList.add(word);
            }
            rs.close();
            conn.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return wordList;
    }

}
