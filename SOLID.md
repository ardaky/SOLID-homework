🏗

**EVRİMLEŞEN SİSTEM**

Yazılım Tasarım Örüntüleri — Bireysel Ödev

_2025 – 2026 Güz / Bahar Dönemi_

|   |   |
|---|---|
|**📅  Teslim Tarihi**|15 Mayıs 2026 Cuma|
|**👥  Çalışma Şekli**|Bireysel + AI|
|**📦  Teslim Ortamı**|GitHub repository linki (LMS üzerinden)|
|**⏱  Toplam Tahmini Süre**|23 - 31 Saat|

  

# 1. Genel Bakış

Bu ödevde boş bir proje başlatıyorsunuz. Bu yaklaşımın amacı şudur: tasarım örüntülerini soyut bir kavram olarak değil, gerçek bir ihtiyacın çözümü olarak öğrenmek.

|   |
|---|
|**💡 Temel Felsefe**<br><br>Tasarım örüntüsü, bir sorunun farkında olduğunuzda anlamlıdır. Önce acıyı hissedeceksiniz — sonra çözümü uygulayacaksınız.|

**Üç faz boyunca şu araçları aktif olarak kullanacaksınız:**

•        GitHub: branch yönetimi, commit geçmişi, Pull Request, README

•        Yapay Zeka araçları: kod analizi, örüntü tartışması, pair programming

•        UML: sınıf ve ilişki diyagramları (her faz için)

# 2. Konu Seçimi

Aşağıdaki konu seçeneklerinden birini seçin. Her konu için sıfırdan başlayacaksınız.

|   |   |   |
|---|---|---|
|**#**|**Konu**|**Başlnagıç Kodunun Sorunu**|
|**A**|**Bildirim Sistemi**|Tüm bildirim tipleri (e-posta, SMS, push) tek bir sınıfta. if-else zincirleri ile tip kontrolü yapılıyor.|
|**B**|**Dosya Dönüştürücü**|Desteklenen format sayısı artıkça switch-case blokları büyüyor; her format bağımsız nesne olarak ele alınmıyor.|
|**C**|**Mini Oyun Motoru**|Oyun nesneleri (oyuncu, düşman, nesne) aynı sınıftan türetilmiş; davranış farkları if blokları ile ayrılıyor.|
|**D**|**E-Ticaret Sepeti**|İndirim hesaplamaları sepet sınıfına gömülü; yeni indirim kuralı eklemek mevcut kodu kırar.|
|**E**|**Şifreleme Aracı**|Algoritma seçimi (AES, RSA, Base64) constructor'da sabit kodlanmış; runtime değişimine kapalı.|

Konuyu seçtikten sonra README'nin en üstüne seçiminizin harfini ve gerekçenizi (2-3 cümle) yazın.

# 3. Fazlar

|   |   |
|---|---|
|**FAZ 0**|**Başlangı. Kodunu Anlama (Hazırlık)**|

Bu faz puanlanmaz ancak sonraki fazların temeli olduğundan atlanamaz.

**Yapmanız gerekenler:**

1.     GitHub'da yeni bir repository oluşturun (public).

2.     Projenin ilk kodlarını hiçbir tasarım mimarisi bilinci olmadan yazın.

3.     Kodu okuyun ve PROBLEMS.md adında bir dosya oluşturun. Bu dosyada:

◦        _Hangi tasarım sorunlarını gördüğünüzü listeleyin (en az 5 sorun)_

◦        _Her sorun için neden sorun olduğunu açıklayın (1-2 cümle)_

4.     Yapay zeka aracına (Claude, ChatGPT, Copilot vb.) kodu gösterin ve şunu sorun:

|   |
|---|
|**🤖 Önerilen AI Prompt**<br><br>"Bu kodda hangi tasarım sorunlarını görüyorsun? Hangi tasarım örüntüleri bu sorunları çözebilir? Her sorun için kısa bir açıklama yaz."|

5.     AI'ın cevabını kendi listenizle karşılaştırın. PROBLEMS.md'ye bir bölüm ekleyin: AI ne gördü, siz ne gördünüz, aralarında fark var mı?

|   |   |
|---|---|
|**FAZ 1**|**Creational Örüntüler (25 Puan)**|

Nesne yaratma sorumluluğunu merkezi ve esnek bir yapıya taşıyın.

**Gereksinimler:**

•        En az 1 Creational örüntü uygulayın

