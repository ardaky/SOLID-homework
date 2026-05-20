# Pull Request Açıklaması (Phase-2 -> Main)

## Hangi Örüntüyü Uyguladım?
Bu PR'da iki adet Structural (Yapısal) örüntü uyguladım: **Decorator** ve **Adapter**.

## Neden Bu Örüntüleri Seçtim?
1. **Decorator:** Şifrelenen verilere loglama amacı taşıyan bir "Zaman Damgası" eklemek istiyordum. Sınıfların (örneğin `AesSifreleyici`) içindeki kodları bozmadan, dışarıdan onlara ekstra bir özellik giydirebilmek için Decorator seçtim.
2. **Adapter:** Sisteme dışarıdan (hayali) entegre edilen `EskiSistem` adlı legacy kütüphaneyi kullanmak zorundaydık. Metot isimleri benim `ISifreleyici` arayüzüme uymuyordu. Uyumsuzluğu gidermek için Adapter yazdım.

## Alternatifleri Neden Reddettim?
*   Adapter yerine **Facade** kullanabilirdim. Ama Facade, kompleks sistemleri basitleştirmek için kullanılır, benim sorunum komplekslik değil, arayüz uyumsuzluğuydu. O yüzden reddettim.
*   Decorator yerine **Kalıtım (Inheritance)** ile `AesZamanDamgaliSifreleyici`, `RsaZamanDamgaliSifreleyici` diye alt sınıflar açabilirdim. Ama bu, sınıf patlamasına (class explosion) yol açardı, o yüzden kalıtımı reddedip Decorator (Composition) kullandım.

---

### Self-Review (Kendi Kendime Kod İncelemesi) Yorumlarım
*   **Yorum 1 (ZamanDamgaliSifreleyici.java - Satır 17):** "Burada deşifreleme yaparken string'den zaman damgasını kesip atarken `indexOf` kullandım. Çok amatörce olmuş, ileride Regex kullanırsam daha güvenilir (robust) olur."
*   **Yorum 2 (EskiSistemAdapter.java):** "Adapter sınıfında Object Adapter kullandım (nesneyi inject ettim). Class Adapter yapıp kalıtım alsaydım Java'nın tekli kalıtım kısıtlamasına takılabilirdim, doğru karar vermişim."
