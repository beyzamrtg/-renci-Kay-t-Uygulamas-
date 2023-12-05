package Services;

import Forms.ProjeMenuFormu;

import javax.swing.*;

public class ProjeMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProjeMenuFormu projeMenuFormu = new ProjeMenuFormu();
                projeMenuFormu.setVisible(true);
            }
        });
    }
}
