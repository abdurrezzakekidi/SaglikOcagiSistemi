import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bolum1 extends JFrame implements ActionListener {
    JButton jButtonGeri = new JButton(" Geri ↺");

    JButton jButtonDoktor1 = new JButton(" Dr.Emel Atabay");
    JButton jButtonDoktor2 = new JButton("Dr.Harun Çağlar");

    JLabel jLabelBolum1 = new JLabel("Aile Hekimliği");

    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);

    JLabel imageContainer;
    ImageIcon image;


    public Bolum1() {
        this.setTitle("1.BÖLÜM");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        panel1.setBounds(0,0,1200,80);
        panel1.setBackground(new Color(0x4A4A4A));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        //panel2 image için kullandık.
        panel2.setBounds(286, 80, 914, 720);
        panel2.setBackground(new Color(0x4A464A));

        jLabelBolum1.setFont(new Font("Inter",Font.BOLD,36));
        jLabelBolum1.setForeground(new Color(0xffffff));
        jLabelBolum1.setBounds(20, 0, 460, 80);

        jButtonGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonGeri.setBounds(5, 700, 130, 60);
        jButtonGeri.setForeground(new Color(0xFFFFFF));
        jButtonGeri.setBackground(Color.decode("#4A4A4A"));
        jButtonGeri.addActionListener((ActionListener) this);

        jButtonDoktor1.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonDoktor1.setBounds(1, 101, 280, 70);
        jButtonDoktor1.setForeground(new Color(0xFFFFFF));
        jButtonDoktor1.setBackground(Color.decode("#4A4A4A"));
        jButtonDoktor1.addActionListener((ActionListener) this);

        jButtonDoktor2.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonDoktor2.setBounds(1, 188, 280, 70);
        jButtonDoktor2.setForeground(new Color(0xFFFFFF));
        jButtonDoktor2.setBackground(Color.decode("#4A4A4A"));
        jButtonDoktor2.addActionListener((ActionListener) this);

        image = new ImageIcon("src/image1/5.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(150,25, 600,720);

        this.add(jButtonGeri);

        panel1.add(jLabelBolum1);
        this.add(panel1);

        panel2.add(imageContainer);
        this.add(panel2);

        this.add(jButtonDoktor1);
        this.add(jButtonDoktor2);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButtonGeri){
            new Bolumler();
            dispose();
        }

    }

}


