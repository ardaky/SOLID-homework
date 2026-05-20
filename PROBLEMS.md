# Başlangıç Kodundaki Sorunlar (Faz 0)

## Benim Tespit Ettiğim Sorunlar (Öğrenci Gözünden)

Kodu yazdıktan sonra şöyle bir baktım ve şu sorunları fark ettim:

1. **Çok fazla if-else var:** Yeni bir şifreleme eklemek istersem (örneğin DES) constructor, sifrele ve coz metodlarının hepsine tek tek yeni bir "else if" yazmam gerekecek. Bu çok yorucu ve hata yapmaya açık.
2. **Her şey tek bir dosyada:** AES, RSA, Base64 gibi mantıkların hepsi tek bir SifrelemeAraci sınıfı içinde. Sınıf ileride yüzlerce satır olacak gibi duruyor.
3. **Seçim baştan yapılıyor:** `new SifrelemeAraci("AES")` dedikten sonra algoritmayı değiştiremiyorum. Program çalışırken fikrimi değiştirip RSA yapmak istesem yeni bir obje yaratmam gerekecek.
4. **Kod kendini tekrar ediyor:** sifrele ve coz metodlarındaki if-else mantıkları birbiriyle neredeyse aynı şekilde kurgulanmış. Sürekli kopyala yapıştır yapmak zorunda kaldım.
5. **Algoritmalar gerçek değil, sadece String dönüyor:** İleride gerçekten RSA kütüphanesi entegre etmek istersem `SifrelemeAraci` çok karmaşık bir hal alacak, kütüphane kodları da bu sınıfı şişirecek.

---

## AI (Claude / ChatGPT) Ne Dedi?

**Sorduğum Prompt:** 
> "Bu kodda hangi tasarım sorunlarını görüyorsun? Hangi tasarım örüntüleri bu sorunları çözebilir? Her sorun için kısa bir açıklama yaz."

**AI'ın Yanıtı:**
Merhaba! Paylaştığınız kod parçası, nesne yönelimli tasarım prensiplerinden (özellikle SOLID) birkaçını ihlal eden klasik bir **"God Class" (Tanrı Sınıfı)** örneğidir. İşte tespit ettiğim temel sorunlar ve çözüm önerilerim:

1. **Açık/Kapalı Prensibi (Open/Closed Principle - OCP) İhlali:**
   * **Sorun:** Sınıf, genişlemeye açık ancak değişime kapalı olmalıdır. Sizin kodunuzda yeni bir şifreleme algoritması (örn. DES veya Blowfish) eklemek için hem constructor hem de `sifrele` ve `coz` metodlarındaki `if-else` zincirlerini değiştirmeniz gerekiyor. Bu, mevcut çalışan kodu kırma riski taşır.
   * **Çözüm (Örüntü):** **Strategy Pattern (Strateji Örüntüsü)**. Her bir algoritmayı ortak bir interface'den (`ISifrelemeStratejisi`) türeyen ayrı sınıflar (örn. `AesSifreleyici`, `RsaSifreleyici`) haline getirerek çözebilirsiniz.

2. **Tek Sorumluluk Prensibi (Single Responsibility Principle - SRP) İhlali:**
   * **Sorun:** `SifrelemeAraci` sınıfı hem nesnenin yaratılışından (hangi algoritmanın seçileceği) hem de iş sürecinden (şifreleme ve çözme) sorumlu. Bir sınıfın değişmek için tek bir nedeni olmalıdır.
   * **Çözüm (Örüntü):** **Factory Method** veya **Simple Factory**. Algoritmaların yaratılma sorumluluğunu bir fabrikaya (`SifrelemeFabrikasi`) devrederek bu sınıfı rahatlatabilirsiniz.

3. **Esneklik Eksikliği (Run-time Binding):**
   * **Sorun:** Algoritma seçimi constructor'da string olarak alınıyor ve sonrasında değiştirilemiyor. Çalışma zamanında (runtime) dinamik bir geçiş yapmak istediğinizde yapı buna izin vermiyor.
   * **Çözüm (Örüntü):** Yine **Strategy Pattern** kullanarak setter metodları üzerinden (`setAlgoritma(ISifrelemeStratejisi yeniStrateji)`) algoritmayı runtime'da değiştirebilirsiniz.

4. **Bağımlılıkların Tersine Çevrilmesi Prensibi (Dependency Inversion) İhlali:**
   * **Sorun:** İleride dışarıdan alınacak (3rd party) bir Legacy şifreleme kütüphanesi kullanmak isterseniz, mevcut `if-else` yapısına bunu uydurmak için büyük değişiklikler yapmanız gerekecektir.
   * **Çözüm (Örüntü):** **Adapter Pattern (Adaptör Örüntüsü)** kullanarak dış kütüphaneleri kendi sisteminize bir arayüz (interface) ile bağlayabilirsiniz.

---

## AI ile Kendi Analizimin Karşılaştırması

AI'ın söylediklerini okuyunca aslında mantık olarak aynı şeyleri fark ettiğimizi gördüm. Ben amatörce "Çok fazla if-else var" demiştim, AI buna havalı bir şekilde **Açık/Kapalı Prensibi (OCP)** dedi. Ben "Her şey tek bir dosyada" dedim, o buna **Tek Sorumluluk Prensibi (SRP)** dedi.
Özellikle "Strategy Pattern" ve "Factory Pattern" isimlerini AI'dan ilk defa duymuş oldum ama anladığım kadarıyla Factory Method ile ilk kısımdaki (constructor'daki nesne oluşturma) sorunu, Strategy Pattern ile de metodların içindeki if-else karmaşasını çözeceğiz. Açıkçası AI terimleri kullanınca daha profesyonel hissettirdi, şimdi bu tasarım örüntülerinin neden gerekli olduğunu daha iyi kavramaya başladım.
