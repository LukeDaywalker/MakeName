package com.luke.makename.util;

import com.luke.makename.Word;
import com.luke.makename.definition.Definition;
import org.sqlite.SQLiteException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivia on 2016/12/18.
 */
public class DefinitionUtil {
    public static boolean isGoodWord(String word) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名definition.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:definition.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM definition WHERE word='" + word + "';");
            while (rs.next()) {
                String wordStr = rs.getString("word");
                String definition = rs.getString("definition");
                if (definition.contains("灾")
                        || definition.contains("厄")
                        || definition.contains("刑")
                        || definition.contains("忌")
                        || definition.contains("疾")
                        || definition.contains("弱")
                        || definition.contains("欠子")
                        || definition.contains("克偶")
                        || definition.contains("克夫")
                        || definition.contains("相克")
                        || definition.contains("短寿")
                        || definition.contains("薄幸")
                        || definition.contains("潦倒")
                        || definition.contains("克父")) {
                    return false;
                }
            }
            rs.close();
            conn.close();
        } catch (SQLiteException e) {
            e.getResultCode();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void saveDefinition(List<Definition> definitionList) {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名definition.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:definition.db");

            Statement stat = conn.createStatement();

            stat.executeUpdate("create table IF NOT EXISTS  definition (word VARCHAR UNIQUE, definition VARCHAR);");
            PreparedStatement prep = conn.prepareStatement(
                    "replace into definition values (?,?);");

            for (Definition definition : definitionList) {
                prep.setString(1, definition.getWord());
                prep.setString(2, definition.getDefinition());
                prep.addBatch();
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

}
