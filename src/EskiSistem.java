// Bu sınıf dışarıdan aldığımız, koduna dokunamadığımız eski bir kütüphane gibi düşünüldü.
public class EskiSistem {
    public String karmasikSifrelemeYap(String data) {
        System.out.println("Eski sistem (Legacy) karmasik yontemle sifreliyor...");
        return "LEGACY_SIFRE_" + data;
    }

    public String karmasikCozumlemeYap(String encryptedData) {
        System.out.println("Eski sistem (Legacy) karmasik yontemle cozuyor...");
        return encryptedData.replace("LEGACY_SIFRE_", "");
    }
}
