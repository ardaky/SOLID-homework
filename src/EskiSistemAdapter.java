public class EskiSistemAdapter implements ISifreleyici {
    private EskiSistem eskiSistem;

    public EskiSistemAdapter(EskiSistem eskiSistem) {
        this.eskiSistem = eskiSistem;
    }

    @Override
    public String sifrele(String metin) {
        return eskiSistem.karmasikSifrelemeYap(metin);
    }

    @Override
    public String coz(String sifreliMetin) {
        return eskiSistem.karmasikCozumlemeYap(sifreliMetin);
    }
}
