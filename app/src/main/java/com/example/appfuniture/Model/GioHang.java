package com.example.appfuniture.Model;

public class GioHang {
    private int imgGioHang;
    private String tenSP;
    private int giaSp;
    private int soLuongSP;

    public GioHang(int imgGioHang, String tenSP, int giaSp, int soLuongSP) {
        this.imgGioHang = imgGioHang;
        this.tenSP = tenSP;
        this.giaSp = giaSp;
        this.soLuongSP = soLuongSP;
    }

    public GioHang() {
    }

    public int getImgGioHang() {
        return imgGioHang;
    }

    public void setImgGioHang(int imgGioHang) {
        this.imgGioHang = imgGioHang;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(int giaSp) {
        this.giaSp = giaSp;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }
}
