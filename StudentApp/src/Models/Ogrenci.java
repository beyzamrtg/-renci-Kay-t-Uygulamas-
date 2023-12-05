package Models;

import java.util.ArrayList;
import java.util.List;

public class Ogrenci {
    private String ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private List<Ders> ogrenciDersler;

    public Ogrenci(String ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
        this.ogrenciDersler = new ArrayList<>();
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }
    public String getOgrenciAd() {
        return ogrenciAd;
    }
    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }
    public String getOgrenciBolum() {
        return ogrenciBolum;
    }
    public String getOgrencidDersler() {
        return ogrenciDersler.toString();
    }

    public void dersEkle(Ders ders) {
        ogrenciDersler.add(ders);
    }
}
