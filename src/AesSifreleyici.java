public class AesSifreleyici implements ISifreleyici {
    @Override
    public String sifrele(String metin) {
        System.out.println("AES ile şifreleniyor...");
        return "AES_SIFRELI_" + metin;
    }

    @Override
    public String coz(String sifreliMetin) {
        System.out.println("AES ile çözülüyor...");
        return sifreliMetin.replace("AES_SIFRELI_", "");
    }
}
