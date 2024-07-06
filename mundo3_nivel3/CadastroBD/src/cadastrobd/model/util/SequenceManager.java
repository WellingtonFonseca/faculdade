/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastrobd.model.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wellingtonfonseca
 */
public class SequenceManager {
    public static int getValue(
        String sequenceName
    ) {
        int value = -1;
        String sql = "select nextval(?)";
        try (Connection conn = ConectorBD.getConnection();
             PreparedStatement stmt = ConectorBD.getPrepared(conn, sql)) {
            stmt.setString(1, sequenceName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                value = rs.getInt(1);
            }
            ConectorBD.close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
}
