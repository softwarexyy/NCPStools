package com.example.tools.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JDBCUtil {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(JDBCUtil.class);
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;

    /**
     * 获取数据库连接
     *
     * @param dbname 需要连接的数据库名
     * @return 数据库连接
     */
    public static Connection getConn(String dbname) {
        String url = "jdbc:mysql://localhost:3306/" + dbname + "?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "xieyunyu");
            LOG.info("JDBC连接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭JDBC资源，注意顺序
     */
    public static void closeJDBC() {
        try {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LOG.info("JDBC资源已释放");
    }


    /**
     * 查询数据库中单行单列某一个字段的值
     *
     * @param sql    需要执行的sql语句
     * @param dbname 需要连接的数据库名
     * @return 查询结果(String类型)
     */
    public static String querySingle(String sql, String dbname) {
        String result = "";
        getConn(dbname);
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString(1);
            }
//            LOG.info("SQL:" + ps.toString() + "; sql查询单字段结果：" + result);
            LOG.info("SQL:" + sql + "; sql查询单字段结果：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJDBC();
        }
        return result;
    }

    /**
     * 数据库更新操作
     *
     * @param sql    更新语句
     * @param dbname 数据库名
     * @return 生效条数
     */
    public static int executeSql(String sql, String dbname) {
        int affectedRowNum = 0;
        getConn(dbname);
        try {
            ps = conn.prepareStatement(sql);
            affectedRowNum = ps.executeUpdate();
            // 打印sql语句和执行结果
//            LOG.info("SQL:" + ps.toString() + "; sql生效记录数：" + affectedRowNum);
            LOG.info("SQL:" + sql + "; sql生效记录数：" + affectedRowNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeJDBC();
        }
        return affectedRowNum;
    }
}