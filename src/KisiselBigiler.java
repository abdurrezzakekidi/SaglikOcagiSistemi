import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KisiselBigiler extends JFrame implements ActionListener {


    JButton jButtonGeri = new JButton(" Geri ↺");
    JButton jButtonSifreDegistir = new JButton("ŞİFREYİ DEĞİŞTİR");
    JLabel jLabelKisiselBilgiler = new JLabel("KİŞİSEL BİLGİLER");
    String[] labelNames = {"Ad Soyad", "T.C", "Yas", " Email", "Telefon No"};
    JPanel panel = new JPanel(null);
    JPanel panel1 = new JPanel(null);
    JLabel jLabelBilgiler;


    JLabel imageContainer;
    ImageIcon image;


    public KisiselBigiler(String[] bilgiler) {
        this.setTitle("KİŞİSEL BİLGİLER");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        panel.setBounds(0, 0, 1200, 80);
        panel.setBackground(new Color(0x4A4A4A));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < bilgiler.length; i++) {
            jLabelBilgiler = new JLabel(labelNames[i] + " " + bilgiler[i]);
            jLabelBilgiler.setFont(new Font("Inter", Font.BOLD, 20));
            jLabelBilgiler.setForeground(new Color(0xffffff));
            jLabelBilgiler.setBounds(600, 197 + (i*20), 263, 273);
            this.add(jLabelBilgiler);

        }

        jLabelKisiselBilgiler.setFont(new Font("Inter", Font.BOLD, 40));
        jLabelKisiselBilgiler.setForeground(new Color(0xffffff));
        jLabelKisiselBilgiler.setBounds(20, 0, 460, 80);
        panel1.setBounds(113, 134, 974, 532);
        panel1.setBackground(new Color(0x4A464A));


        image = new ImageIcon("src/image1/k.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(160, 190, 200, 200);


        jButtonGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonGeri.setBounds(5, 685, 130, 60);
        jButtonGeri.setForeground(new Color(0xFFFFFF));
        jButtonGeri.setBackground(Color.decode("#4A4A4A"));


        jButtonSifreDegistir.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonSifreDegistir.setBounds(500, 350, 250, 65);
        jButtonSifreDegistir.setForeground(new Color(000000));
        jButtonSifreDegistir.setBackground(Color.decode("#939393"));
        jButtonSifreDegistir.addActionListener(this);

        jButtonGeri.addActionListener((ActionListener) this);
        this.add(jButtonGeri);

        panel.add(jLabelKisiselBilgiler);
        this.add(panel);

        panel1.add(imageContainer);
        panel1.add(jButtonSifreDegistir);
        this.add(panel1);


    }

    public KisiselBigiler() {
        //  şu constractoru geri buttonu için kullandım
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonGeri) {
            new KullaniciSistemi();
            dispose();

        } else if (e.getSource() == jButtonSifreDegistir) {
            new SifreDegistirme();
            dispose();
        }

    }

}
