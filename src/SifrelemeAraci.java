public class SifrelemeAraci {
    private ISifreleyici sifreleyici;

    public SifrelemeAraci(String algoritmaTipi) {
        // Artık if-else ile kendim yaratmıyorum. Fabrika sınıfına devrettim.
        SifrelemeFabrikasi fabrika = new SifrelemeFabrikasi();
        this.sifreleyici = fabrika.sifreleyiciUret(algoritmaTipi);
    }

    public String sifrele(String metin) {
        return this.sifreleyici.sifrele(metin);
    }

    public String coz(String sifreliMetin) {
        return this.sifreleyici.coz(sifreliMetin);
    }
}
