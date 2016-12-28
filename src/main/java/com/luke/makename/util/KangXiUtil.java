package com.luke.makename.util;

import com.luke.makename.name.Word;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class KangXiUtil {
    public static List<Word> getWordList(int stork, String five) {
        List<Word> wordList = new ArrayList<Word>();
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:kangxi.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM word WHERE stork=" + stork + " AND five='" + five + "';");
            while (rs.next()) {
                String wordStr = rs.getString("word");
                String fiveStr = rs.getString("five");
                int storkInt = rs.getInt("stork");
                Word word = new Word(wordStr, fiveStr, storkInt);
                wordList.add(word);
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public static Word getWord(int stork, String five) {
        List<Word> wordList = getWordList(stork, five);
        if (wordList.isEmpty()) {
            return null;
        }
        return wordList.get(0);
    }
}
