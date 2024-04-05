package assignment2.resposity;

public class STUDENT {

    private String maSv;
    private String hoTen;
    private String email;
    private String sdt;
    private boolean gioiTinh;
    private String diaChi;
    private String hinhAnh;

    public STUDENT() {
    }

    public STUDENT(String maSv, String hoTen, String email, String sdt, boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }



    public Object[] toRowTable() {
        return new Object[]{
            this.maSv, this.hoTen, this.email, this.sdt, this.gioiTinh == true ? "Nam" : "Nữ", this.diaChi, this.hinhAnh
        };
    }

}