•        Uygun örnekler: Factory Method, Abstract Factory, Builder, Prototype, Singleton

**GitHub gereksinimleri:**

•        phase-1 adlı yeni bir branch açın (main'den)

•        Her örüntü için ayrı bir commit yazın. Örnek format:

◦        _feat: apply Factory Method for notification type creation_

◦        _refactor: extract object creation from God Class_

•        PROBLEMS.md'de tespit ettiğiniz nesne yaratma sorununu kapatan bir GitHub Issue açın ve bunu çözen PR ile kapatın

**AI kullanımı:**

•        AI'dan bu faz için bir kod review isteyin

•        AI'ın önerdiği çözümü direkt kopyalamayın. Önce anlayın, sonra kendi elinizle yazın

•        docs/ai-log/phase1.md dosyasına şunları ekleyin:

◦        _AI'a ne sordunuz (prompt)_

◦        _AI ne yanıtladı (özet)_

◦        _Siz ne uyguladınız ve neden farklı/aynı_

**Belgeleme:**

•        PATTERNS.md'ye bu fazdaki örüntüyü ekleyin: nerede, neden, ne kazandınız

•        Önce/sonra UML sınıf diyagramı ekleyin

|   |   |
|---|---|
|**FAZ 2**|**Structural Örüntüler (30 Puan)**|

Sisteme yeni özellikler ekleyin — mevcut kodu kırmadan.

**Gereksinimler:**

•        En az 2 Structural örüntü uygulayın

•        Uygun örnekler: Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Proxy

**GitHub gereksinimleri:**

•        phase-2 branch'ini phase-1'den açın (geçmiş korunuyor)

•        En az 1 Pull Request hazırlayın. PR açıklamasında:

◦        _Hangi örüntüyü uyguladığınız_

◦        _Neden bu örüntüyü seçtiğiniz_

◦        _Alternatifleri neden reddettiğiniz_

•        PR'ı kendiniz review edin ve en az 2 yorum bırakın

**AI kullanımı:**

•        AI'a şunları sorun ve yanıtları kaydedin:

◦        _"Adapter pattern burada uygun mu, yoksa Facade mı? Farkını açıkla."_

◦        _Ya da kendi durumunuza özgü bir örüntü seçim sorusu_

•        AI'ın yanlış veya eksik önerdiği bir şey buldunuz mu? Bunu docs/ai-log/phase2.md'ye yazın — bu bölüm kritik

**Belgeleme:**

•        PATTERNS.md'yi güncelleyin, her iki örüntü için ayrı bölüm ekleyin

•        Bu faz için mimari diyagram güncellemesi yapın

|   |   |
|---|---|
|**FAZ 3**|**Behavioral Örüntüler (35 Puan)**|

Sistemi gerçekten genişletilebilir yapın. Yeni bir davranış eklemek için mevcut kodu değiştirmek zorunda kalmamalısınız.

**Gereksinimler:**

•        En az 2 Behavioral örüntü uygulayın

•        Uygun örnekler: Observer, Strategy, Command, Iterator, Chain of Responsibility, State, Template Method, Visitor, Mediator

•        Açık/Kapalı Prensibini (OCP) en az bir noktada gösterin: mevcut kodu değiştirmeden yeni davranış

**GitHub gereksinimleri:**

•        main branch'e merge için profesyonel bir PR hazırlayın

•        Commit geçmişi temiz ve anlamlı olmalı (squash gerekebilir)

•        GitHub Actions ile basit bir CI pipeline ekleyin (derleme veya birim test)

•        README.md şunları içermeli:

◦        _Projenin ne yaptığı_

◦        _Kullanılan tüm örüntülerin listesi ve kısa açıklamaları_

◦        _Mimari diyagram (görsel)_

◦        _Nasıl çalıştırılır_

**AI kullanımı:**

•        Bu faz için AI ile en az 30 dakika pair programming yapın

•        Oturumu docs/ai-log/phase3.md'ye kaydedin: ne tartıştınız, nasıl ilerledi

•        Raporda şu soruyu yanıtlayın:

◦        _"AI olmadan bu faz ne kadar sürerdi? AI sizi nerede yanılttı?"_

# 4. Değerlendirme Kriterleri

|   |   |   |
|---|---|---|
|**Kriter**|**Ağırlık**|**Değerlendirme Odağı**|
|Tasarım Örüntüsü Doğruluğu|**%35**|Doğru örüntü seçimi, uygun bağlam, zorunluluk gerekçesi|
|GitHub Disiplini|**%20**|Commit geçmişi kalitesi, branch yapısı, PR içeriği|
|AI Refleksiyonu|**%20**|Eleştirel kullanım, hata tespiti, bağımsız değerlendirme|
|Kod Kalitesi|**%15**|Okunabilirlik, SOLID prensipleri, tutarlılık|
|Belgeleme|**%10**|PATTERNS.md, README, UML diyagramı|

|   |
|---|
|**⚠️ Dikkat**<br><br>AI çıktısını direkt kopyalamak sıfır puan alır. AI kullanımı teşvik edilir; fakat her kodun arkasında sizin anlayışınız ve kararlarınız olmalıdır.<br><br>•        Commit geçmişi tek commit'ten ibaretse GitHub puanı verilmez.<br><br>•        ai-log dosyaları boşsa veya sadece "AI yazdı, ben kopyaladım" içeriyorsa refleksiyon puanı verilmez.|

# 5. Teslimat Gereksinimleri

**Repository Yapısı**

|   |
|---|
|**📁 Beklenen Repository Yapısı**<br><br>├── README.md                  ← Mimari diyagram + kullanım<br><br>├── PATTERNS.md               ← Her örüntünün belgelenmesi<br><br>├── PROBLEMS.md               ← Başlangıç kodunun analizi (Faz 0)<br><br>├── src/                       ← Kaynak kod<br><br>├── docs/<br><br>│   ├── diagrams/              ← UML diyagramları<br><br>│   └── ai-log/<br><br>│       ├── phase1.md<br><br>│       ├── phase2.md<br><br>│       └── phase3.md<br><br>└── .github/workflows/ci.yml  ← GitHub Actions|

**Branch Yapısı**

•        main → temiz, merge edilmiş son durum

•        phase-1 → Creational çalışması

•        phase-2 → Structural çalışması (phase-1'den açılan)

•        phase-3 → Behavioral çalışması (phase-2'den açılan)

**LMS Teslimi**

•        GitHub repository linkinizi LMS'e yapıştırın

•        Repository public olmalıdır

•        Son commit tarihi teslim tarihini geçmemelidir

# 6. Akademik Dürüstlük & AI Politikası

|   |   |
|---|---|
|**✅  İzin Verilen**<br><br>•        AI araçlarıyla kod analizi ve tartışma<br><br>•        AI'ın önerdiği örüntüyü anlayıp kendi elinizle uygulamak<br><br>•        AI'ın önerdiğini reddetmek ve nedenini açıklamak<br><br>•        Hata ayıklamada AI'dan yardım almak<br><br>•        Stack Overflow, GitHub vb. kaynaklardan öğrenmek|**❌  Yasak**<br><br>•        AI çıktısını anlamadan kopyalamak<br><br>•        Başka öğrencinin kodunu kullanmak<br><br>•        Tek bir büyük commit (geçmiş manipülasyonu)<br><br>•        ai-log dosyalarını sahte içerikle doldurmak<br><br>•        Sözleşmeli yazılım veya hazır github projeleri kullanmak|

# 7. Önerilen Kaynaklar

**Tasarım Örüntüleri**

•        Refactoring.Guru — görsel ve interaktif açıklamalar (refactoring.guru/design-patterns)

•        Gang of Four — Design Patterns: Elements of Reusable Object-Oriented Software

•        Head First Design Patterns — Freeman & Robson

**GitHub & Git**

•        GitHub Docs: Hakkında Pull Requests (docs.github.com)

•        Conventional Commits spesifikasyonu (conventionalcommits.org)

•        GitHub Actions Quickstart (docs.github.com/actions)

**UML Araçları**

•        draw.io / diagrams.net (ücretsiz, tarayıcı tabanlı)

•        PlantUML (metin tabanlı diyagram, kodla entegre edilebilir)

•        Mermaid.js (README içine gömülebilir diyagram sözdizimi)

**AI Araçları**

•        Claude (claude.ai) — kod analizi ve tasarım tartışması

•        GitHub Copilot — IDE entegreli öneriler

•        ChatGPT — genel kodlama ve mimari sorguları

|   |
|---|
|**📬 Sorularınız İçin**<br><br>Ödev hakkındaki sorularınızı ders saatinde ya da e-posta ile iletebilirsiniz. GitHub issue'larınıza da bakılacaktır — sorunuzu public issue olarak açarsanız sınıfın tamamı yanıttan yararlanır.|

**Başarılar!**