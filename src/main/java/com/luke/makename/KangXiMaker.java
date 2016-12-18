package com.luke.makename;

import java.io.File;
import java.sql.*;

/**
 * Created by LukeSkywalker on 2016/12/16.
 */
public class KangXiMaker implements Maker {
    private KangXiMaker() {
    }

    public static KangXiMaker getInstance() {
        return new KangXiMaker();
    }

    public void make() {
        try {
            //连接SQLite的JDBC

            Class.forName("org.sqlite.JDBC");

            //建立一个数据库名zieckey.db的连接，如果不存在就在当前目录下创建之

            Connection conn = DriverManager.getConnection("jdbc:sqlite:kangxi.db");

            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("select * from word;");
            while (rs.next()) {
                System.out.println("word = " + rs.getString("word"));
                System.out.println("five = " + rs.getString("five"));
                System.out.println("stork = " + rs.getInt("stork"));
            }
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
