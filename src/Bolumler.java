import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bolumler extends JFrame implements ActionListener {
    JButton jButtonGeri = new JButton(" Geri ↺");

    JButton jButtonBolum1 = new JButton("Aile Hekimliği");
    JButton jButtonBolum2 = new JButton("Diş hekimliği");
    JButton jButtonBolum3 = new JButton("Çocuk Diş Hekimliği");
    JButton jButtonBolum4 = new JButton("Genel Muayene");
    JButton jButtonBolum5 = new JButton("Tahliller");
    JButton jButtonBolum6 = new JButton("Göz Hastalıkları");
    JButton jButtonBolum7 = new JButton("Sigarayı Bıraktırma Kliniği");

    JLabel jLabelBolumler = new JLabel("BÖLÜMLER");

    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);

    JLabel imageContainer;
    ImageIcon image;


    public Bolumler(){
        this.setTitle("BÖLÜMLER");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);



        panel1.setBounds(0,0,1200,80);
        panel1.setBackground(new Color(0x4A4A4A));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        //panel2 image için kullandık.
        panel2.setBounds(286, 80, 914, 720);
        panel2.setBackground(new Color(0x4A464A));

        jLabelBolumler.setFont(new Font("Inter",Font.BOLD,36));
        jLabelBolumler.setForeground(new Color(0xffffff));
        jLabelBolumler.setBounds(20, 0, 460, 80);

        jButtonGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonGeri.setBounds(5, 700, 130, 60);
        jButtonGeri.setForeground(new Color(0xFFFFFF));
        jButtonGeri.setBackground(Color.decode("#4A4A4A"));
        jButtonGeri.addActionListener((ActionListener) this);
//-----------------------------------------------------------------
        jButtonBolum1.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum1.setBounds(1, 101, 280, 70);
        jButtonBolum1.setForeground(new Color(0xFFFFFF));
        jButtonBolum1.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum1.addActionListener((ActionListener) this);

        jButtonBolum2.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum2.setBounds(1, 188, 280, 70);
        jButtonBolum2.setForeground(new Color(0xFFFFFF));
        jButtonBolum2.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum2.addActionListener((ActionListener) this);

        jButtonBolum3.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum3.setBounds(1, 275, 280, 70);
        jButtonBolum3.setForeground(new Color(0xFFFFFF));
        jButtonBolum3.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum3.addActionListener((ActionListener) this);

        jButtonBolum4.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum4.setBounds(1, 362, 280, 70);
        jButtonBolum4.setForeground(new Color(0xFFFFFF));
        jButtonBolum4.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum4.addActionListener((ActionListener) this);

        jButtonBolum5.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum5.setBounds(1, 449, 280, 70);
        jButtonBolum5.setForeground(new Color(0xFFFFFF));
        jButtonBolum5.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum5.addActionListener((ActionListener) this);

        jButtonBolum6.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum6.setBounds(1, 536, 280, 70);
        jButtonBolum6.setForeground(new Color(0xFFFFFF));
        jButtonBolum6.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum6.addActionListener((ActionListener) this);

        jButtonBolum7.setFont(new Font("Inter", Font.BOLD, 19));
        jButtonBolum7.setBounds(1, 623, 280, 70);
        jButtonBolum7.setForeground(new Color(0xFFFFFF));
        jButtonBolum7.setBackground(Color.decode("#4A4A4A"));
        jButtonBolum7.addActionListener((ActionListener) this);



        image = new ImageIcon("src/image1/5.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(150,25, 600,720);



        this.add(jButtonGeri);


        panel1.add(jLabelBolumler);
        this.add(panel1);

        panel2.add(imageContainer);
        this.add(panel2);


        this.add(jButtonBolum1);
        this.add(jButtonBolum2);
        this.add(jButtonBolum3);
        this.add(jButtonBolum4);
        this.add(jButtonBolum5);
        this.add(jButtonBolum6);
        this.add(jButtonBolum7);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButtonGeri){
            new KullaniciSistemi();
            dispose();
        }
        else if (e.getSource()==jButtonBolum1){
            new Bolum1();
            dispose();
        }
        else if (e.getSource()==jButtonBolum2){

        }
        else if (e.getSource()==jButtonBolum3){

        }
        else if (e.getSource()==jButtonBolum4){

        }
        else if (e.getSource()==jButtonBolum5){

        }
        else if (e.getSource()==jButtonBolum6){

        }
        else if (e.getSource()==jButtonBolum7){

        }

    }
}
