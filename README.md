Öğrenci ve Ders Kayıt Uygulaması
Bu uygulama, öğrenci ve ders kayıtlarını tutan bir Java Swing uygulamasıdır. Uygulama, kullanıcıya ders kaydı ve öğrenci kaydı yapma imkanı sunar. Ayrıca, ders adlarını içeren bir dosyadan ders bilgilerini çeker ve öğrenci kaydı yapılırken bu derslerden seçim yapılmasını sağlar.Bu uygulama Intellij ideada yazılmıştır.

Ders Kayıt Formu (DersKayitFormu)
Bu form, kullanıcıdan ders kodu, ders adı ve ders dönemi bilgilerini alır. Kullanıcı, "Kaydet" butonuna tıkladığında, girilen bilgileri içeren bir Ders nesnesi oluşturulur ve bu bilgiler bir metin dosyasına kaydedilir. Form, kullanıcıya hata durumları hakkında bilgi vermez.

Öğrenci Kayıt Formu (OgrenciKayitFormu)
Bu form, öğrenci bilgilerini ve öğrencinin aldığı dersleri kaydetmeyi sağlar. Kullanıcı, öğrenci numarası, adı, soyadı, bölümü ve bir ders seçimi yapar. Seçilen ders, öğrenciye atanır ve öğrenci bilgileri ile birlikte bir metin dosyasına kaydedilir. Form, kullanıcıya hata durumları hakkında bilgi vermez.

Proje Menü Formu (ProjeMenuFormu)
Bu form, uygulamanın ana menüsünü oluşturur. Ana menüde "Ders Kayıt Formu" ve "Öğrenci Kayıt Formu" adlı iki buton bulunur. Her bir butona tıklanması durumunda ilgili form görüntülenir.

Model Sınıfları (Ders ve Ogrenci)
Ders: Ders kayıtlarını temsil eder. Her bir ders, ders kodu, adı ve dönemi bilgilerini içerir.
Ogrenci: Öğrenci kayıtlarını temsil eder. Her bir öğrenci, öğrenci numarası, adı, soyadı, bölümü ve aldığı dersleri içeren bir liste bilgisi taşır.
Servis Sınıfı (DersBilgisiCekici)
Bu sınıf, ders bilgilerini bir dosyadan okuyarak ders adlarını liste halinde çeker. Bu sınıf, DersKayitFormu ve OgrenciKayitFormu sınıflarında ders adlarını görüntülemek için kullanılır.

Main Sınıf (ProjeMain)
Bu sınıf, uygulamayı başlatan ana sınıftır. ProjeMenuFormu'nu görüntüler ve uygulamayı kullanıcıya açar.
