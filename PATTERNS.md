# Tasarım Örüntüleri Dokümantasyonu

## Faz 1 - Factory Method (Creational)

**Nerede Uygulandı?**
`SifrelemeFabrikasi` sınıfında uygulandı.

**Neden Uygulandı?**
Eski yapıda nesne yaratma mantığı (hangi algoritmanın seçileceği) ile iş mantığı (şifreleme süreci) aynı sınıf (`SifrelemeAraci`) içerisindeydi. Yeni bir şifreleme algoritması ekleneceğinde mevcut sınıfın değişmesi gerekiyordu (Single Responsibility ve Open/Closed prensibi ihlalleri).

**Ne Kazandık?**
Nesne üretme sorumluluğunu fabrikaya devrederek sınıfların birbirine sıkı sıkıya bağlı (tight coupling) olmasını engelledik. Yeni bir şifreleme algoritması geldiğinde sadece fabrikayı güncelleyip yeni bir sınıf eklemek yetecek.

### UML Sınıf Diyagramı (Önce ve Sonra)

```mermaid
classDiagram
    direction LR
    class EskiSifrelemeAraci {
        -String algoritma
        +SifrelemeAraci(algoritmaTipi: String)
        +sifrele(metin: String): String
        +coz(sifreliMetin: String): String
    }
    note for EskiSifrelemeAraci "Tek ve kocaman bir sınıf. \nHer şey bunun içinde."
```

```mermaid
classDiagram
    direction TB
    class ISifreleyici {
        <<interface>>
        +sifrele(metin: String): String
        +coz(sifreliMetin: String): String
    }
    
    class AesSifreleyici {
        +sifrele(metin: String): String
        +coz(sifreliMetin: String): String
    }
    
    class RsaSifreleyici {
        +sifrele(metin: String): String
        +coz(sifreliMetin: String): String
    }
    
    ISifreleyici <|.. AesSifreleyici
    ISifreleyici <|.. RsaSifreleyici
    
    class SifrelemeFabrikasi {
        +sifreleyiciUret(tip: String): ISifreleyici
    }
    
    class SifrelemeAraci {
        -ISifreleyici sifreleyici
        +SifrelemeAraci(tip: String)
        +sifrele(metin: String): String
    }
    
    SifrelemeFabrikasi ..> ISifreleyici : "Üretir"
    SifrelemeAraci --> SifrelemeFabrikasi : "Kullanır"
    SifrelemeAraci --> ISifreleyici : "Bağlıdır"
```
