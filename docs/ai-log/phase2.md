# Faz 2: AI Log - Structural Patterns (Decorator & Adapter)

**AI'a sorduğum soru (Prompt):**
> "Projeme dışarıdan bulduğum eski bir şifreleme kütüphanesini (EskiSistem) dahil etmek istiyorum ama metot isimleri benim `ISifreleyici` arayüzüme hiç uymuyor. Bunu entegre etmek için Adapter pattern mi daha uygun, yoksa Facade mı? Farkını açıkla."

**AI'ın Yanıtı (Özet):**
AI bana burada kesinlikle **Adapter Pattern** kullanmam gerektiğini söyledi. Nedenlerini şu şekilde açıkladı:
*   **Adapter:** Var olan ama senin sisteminin arayüzüne (interface) uymayan bir sınıfı (EskiSistem), senin sisteminin anladığı dile (`ISifreleyici`) çevirir. Bir nevi priz dönüştürücü gibidir.
*   **Facade:** Çok karmaşık, alt sistemlerden oluşan bir kütüphaneyi daha kolay kullanmak için basit, tek bir arayüz sunar. Amacı uyumsuzluğu çözmek değil, karmaşıklığı gizlemektir.
Senin durumunda, `EskiSistem` sınıfının `karmasikSifrelemeYap` gibi uyumsuz metotlarını `sifrele` metoduna adapte etmen gerektiği için Facade değil, Adapter kullanmalısın.

**Yanıltıcı/Eksik Bir Şey Var mıydı? (Refleksiyon):**
AI'ın Adapter ve Facade ayrımı çok netti ve mantıklı geldi. Ancak AI, Adapter'ı uygularken `EskiSistem`'den kalıtım (inheritance) alarak yapmamı (Class Adapter) da bir seçenek olarak sundu. Fakat Java'da çoklu kalıtım olmadığı için ve kalıtımın esnekliği azalttığı için, ben *Composition* (nesneyi içinde tutma) mantığını kullanan **Object Adapter** yöntemini seçtim. AI bu dezavantajı başta belirtmemişti, sonradan "Hangisi daha iyi?" diye sorunca Object Adapter'ı övdü. Yani AI'ın ilk önerisini direkt alsaydım daha katı bir tasarımım olacaktı.

Ayrıca ek olarak, şifrelenen metinlerin başına "Zaman Damgası" eklemek istiyordum, bunun için de sınıfları bozmadan özellik ekleyebilen **Decorator Pattern**'i kullandım.
