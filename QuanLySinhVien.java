package assignment2.model;

import static assignment2.model.QuanLyDiem.sConn;
import assignment2.resposity.Diem;
import assignment2.resposity.STUDENT;
import java.sql.*;
import java.util.ArrayList;

public class QuanLySinhVien {

    public static Connection sConn = null;

    public QuanLySinhVien() {
        String strDbUrl = "jdbc:sqlserver://localhost:1433; "
                + "databaseName=FPL_ĐàoTạo;"
                + "user=sa;"
                + "password=Password.1;"
                + "encrypt=true;trustServerCertificate=true";

        if (sConn == null) {
            try {
                sConn = DriverManager.getConnection(strDbUrl);

            } catch (SQLException ex) {
                System.out.println("Khong the ket noi den CSDL \n" + ex);
            }
        }
    }

    public ArrayList<STUDENT> getAll() {
        ArrayList<STUDENT> danhSachSinhVien = new ArrayList<>();
        String sql = "SELECT * FROM STUDENTS";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                STUDENT s = new STUDENT();
                s.setMaSv(rs.getNString("MASV"));
                s.setHoTen(rs.getNString("HoTen"));
                s.setEmail(rs.getNString("Email"));
                s.setSdt(rs.getNString("SoDT"));
                int gioiTinh = rs.getInt("GioiTinh");
                boolean gioiTinhBoolean = gioiTinh == 1 ? true : false;
                s.setGioiTinh(gioiTinhBoolean);
                s.setDiaChi(rs.getNString("DiaChi"));
                s.setHinhAnh(rs.getNString("Hinh"));
                danhSachSinhVien.add(s);
            }
            return danhSachSinhVien;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int themSV(STUDENT s) {
        String sql = "INSERT INTO STUDENTS (MASV, HoTen, Email, SoDT, GioiTinh, DiaChi, Hinh ) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, s.getMaSv());
            stm.setString(2, s.getHoTen());
            stm.setString(3, s.getEmail());
            stm.setString(4, s.getSdt());
            stm.setBoolean(5, s.isGioiTinh());
            stm.setString(6, s.getDiaChi());
            stm.setString(7, s.getHinhAnh());
            int x = stm.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int xoaSV(STUDENT s) {
        String sql = "DELETE FROM STUDENTS  WHERE MASV = ?";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, s.getMaSv());
            int x = stm.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int suaSV(STUDENT s) {
        String sql = "UPDATE STUDENTS  SET HoTen = ?, Email = ?, SoDT = ?, GioiTinh = ?, DiaChi = ?, Hinh = ? WHERE MASV = ?";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, s.getHoTen());
            stm.setString(2, s.getEmail());
            stm.setString(3, s.getSdt());
            stm.setBoolean(4, s.isGioiTinh());
            stm.setString(5, s.getDiaChi());
            stm.setString(6, s.getHinhAnh());
            stm.setString(7, s.getMaSv());

            int x = stm.executeUpdate();
            return x;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    public int xoaDiem(String ma) {
        String sql = "DELETE FROM GRADE WHERE MASV = ?";

        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, ma);

            return stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
