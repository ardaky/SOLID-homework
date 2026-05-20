public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("   🔐 ŞİFRELEME ARACI UYGULAMASI (SOLID ÖDEV SİMÜLASYONU) 🔐");
        System.out.println("=========================================================\n");

        // 1. Gözlemci (Observer) Tanımlama
        KonsolLogger logger = new KonsolLogger();
        
        // 2. Fabrika (Factory Method) ile AES Şifreleyici Üretme
        System.out.println("[ADIM 1] Fabrika (Factory Method) kullanılarak AES şifreleyici nesnesi üretiliyor...");
        SifrelemeFabrikasi fabrika = new SifrelemeFabrikasi();
        ISifreleyici aesSifreleyici = fabrika.sifreleyiciUret("AES");
        System.out.println("-> Üretilen Nesne Sınıfı: " + aesSifreleyici.getClass().getSimpleName() + "\n");
        
        // 3. Şifreleme Aracı (Strategy Context) Başlatma
        System.out.println("[ADIM 2] Şifreleme Aracı (Strategy Pattern) AES stratejisi ile başlatılıyor...");
        SifrelemeAraci arac = new SifrelemeAraci(aesSifreleyici);
        
        System.out.println("[ADIM 3] Konsol loglama gözlemcisi (Observer Pattern) araca ekleniyor...");
        arac.gozlemciEkle(logger);
        System.out.println("-> Gözlemci başarıyla bağlandı.\n");
        
        // Şifreleme ve Deşifreleme Testi
        String orijinalMetin = "Merhaba SOLID Dünyası! Bu amatör bir ödev kodudur.";
        System.out.println("--- İŞLEM BAŞLIYOR ---");
        System.out.println("Orijinal Metin: " + orijinalMetin);
        
        String sifreliAES = arac.sifrele(orijinalMetin);
        System.out.println("Şifrelenmiş Sonuç (AES): " + sifreliAES);
        
        String cozulmusAES = arac.coz(sifreliAES);
        System.out.println("Deşifre Edilmiş Sonuç: " + cozulmusAES);
        System.out.println("----------------------\n");
        
        // 4. Decorator (Zaman Damgası) Testi
        System.out.println("[ADIM 4] Mevcut AES şifreleyicisine Zaman Damgası (Decorator Pattern) giydiriliyor...");
        ISifreleyici zamanDamgaliAes = new ZamanDamgaliSifreleyici(aesSifreleyici);
        arac.setStrateji(zamanDamgaliAes);
        System.out.println("-> Zaman Damgası dekoratörü başarıyla uygulandı.\n");
        
        System.out.println("--- DECORATOR İŞLEMİ BAŞLIYOR ---");
        String sifreliZamanli = arac.sifrele(orijinalMetin);
        System.out.println("Şifrelenmiş Sonuç (Zaman Damgalı AES): " + sifreliZamanli);
        
        String cozulmusZamanli = arac.coz(sifreliZamanli);
        System.out.println("Deşifre Edilmiş Sonuç: " + cozulmusZamanli);
        System.out.println("---------------------------------\n");
        
        // 5. Adapter Testi (Eski Sistem entegrasyonu)
        System.out.println("[ADIM 5] Uyumsuz metotlara sahip harici 'EskiSistem' kütüphanesi, Adaptör (Adapter Pattern) ile sisteme entegre ediliyor...");
        EskiSistem disKutuphane = new EskiSistem();
        ISifreleyici adaptör = new EskiSistemAdapter(disKutuphane);
        arac.setStrateji(adaptör);
        System.out.println("-> Adaptör başarıyla bağlandı ve çalışma zamanı stratejisi olarak ayarlandı.\n");
        
        System.out.println("--- ADAPTER İŞLEMİ BAŞLIYOR ---");
        String sifreliLegacy = arac.sifrele(orijinalMetin);
        System.out.println("Şifrelenmiş Sonuç (Adaptör - EskiSistem): " + sifreliLegacy);
        
        String cozulmusLegacy = arac.coz(sifreliLegacy);
        System.out.println("Deşifre Edilmiş Sonuç: " + cozulmusLegacy);
        System.out.println("-------------------------------\n");
        
        // 6. Strategy Değişimi Testi (Dinamik olarak RSA'ya geçiş)
        System.out.println("[ADIM 6] Çalışma zamanında (Runtime) RSA stratejisine dinamik geçiş yapılıyor (Strategy Pattern & OCP)...");
        ISifreleyici rsaSifreleyici = fabrika.sifreleyiciUret("RSA");
        arac.setStrateji(rsaSifreleyici);
        System.out.println("-> Yeni strateji olarak RSA ayarlandı.\n");
        
        System.out.println("--- STRATEGY GEÇİŞ İŞLEMİ BAŞLIYOR ---");
        String sifreliRSA = arac.sifrele(orijinalMetin);
        System.out.println("Şifrelenmiş Sonuç (RSA): " + sifreliRSA);
        
        String cozulmusRSA = arac.coz(sifreliRSA);
        System.out.println("Deşifre Edilmiş Sonuç: " + cozulmusRSA);
        System.out.println("--------------------------------------\n");
        
        System.out.println("=========================================================");
        System.out.println(" 🎉 TÜM TASARIM ÖRÜNTÜLERİ BAŞARIYLA BİR ARADA ÇALIŞTI! 🎉");
        System.out.println("=========================================================");
    }
}
