public class SifrelemeFabrikasi {
    public ISifreleyici sifreleyiciUret(String algoritmaTipi) {
        if (algoritmaTipi.equalsIgnoreCase("AES")) {
            return new AesSifreleyici();
        } else if (algoritmaTipi.equalsIgnoreCase("RSA")) {
            return new RsaSifreleyici();
        } else if (algoritmaTipi.equalsIgnoreCase("Base64")) {
            return new Base64Sifreleyici();
        }
        throw new IllegalArgumentException("Desteklenmeyen algoritma tipi: " + algoritmaTipi);
    }
}
