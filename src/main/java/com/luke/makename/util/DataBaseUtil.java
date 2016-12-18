package com.luke.makename.util;

import com.luke.makename.Name;
import com.luke.makename.NameItem;
import com.luke.makename.word.MetaLibItem;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class DataBaseUtil {
    public static void saveNameList(List<Name> nameList) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:name.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  name (name VARCHAR UNIQUE, total_three VARCHAR ,total_five VARCHAR ,mid_stork INTEGER ,last_stork INTEGER ,mid_tone INTEGER ,last_tone INTEGER , mid_pinyin VARCHAR ,last_pinyin VARCHAR);");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into name values (?,?,?,?,?,?,?,?,?);");

            for (Name name : nameList) {
                for (NameItem nameItem : name.getNameItemList()) {
                    prep.setString(1, "刘" + nameItem.getName());
                    prep.setString(2, nameItem.getTotalThree());
                    prep.setString(3, nameItem.getTotalFive());
                    prep.setInt(4, nameItem.getMidStork());
                    prep.setInt(5, nameItem.getLastStork());
                    prep.setInt(6, nameItem.getMidTone());
                    prep.setInt(7, nameItem.getLastTone());
                    prep.setString(8, nameItem.getMidPinyin());
                    prep.setString(9, nameItem.getLastPinyin());
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

    public static void saveTestNameList(List<Name> nameList) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:test_name.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  name (name VARCHAR UNIQUE, total_three VARCHAR ,total_five VARCHAR ,mid_stork INTEGER ,last_stork INTEGER );");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into name values (?,?,?,?,?);");

            for (Name name : nameList) {
                List<NameItem> nameItemList = name.getNameItemList();
                for (int i = 0; i < nameItemList.size(); i++) {
                    if (i < 25) {
                        NameItem nameItem = nameItemList.get(i);
                        prep.setString(1, nameItem.getName());
                        prep.setString(2, nameItem.getTotalThree());
                        prep.setString(3, nameItem.getTotalFive());
                        prep.setInt(4, nameItem.getMidStork());
                        prep.setInt(5, nameItem.getLastStork());
                        prep.addBatch();
                    }
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

    public static void saveWordList(List<MetaLibItem> itemList) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:word.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  word (word VARCHAR UNIQUE, five VARCHAR ,stork INTEGER );");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into word values (?,?,?);");

            for (MetaLibItem item : itemList) {
                String words = item.getWords();
                for (int i = 0; i < words.length(); i++) {
                    prep.setString(1, words.substring(i, i + 1));
                    prep.setString(2, item.getFive());
                    prep.setInt(3, item.getStork());
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

    public static void printName() {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:name.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM name");
            while (rs.next()) {
                String name = rs.getString("name");
                String totalThree = rs.getString("total_three");
                String totalFive = rs.getString("total_five");
                int midStork = rs.getInt("mid_stork");
                int lastStork = rs.getInt("last_stork");
                System.out.println(name + " " + totalThree + " " + totalFive + "\n");
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
    }
}