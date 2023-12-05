package Forms;

import Models.Ders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DersKayitFormu extends JFrame {
    private JTextField dersKoduField;
    private JTextField dersAdField;
    private JTextField dersDonemField;

    public DersKayitFormu() {
        dersKoduField = new JTextField(20);
        dersAdField = new JTextField(20);
        dersDonemField = new JTextField(20);

        JButton kaydetButton = new JButton("Kaydet");
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dersKodu = dersKoduField.getText();
                String dersAd = dersAdField.getText();
                String dersDonem = dersDonemField.getText();

                Ders ders = new Ders(dersKodu, dersAd, dersDonem);

                // Verileri dosyaya kaydet
                kaydetDosyaya(ders);

                System.out.println("Ders Kaydedildi: " + dersKodu + " - " + dersAd + " - " + dersDonem);
            }
        });

        setLayout(new GridLayout(4, 2));
        add(new JLabel("Ders Kodu:"));
        add(dersKoduField);
        add(new JLabel("Ders Adı:"));
        add(dersAdField);
        add(new JLabel("Ders Dönemi:"));
        add(dersDonemField);
        add(new JLabel(""));
        add(kaydetButton);

        setTitle("Ders Kayıt Formu");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void kaydetDosyaya(Ders ders) {
        String dosyaAdi = "ders_bilgileri.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            StringBuilder kayit = new StringBuilder();
            kayit.append("Ders Kodu: ").append(ders.getDersKodu()).append(", ");
            kayit.append("Ders Adı: ").append(ders.getDersAd()).append(", ");
            kayit.append("Ders Dönemi: ").append(ders.getDersDonem());

            writer.write(kayit.toString());
            writer.newLine();
            System.out.println("Ders bilgileri dosyaya kaydedildi: " + kayit.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DersKayitFormu().setVisible(true);
            }
        });
    }
}
