import java.util.Date;

public class ZamanDamgaliSifreleyici extends SifreleyiciDecorator {
    public ZamanDamgaliSifreleyici(ISifreleyici sarmalananSifreleyici) {
        super(sarmalananSifreleyici);
    }

    @Override
    public String sifrele(String metin) {
        String sifrelenmis = super.sifrele(metin);
        String zaman = new Date().toString();
        System.out.println("Zaman damgası ekleniyor: " + zaman);
        return "[" + zaman + "] " + sifrelenmis;
    }

    @Override
    public String coz(String sifreliMetin) {
        // Basitçe zaman damgasını kaldırıp orijinal şifre çözücüye yolluyoruz (gerçekte regex vs kullanılabilir)
        int kapatmaParantezi = sifreliMetin.indexOf("] ");
        if (kapatmaParantezi != -1) {
            String gercekSifre = sifreliMetin.substring(kapatmaParantezi + 2);
            return super.coz(gercekSifre);
        }
        return super.coz(sifreliMetin);
    }
}
