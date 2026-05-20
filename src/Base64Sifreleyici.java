public class Base64Sifreleyici implements ISifreleyici {
    @Override
    public String sifrele(String metin) {
        System.out.println("Base64 ile şifreleniyor...");
        return "BASE64_SIFRELI_" + metin;
    }

    @Override
    public String coz(String sifreliMetin) {
        System.out.println("Base64 ile çözülüyor...");
        return sifreliMetin.replace("BASE64_SIFRELI_", "");
    }
}
