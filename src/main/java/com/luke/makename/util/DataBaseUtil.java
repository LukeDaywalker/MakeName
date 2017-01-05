package com.luke.makename.util;

import com.luke.makename.name.Name;
import com.luke.makename.name.NameItem;
import com.luke.makename.name.ThreeNameItem;
import com.luke.makename.word.MetaLibItem;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.List;

/**
 * Created by olivia on 2016/12/17.
 */
public class DataBaseUtil {

    public static void saveNameList(List<Name> nameList, String tableName) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:union.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  "+tableName+" (userName VARCHAR UNIQUE,kxName VARCHAR , pinyin VARCHAR, midPinyin VARCHAR ,lastPinyin VARCHAR, threePowers VARCHAR ,fiveElements VARCHAR ,midStork INTEGER ,lastStork INTEGER ,midTone INTEGER ,lastTone INTEGER);");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into "+tableName+" values (?,?,?,?,?,?,?,?,?,?,?);");

            for (Name name : nameList) {
                for (NameItem nameItem : name.getNameItemList()) {
                    prep.setString(1, nameItem.getName());
                    prep.setString(2, nameItem.getKxName());
                    prep.setString(3, nameItem.getPinyin());
                    prep.setString(4, nameItem.getSecondPinyin());
                    prep.setString(5, nameItem.getOtherPinyin());
                    prep.setString(6, nameItem.getTotalThree());
                    prep.setString(7, nameItem.getTotalFive());
                    prep.setInt(8, nameItem.getSecondStork());
                    prep.setInt(9, nameItem.getOtherStork());
                    prep.setInt(10, nameItem.getSecondTone());
                    prep.setInt(11, nameItem.getOtherTone());

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
                List<NameItem> threeNameItemList = name.getNameItemList();
                for (int i = 0; i < threeNameItemList.size(); i++) {
                    if (i < 25) {
                        NameItem nameItem = threeNameItemList.get(i);
                        prep.setString(1, nameItem.getKxName());
                        prep.setString(2, nameItem.getTotalThree());
                        prep.setString(3, nameItem.getTotalFive());
                        prep.setInt(4, nameItem.getSecondStork());
                        prep.setInt(5, nameItem.getOtherStork());
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
