package com.example.appfuniture.Model;

public class GiamGia {
    private int numberSale;
    private int imageSale;
    private String giaTienBanDau;
    private String giaTienSale;
    private int daBan;

    public GiamGia(int numberSale, int imageSale, String giaTienBanDau, String giaTienSale, int daBan) {
        this.numberSale = numberSale;
        this.imageSale = imageSale;
        this.giaTienBanDau = giaTienBanDau;
        this.giaTienSale = giaTienSale;
        this.daBan = daBan;
    }

    public GiamGia() {
    }

    public int getNumberSale() {
        return numberSale;
    }

    public void setNumberSale(int numberSale) {
        this.numberSale = numberSale;
    }

    public int getImageSale() {
        return imageSale;
    }

    public void setImageSale(int imageSale) {
        this.imageSale = imageSale;
    }

    public String getGiaTienBanDau() {
        return giaTienBanDau;
    }

    public void setGiaTienBanDau(String giaTienBanDau) {
        this.giaTienBanDau = giaTienBanDau;
    }

    public String getGiaTienSale() {
        return giaTienSale;
    }

    public void setGiaTienSale(String giaTienSale) {
        this.giaTienSale = giaTienSale;
    }

    public int getDaBan() {
        return daBan;
    }

    public void setDaBan(int daBan) {
        this.daBan = daBan;
    }
}
