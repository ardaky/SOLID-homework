public abstract class SifreleyiciDecorator implements ISifreleyici {
    protected ISifreleyici sarmalananSifreleyici;

    public SifreleyiciDecorator(ISifreleyici sarmalananSifreleyici) {
        this.sarmalananSifreleyici = sarmalananSifreleyici;
    }

    @Override
    public String sifrele(String metin) {
        return sarmalananSifreleyici.sifrele(metin);
    }

    @Override
    public String coz(String sifreliMetin) {
        return sarmalananSifreleyici.coz(sifreliMetin);
    }
}
