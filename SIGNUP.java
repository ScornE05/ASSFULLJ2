package assignment2.model;

import java.sql.*;

public class SIGNUP {

    public static Connection sConn = null;

    public SIGNUP() {
        String strDbUrl = "jdbc:sqlserver://localhost:1433; "
                + "databaseName=FPL_ĐàoTạo;"
                + "user=sa;"
                + "password=Password.1;"
                + "encrypt=true;trustServerCertificate=true";

        if (sConn == null) {
            try {
                sConn = DriverManager.getConnection(strDbUrl);
            } catch (SQLException ex) {
                System.out.println("Không thể kết nối đến CSDL \n" + ex);
            }
        }
    }

    public boolean dangKyTaiKhoan(String username, String password, String role) {
        try {
            String sql = "INSERT INTO USERS (UserName, Pass, role0) VALUES (?, ?, ?)";
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, role);
            int row = stm.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkLogin(String username, String password, String role) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean loginSuccessful = false;

        try {
            String sql = "SELECT * FROM USERS WHERE UserName = ? AND Pass = ? AND role0 = ?";
            stmt = sConn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            rs = stmt.executeQuery();
            if (rs.next()) {
                loginSuccessful = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return loginSuccessful;
    }

}
