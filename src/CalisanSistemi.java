import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalisanSistemi extends KullaniciSistemi implements ActionListener{
    /*
    JButton jButtonHastaBilgileri =new JButton("HASTA BİLGİLERİ");
    JButton jButtonBolumler = new JButton("BÖLÜMLER ");
    JButton jButtonRandevuİşlemleri = new JButton("RANDEVU İŞLEMLERİ ");
    JButton jButtonCalisanBilgileri = new JButton("ÇALIŞAN BİLGİLERİ ");
    JButton jButtonCikis = new JButton(" ÇIKIŞ");
    JPanel panel = new JPanel(null);
    JLabel jLabelKullanici;

     */




    public CalisanSistemi(String name){
        this.setTitle("ÇALIŞAN SİSTEMİ ");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        panel.setBounds(0,0,1200,80);
        panel.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        jLabelKullanici = new JLabel("Merhaba "+ name);
        jLabelKullanici.setFont(new Font("Inter",Font.BOLD,40));
        jLabelKullanici.setForeground(new Color(0xffffff));
        jLabelKullanici.setBounds(360, 0, 460, 80);
/*
        jButtonHastaBilgileri.setBounds(110, 110, 480, 280);
        jButtonHastaBilgileri.setFont(new Font("Inter",Font.BOLD,32));
        jButtonHastaBilgileri.setForeground(new Color(0xFFFFFF));
        jButtonHastaBilgileri.setBackground(Color.decode("#4A4A4A"));
        jButtonHastaBilgileri.addActionListener(this);

 */




        jButtonBolumler.setBounds(610, 110, 480, 280);
        jButtonBolumler.setFont(new Font("Inter",Font.BOLD,32));
        jButtonBolumler.setForeground(new Color(0xFFFFFF));
        jButtonBolumler.setBackground(Color.decode("#4A4A4A"));
        jButtonBolumler.addActionListener(this);

/*

        jButtonRandevuİşlemleri.setBounds(110, 410, 480, 280);
        jButtonRandevuİşlemleri.setFont(new Font("Inter",Font.BOLD,32));
        jButtonRandevuİşlemleri.setForeground(new Color(0xFFFFFF));
        jButtonRandevuİşlemleri.setBackground(Color.decode("#4A4A4A"));
        jButtonRandevuİşlemleri.addActionListener(this);


        jButtonCalisanBilgileri.setBounds(610, 410, 480, 280);
        jButtonCalisanBilgileri.setFont(new Font("Inter",Font.BOLD,32));
        jButtonCalisanBilgileri.setForeground(new Color(0xFFFFFF));
        jButtonCalisanBilgileri.setBackground(Color.decode("#4A4A4A"));
        jButtonCalisanBilgileri.addActionListener(this);

 */


        jButtonCikis.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonCikis.setBounds(5, 685, 130, 60);
        jButtonCikis.setForeground(new Color(0xFFFFFF));
        jButtonCikis.setBackground(Color.decode("#4A4A4A"));

        jButtonCikis.addActionListener((ActionListener) this);
        this.add(jButtonCikis);






        panel.add(jLabelKullanici);
        this.add(panel);
/*
        this.add(jButtonHastaBilgileri);
        this.add(jButtonBolumler);
        this.add(jButtonCalisanBilgileri);
        this.add(jButtonRandevuİşlemleri);

 */

/*
        jButtonBolumler.addActionListener(this);
        jButtonRandevularim.addActionListener(this);
        jButtonRandevuAlma.addActionListener(this);
        jButtonKisiselBiligiler.addActionListener(this);
        panel.add(jLabelKullanici);
        this.add(panel);
        this.add(jButtonKisiselBiligiler);
        this.add(jButtonBolumler);
        this.add(jButtonRandevularim);
        this.add(jButtonRandevuAlma);

 */






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);





        if(e.getSource() == jButtonCikis){
            new CalisanGirisi();
            dispose();

        }
    }
}

