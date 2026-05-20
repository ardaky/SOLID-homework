public class RsaSifreleyici implements ISifreleyici {
    @Override
    public String sifrele(String metin) {
        System.out.println("RSA ile şifreleniyor...");
        return "RSA_SIFRELI_" + metin;
    }

    @Override
    public String coz(String sifreliMetin) {
        System.out.println("RSA ile çözülüyor...");
        return sifreliMetin.replace("RSA_SIFRELI_", "");
    }
}
