import java.util.ArrayList;
import java.util.List;

public class SifrelemeAraci {
    private ISifreleyici strateji;
    private List<IGozlemci> gozlemciler = new ArrayList<>();

    // Varsayılan constructor
    public SifrelemeAraci(ISifreleyici baslangicStratejisi) {
        this.strateji = baslangicStratejisi;
    }

    // Gözlemci Ekleme (Observer Pattern)
    public void gozlemciEkle(IGozlemci gozlemci) {
        gozlemciler.add(gozlemci);
    }

    private void gozlemcilereHaberVer(String mesaj) {
        for (IGozlemci g : gozlemciler) {
            g.islemYapildi(mesaj);
        }
    }

    // Çalışma zamanında algoritmayı değiştirme (Strategy Pattern)
    // OCP (Open/Closed Principle) burada sağlanıyor, koda dokunmadan yeni davranışı enjekte edebiliyoruz.
    public void setStrateji(ISifreleyici yeniStrateji) {
        this.strateji = yeniStrateji;
        gozlemcilereHaberVer("Strateji değiştirildi. Yeni strateji sınıfı: " + yeniStrateji.getClass().getSimpleName());
    }

    public String sifrele(String metin) {
        gozlemcilereHaberVer("Şifreleme işlemi başladı. Metin uzunluğu: " + metin.length());
        String sonuc = this.strateji.sifrele(metin);
        gozlemcilereHaberVer("Şifreleme bitti.");
        return sonuc;
    }

    public String coz(String sifreliMetin) {
        gozlemcilereHaberVer("Deşifre işlemi başladı.");
        String sonuc = this.strateji.coz(sifreliMetin);
        gozlemcilereHaberVer("Deşifre bitti.");
        return sonuc;
    }
}
