package com.bilgeadam.repository.entity;

public class Futbolcu {
    private Long id;
    private String isim;
    private String mevki;
    private int formaNo;
    private Long takimId;

    public Futbolcu(String isim, String mevki, int formaNo, Long takimId) {
        this.isim = isim;
        this.mevki = mevki;
        this.formaNo = formaNo;
        this.takimId = takimId;
    }

    public Futbolcu(String isim, String mevki, int formaNo) {
        this.isim = isim;
        this.mevki = mevki;
        this.formaNo = formaNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMevki() {
        return mevki;
    }

    public void setMevki(String mevki) {
        this.mevki = mevki;
    }

    public int getFormaNo() {
        return formaNo;
    }

    public void setFormaNo(int formaNo) {
        this.formaNo = formaNo;
    }

    public Long getTakimId() {
        return takimId;
    }

    public void setTakimId(Long takimId) {
        this.takimId = takimId;
    }

    @Override
    public String toString() {
        return "Futbolcu{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", mevki='" + mevki + '\'' +
                ", formaNo=" + formaNo +
                ", takimId=" + takimId +
                '}';
    }
}