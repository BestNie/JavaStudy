package lesson2;

import lesson2.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPrepareStatement {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection = JdbcUtils.getConneciton();
            String sql="select * from student where s_id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,1);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getObject("s_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.release(connection,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
