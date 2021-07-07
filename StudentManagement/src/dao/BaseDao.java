package dao;

import java.sql.*;

public class BaseDao {

    /**
     * 连接对象
     */
    protected Connection conn = null;

    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/practice";
    private String user = "root";
    private String password = "root";

    /**
     * 获取数据库连接
     * @return
     */
    protected Connection getConnection() {
        try {
            //加载驱动
            Class.forName(driver);
            if (conn == null || conn.isClosed()) {
                //建立连接
                conn = DriverManager.getConnection(url, user, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭资源
     * @param conn 连接对象
     * @param stmt 执行对象
     * @param rs   结果集
     */
    protected void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 增、删、改 操作
     *
     * @param sql  要执行sql语句
     * @param objs 要设置的参数
     * @return 返回受影响的行数 int类型
     */
    protected int executeUpdate(String sql, Object... objs) {
        int result = 0;
        this.getConnection();//建立连接
        PreparedStatement stmt = null;//执行对象
        try {
            //创建执行对象
            stmt = conn.prepareStatement(sql);
            //设置参数
            if (objs != null && objs.length > 0) {
                for (int i = 0; i < objs.length; i++) {
                    stmt.setObject(i + 1, objs[i]);
                }
            }
            result = stmt.executeUpdate();//开始执行

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭资源
            this.closeAll(conn, stmt, null);
        }
        return result;//返回结果
    }

    /**
     * 查询操作方法
     *
     * @param sql  要执行sql语句
     * @param objs 要设置的参数
     * @return ResultSet 调用后需要关闭该资源
     */
    protected ResultSet executeQuery(String sql, Object... objs) {
        ResultSet rs = null;
        this.getConnection();//建立连接
        PreparedStatement stmt = null;//执行对象
        try {
            //创建执行对象
            stmt = conn.prepareStatement(sql);
            //设置参数
            if (objs != null && objs.length > 0) {
                for (int i = 0; i < objs.length; i++) {
                    stmt.setObject(i + 1, objs[i]);
                }
            }
            rs = stmt.executeQuery();//开始执行

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;//返回结果
    }

}
