package assignment2.model;

import assignment2.resposity.Diem;
import assignment2.resposity.STUDENT;
import java.sql.*;
import java.util.ArrayList;

public class QuanLyDiem {

    public static Connection sConn = null;

    public QuanLyDiem() {
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

    public ArrayList<Diem> top3() {
        ArrayList<Diem> dsDiem = new ArrayList<>();
        String sql = "SELECT  g.MASV, s.HoTen, g.TiengAnh, g.TinHoc, g.GDTC  FROM GRADE g INNER JOIN STUDENTS s ON g.MASV = s.MASV";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Diem d = new Diem();
                d.setMaSv(rs.getNString("MASV"));
                d.setHoten(rs.getNString("HoTen"));
                d.setDiemTiengAnh(rs.getFloat("TiengAnh"));
                d.setDiemTinHoc(rs.getFloat("TinHoc"));
                d.setDiemGDTC(rs.getFloat("GDTC"));
                dsDiem.add(d);
            }
            return dsDiem;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Diem timTheoMa(String ma) {
        Diem d = null;
        String sql = "SELECT  g.MASV, s.HoTen, g.TiengAnh, g.TinHoc, g.GDTC  FROM GRADE g INNER JOIN STUDENTS s ON g.MASV = s.MASV WHERE g.MASV = ? ";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, ma);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String masv = rs.getNString("MASV");
                String ten = rs.getNString("HoTen");
                Float tiengAnh = rs.getFloat("TiengAnh");
                Float tinHoc = rs.getFloat("TinHoc");
                Float gdtc = rs.getFloat("GDTC");
                d = new Diem(masv, ten, tiengAnh, tinHoc, gdtc);
            }
            return d;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public STUDENT newD(String ma) {
        STUDENT s = null;
        String sql = "SELECT * FROM STUDENTS WHERE MASV = ? ";
        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, ma);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String masv = rs.getNString("MASV");
                String ten = rs.getNString("HoTen");
                String email = rs.getNString("Email");
                String sdt = rs.getNString("SoDT");
                int gioiTinh = rs.getInt("GioiTinh");
                boolean gioiTinhBoolean = gioiTinh == 1 ? true : false;
                String diaChi = rs.getNString("DiaChi");
                String hinh = rs.getNString("Hinh");
                s = new STUDENT(masv, ten, email, sdt, gioiTinhBoolean, diaChi, hinh);
            }
            return s;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int nhapDiem(Diem d) {
        String sql = "INSERT INTO GRADE (MASV, TiengAnh, TinHoc, GDTC) VALUES (?,?,?,?)";

        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, d.getMaSv());
            stm.setFloat(2, d.getDiemTiengAnh());
            stm.setFloat(3, d.getDiemTinHoc());
            stm.setFloat(4, d.getDiemGDTC());
            return stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int xoaDiem(Diem d) {
        String sql = "DELETE FROM GRADE WHERE MASV = ?";

        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setString(1, d.getMaSv());

            return stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public int suaDiem(Diem d) {
        String sql = "UPDATE GRADE SET TiengAnh = ?, TinHoc = ?, GDTC = ? WHERE MASV = ?";

        try {
            PreparedStatement stm = sConn.prepareStatement(sql);
            stm.setFloat(1, d.getDiemTiengAnh());
            stm.setFloat(2, d.getDiemTinHoc());
            stm.setFloat(3, d.getDiemGDTC());
            stm.setString(4, d.getMaSv());
            return stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
}
