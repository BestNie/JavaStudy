package lesson2.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try {

            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");

            password = properties.getProperty("password");
            //驱动只要加载一次
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConneciton() throws SQLException {
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void release(Connection con, Statement st, ResultSet rs) throws SQLException {
        if (con != null) {
            con.close();
        }
        if (st != null) {
            con.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
}
