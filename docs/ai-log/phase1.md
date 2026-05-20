# Faz 1: AI Log - Creational Pattern (Factory Method)

**AI'a sorduğum soru (Prompt):**
> "Spagetti olan `SifrelemeAraci.java` kodumu nesne yaratma sorumluluğu açısından nasıl düzeltebilirim? Factory Method uygulamak istiyorum. Bana bir örnek yapabilir misin ama direkt kodu kopyala yapıştır yapmayayım, mantığını açıkla."

**AI'ın Yanıtı (Özet):**
AI bana `SifrelemeAraci` sınıfımın içinde nesne yaratma sorumluluğunun çok fazla olduğunu, `if-else` yapısının yeni bir algoritma eklendiğinde patlamaya hazır bir bomba olduğunu söyledi.
Mantık olarak şu adımları izlememi önerdi:
1. Tüm algoritmaların ortak metodlarını belirten bir `ISifreleyici` arayüzü oluştur. (Bu sayede polimorfizm kullanabileceğiz)
2. `AesSifreleyici`, `RsaSifreleyici` gibi sınıfları bu arayüzden uygulat (implements).
3. Bu sınıfların objelerini üretme işini `SifrelemeFabrikasi` isimli yeni bir sınıfa devret.
4. `SifrelemeAraci` sadece bu fabrikayı çağırsın ve dönen arayüzü kullansın.

**Ben Ne Uyguladım ve Neden?**
AI'ın önerdiği adımları harfiyen uyguladım. `ISifreleyici` adında bir interface açtım. Sonra eski kodumdaki if'lerin içindeki metinleri alıp `AesSifreleyici`, `RsaSifreleyici` sınıflarına dağıttım. `SifrelemeFabrikasi` sınıfını da yazdım.
Önceden `new SifrelemeAraci("AES")` dediğimde içindeki if'e girip işlem yapıyordu, şimdi algoritmayı fabrika üretiyor. Eskisinden daha fazla dosyam oldu (1 dosya yerine 5 dosya) ama şu an anladım ki yeni bir yöntem (örn. DES) ekleyeceksem sadece `DesSifreleyici` sınıfı yazıp fabrikaya tek bir `else if` eklemem yetecek. Ana şifreleme aracımın içine dokunmamış olacağım (SRP prensibi!).
