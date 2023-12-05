package Forms;

import Models.Ders;
import Models.Ogrenci;
import Services.LessonsService.DersBilgisiCekici;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OgrenciKayitFormu extends JFrame {
    private JTextField ogrenciNoField;
    private JTextField ogrenciAdField;
    private JTextField ogrenciSoyadField;
    private JTextField ogrenciBolumField;
    private JComboBox<String> derslerComboBox;
    private DersBilgisiCekici dersBilgisiCekici;

    public OgrenciKayitFormu() {
        ogrenciNoField = new JTextField(20);
        ogrenciAdField = new JTextField(20);
        ogrenciSoyadField = new JTextField(20);
        ogrenciBolumField = new JTextField(20);

        // DersBilgisiCekici'yi uygun dosya yoluyla başlatın
        dersBilgisiCekici = new DersBilgisiCekici("C:\\Users\\90507\\IdeaProjects\\StudentApp\\ders_bilgileri.txt");

        List<String> dersAdlari = dersBilgisiCekici.dersAdlariniCek();
        String[] dersler = dersAdlari.toArray(new String[0]);
        derslerComboBox = new JComboBox<>(dersler);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ogrenciNo = ogrenciNoField.getText();
                String ogrenciAd = ogrenciAdField.getText();
                String ogrenciSoyad = ogrenciSoyadField.getText();
                String ogrenciBolum = ogrenciBolumField.getText();
                String seciliDers = (String) derslerComboBox.getSelectedItem();
                System.out.println(seciliDers);

                Ogrenci ogrenci = new Ogrenci(ogrenciNo, ogrenciAd, ogrenciSoyad, ogrenciBolum);
                ogrenci.dersEkle(new Ders(seciliDers, "", ""));

                // Verileri dosyaya kaydet
                kaydetDosyaya(ogrenci);

                System.out.println("Öğrenci Kaydedildi: " + ogrenciNo + " - " + ogrenciAd + " - " + ogrenciSoyad + " - " + ogrenciBolum + " - " + seciliDers + " - ");
            }
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Öğrenci No:"));
        add(ogrenciNoField);
        add(new JLabel("Öğrenci Adı:"));
        add(ogrenciAdField);
        add(new JLabel("Öğrenci Soyadı:"));
        add(ogrenciSoyadField);
        add(new JLabel("Öğrenci Bölümü:"));
        add(ogrenciBolumField);
        add(new JLabel("Ders Seçimi:"));
        add(derslerComboBox);
        add(new JLabel(""));
        add(kaydetButton);

        setTitle("Öğrenci Kayıt Formu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void kaydetDosyaya(Ogrenci ogrenci) {
        String dosyaAdi = "ogrenci_bilgileri.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            StringBuilder kayit = new StringBuilder();
            kayit.append("Öğrenci No: ").append(ogrenci.getOgrenciNo()).append(", ");
            kayit.append("Ad: ").append(ogrenci.getOgrenciAd()).append(", ");
            kayit.append("Soyad: ").append(ogrenci.getOgrenciSoyad()).append(", ");
            kayit.append("Bölüm: ").append(ogrenci.getOgrenciBolum()).append(", ");
            kayit.append("Seçili Ders: ").append(ogrenci.getOgrencidDersler().toString()).append(", ");

            writer.write(kayit.toString());
            writer.newLine();
            System.out.println("Öğrenci bilgileri dosyaya kaydedildi: " + kayit.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
