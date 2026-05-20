# Faz 3: AI Log - Behavioral Patterns (Strategy & Observer)

**AI ile Pair Programming Özeti (30 Dakika):**
Bu fazda yapay zeka ile sistemi çalışma zamanında nasıl daha esnek hale getirebileceğimi uzun uzun tartıştım. 
İlk olarak "Uygulama çalışırken kullanıcı AES'ten RSA'ya geçmek isterse ne yapmalıyım?" diye sordum. AI, **Strategy Pattern**'i önerdi. Zaten arayüzümüz (`ISifreleyici`) olduğu için bunu yapmak çok kolaydı. Tek yapmamız gereken `SifrelemeAraci` sınıfına bir `setStrateji` metodu eklemekti. Bu sayede OCP (Açık/Kapalı Prensibi) harika bir şekilde uygulandı; sınıfın koduna dokunmadan yeni davranışlar kazandırabildim.

Daha sonra "Şifreleme yapıldığında bunu bir dosyaya veya konsola yazdırmak istiyorum, ama şifreleme sınıfının içine System.out.println yazmak istemiyorum" dedim. AI bana **Observer (Gözlemci) Pattern**'i anlattı. Bir `IGozlemci` arayüzü ve bunu uygulayan bir `KonsolLogger` yazdık. Şifreleme aracı işlem yaptığında, kayıtlı tüm gözlemcilere "işlem bitti" diye haber veriyor.

**Yapay Zeka Olmadan Bu Faz Ne Kadar Sürerdi?**
Eğer AI bana Observer ve Strategy kelimelerini vermeseydi, muhtemelen Google'da "Java runtime change variable" ya da "Java log when method called" gibi şeyler aratıp saatlerce yığınla alakasız makale okuyacaktım. Tahminen 3-4 saatimi alırdı. AI sayesinde ne yapacağımı tam olarak bilerek ilerledim ve 45 dakikada bitirdim.

**AI Beni Nerede Yanılttı?**
Observer Pattern'i uygularken AI, `SifrelemeAraci` sınıfının Java'nın gömülü `Observable` sınıfından kalıtım almasını önerdi. Fakat araştırdığımda Java'nın kendi `Observable` sınıfının çoktan "deprecated" (kullanımdan kaldırılmış) olduğunu öğrendim. AI eski bilgilerle konuşmuştu. Onu dinlemeyip kendi `IGozlemci` yapımı (Custom Observer) sıfırdan kurdum. Bu benim için aydınlatıcı bir an oldu, AI'ın verdiği kodu her zaman körü körüne almamak gerektiğini anladım.
