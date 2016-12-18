package com.luke.makename.util;

import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class CommWordUtil {

    public static void saveWordList(List<String> itemList) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名comm_word.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:comm_word.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  word (word VARCHAR UNIQUE);");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into word values (?);");

            for (String words : itemList) {
                for (int i = 0; i < words.length(); i++) {
                    prep.setString(1, words.substring(i, i + 1));
                    prep.addBatch();
                }
            }

            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);

            conn.close();
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isCommWord(String word) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名comm_word.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:comm_word.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM word WHERE word='" + word + "';");
            while (rs.next()) {
                return true;
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
        return false;
    }

}
