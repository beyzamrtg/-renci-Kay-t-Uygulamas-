package Services;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class LessonsService {

    public static class DersBilgisiCekici {

        private String dosyaYolu;

        public DersBilgisiCekici(String dosyaYolu) {
            this.dosyaYolu = dosyaYolu;
        }

        public List<String> dersAdlariniCek() {
            List<String> dersAdlari = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {

                String satir;

                while ((satir = reader.readLine()) != null) {
                    if (satir.contains("Ders Adı")) {
                        String dersAdi = satir.split(",")[1].trim();
                        dersAdi = dersAdi.split("Ders Adı: ")[1].trim();  // Değerini güncelledik
                        dersAdlari.add(dersAdi);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return dersAdlari;
        }

        public static void main(String[] args) {
            DersBilgisiCekici cekici = new DersBilgisiCekici("C:\\Users\\90507\\IdeaProjects\\StudentApp\\ders_bilgileri.txt");
            List<String> dersAdlari = cekici.dersAdlariniCek();

            System.out.println("Ders Adları:");
            for (String dersAdi : dersAdlari) {
                System.out.println(dersAdi);
            }
        }
    }
}
