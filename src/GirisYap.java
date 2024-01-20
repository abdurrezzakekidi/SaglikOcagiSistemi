import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GirisYap extends JFrame implements ActionListener {
    JButton jButtonKullici =new JButton("KULLANICI");
    JButton jButtonCalisan = new JButton("ÇALIŞAN");
    JButton jButtonGeri = new JButton("GERİ ↺");
    JLabel labelGiris = new JLabel("GİRİŞ YAP");
    JPanel panel = new JPanel(null);

    public GirisYap(){
        this.setTitle("GİRİŞ YAP ");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel.setBounds(0,0,1200,80);
        panel.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        labelGiris.setFont(new Font("Inter",Font.BOLD,40));
        labelGiris.setForeground(new Color(0xffffff));
        labelGiris.setBounds(498, 0, 460, 80);

        jButtonCalisan.setBounds(664, 300, 450, 200);
        jButtonCalisan.setFont(new Font("Inter",Font.BOLD,32));
        jButtonCalisan.setForeground(new Color(0xFFFFFF));
        jButtonCalisan.setBackground(Color.decode("#4A4A4A"));
        jButtonCalisan.addActionListener((ActionListener) this);

        jButtonKullici.setFont(new Font("Inter",Font.BOLD,32));
        jButtonKullici.setBounds(86, 300, 450, 200);
        jButtonKullici.setForeground(new Color(0xFFFFFF));
        jButtonKullici.setBackground(Color.decode("#4A4A4A"));
        jButtonKullici.addActionListener((ActionListener) this);

        jButtonGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonGeri.setBounds(5, 685, 130, 60);
        jButtonGeri.setForeground(new Color(0xFFFFFF));
        jButtonGeri.setBackground(Color.decode("#4A4A4A"));
        jButtonGeri.addActionListener((ActionListener) this);

        this.add(jButtonGeri);

        panel.add(labelGiris);
        this.add(panel);
        this.add(jButtonCalisan);
        this.add(jButtonKullici);
        this.add(jButtonGeri);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonGeri) {
            new SaglikOcagi();
            dispose();
        }else if (e.getSource()==jButtonKullici){
            new KullaniciGirisi();
            dispose();
        }else if(e.getSource()==jButtonCalisan){
            new CalisanGirisi();
            dispose();
        }

    }
}
