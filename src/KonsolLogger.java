public class KonsolLogger implements IGozlemci {
    @Override
    public void islemYapildi(String mesaj) {
        System.out.println("[LOG - GOZLEMCi]: " + mesaj);
    }
}
