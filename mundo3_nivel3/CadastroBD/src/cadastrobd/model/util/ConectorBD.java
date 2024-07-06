/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model.util;
import java.sql.*;

/**
 *
 * @author wellingtonfonseca
 */
public class ConectorBD {
    private static final String URL = "jdbc:postgresql://xxx";
    private static final String USER = "xxx";
    private static final String PASSWORD = "xxx";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static PreparedStatement getPrepared(
        Connection conn,
        String sql
    ) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public static ResultSet getSelect(
        Connection conn,
        String sql
    ) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public static void close(
        Connection conn
    ) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(
        Statement stmt
    ) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(
        ResultSet rs
    ) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
