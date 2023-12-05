package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjeMenuFormu extends JFrame {
    public ProjeMenuFormu() {
        JButton dersKayitButton = new JButton("Ders Kayıt Formu");
        JButton ogrenciKayitButton = new JButton("Öğrenci Kayıt Formu");

        DersKayitFormu dersKayitFormu = new DersKayitFormu();
        OgrenciKayitFormu ogrenciKayitFormu = new OgrenciKayitFormu();

        dersKayitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dersKayitFormu.setVisible(true);
            }
        });

        ogrenciKayitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenciKayitFormu.setVisible(true);
            }
        });

        setLayout(new FlowLayout());
        add(dersKayitButton);
        add(ogrenciKayitButton);

        setTitle("Proje Menü Formu");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

