package com.luke.makename.util;

import com.luke.makename.name.Word;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/18.
 */
public class ZdicUtil {
    public static List<Word> getWordList(int stork, boolean isMid) {
        List<Word> wordList = new ArrayList<Word>();
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:new_word.db");

            Statement stat = conn.createStatement();
            String toneStr = isMid ? ">2" : "<3";

            ResultSet rs = stat.executeQuery("SELECT * FROM new_word WHERE stork=" + stork + " AND tone" + toneStr + ";");
            while (rs.next()) {
                String wordStr = rs.getString("word");
                String fiveStr = rs.getString("five");
                int storkInt = rs.getInt("stork");
                int tone = rs.getInt("tone");
                String pinyin = rs.getString("pinyin");
                if (CommWordUtil.isCommWord(wordStr) && DefinitionUtil.isGoodWord(wordStr)) {
                    Word word = new Word(wordStr, fiveStr, storkInt, tone, pinyin);
                    wordList.add(word);
                }
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
