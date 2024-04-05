package assignment2.resposity;

public class Diem {

    private String maSv;
    private String hoten;
    private Float diemTiengAnh;
    private Float diemTinHoc;
    private Float diemGDTC;

    public Diem() {
    }

    public Diem(String maSv, String hoten, Float diemTiengAnh, Float diemTinHoc, Float diemGDTC) {
        this.maSv = maSv;
        this.hoten = hoten;
        this.diemTiengAnh = diemTiengAnh;
        this.diemTinHoc = diemTinHoc;
        this.diemGDTC = diemGDTC;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Float getDiemTiengAnh() {
        return diemTiengAnh;
    }

    public void setDiemTiengAnh(Float diemTiengAnh) {
        this.diemTiengAnh = diemTiengAnh;
    }

    public Float getDiemTinHoc() {
        return diemTinHoc;
    }

    public void setDiemTinHoc(Float diemTinHoc) {
        this.diemTinHoc = diemTinHoc;
    }

    public Float getDiemGDTC() {
        return diemGDTC;
    }

    public void setDiemGDTC(Float diemGDTC) {
        this.diemGDTC = diemGDTC;
    }

    public Float diemTrungBinh() {
        return (this.diemTiengAnh + this.diemTinHoc + this.diemGDTC) / 3;
    }
    
    public Object[] toRowTable(){
        return new Object[]{
          this.maSv, this.hoten, this.diemTiengAnh, this.diemTinHoc, this.diemGDTC, this.diemTrungBinh()
        };
    }
}
