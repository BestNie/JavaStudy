package lesson1;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbctest?&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";
        //链接成功，获取数据库对象connection
        Connection connection = DriverManager.getConnection(url, username, password);
        //执行sql的对象Statement执行sql的对象
        Statement statement = connection.createStatement();
        //执行的sql
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        //查看结果
        while (resultSet.next()) {
            System.out.println("名字是" + resultSet.getString("s_name"));
            System.out.println("其他的是" + resultSet.getObject("s_sex"));
        }
        connection.close();
        statement.close();
        resultSet.close();
    }
}
