public class SifrelemeAraci {
    private String algoritma;

    public SifrelemeAraci(String algoritmaTipi) {
        // Algoritma tipini doğrudan burada if-else ile kontrol ediyorum.
        if (algoritmaTipi.equals("AES")) {
            this.algoritma = "AES";
        } else if (algoritmaTipi.equals("RSA")) {
            this.algoritma = "RSA";
        } else if (algoritmaTipi.equals("Base64")) {
            this.algoritma = "Base64";
        } else {
            System.out.println("Bilinmeyen algoritma!");
            this.algoritma = "Bilinmeyen";
        }
    }

    public String sifrele(String metin) {
        if (this.algoritma.equals("AES")) {
            System.out.println("AES ile şifreleniyor...");
            return "AES_SIFRELI_" + metin;
        } else if (this.algoritma.equals("RSA")) {
            System.out.println("RSA ile şifreleniyor...");
            return "RSA_SIFRELI_" + metin;
        } else if (this.algoritma.equals("Base64")) {
            System.out.println("Base64 ile şifreleniyor...");
            return "BASE64_SIFRELI_" + metin;
        } else {
            return "Şifrelenemedi!";
        }
    }

    public String coz(String sifreliMetin) {
        if (this.algoritma.equals("AES")) {
            System.out.println("AES ile çözülüyor...");
            return sifreliMetin.replace("AES_SIFRELI_", "");
        } else if (this.algoritma.equals("RSA")) {
            System.out.println("RSA ile çözülüyor...");
            return sifreliMetin.replace("RSA_SIFRELI_", "");
        } else if (this.algoritma.equals("Base64")) {
            System.out.println("Base64 ile çözülüyor...");
            return sifreliMetin.replace("BASE64_SIFRELI_", "");
        } else {
            return "Çözülemedi!";
        }
    }
}
