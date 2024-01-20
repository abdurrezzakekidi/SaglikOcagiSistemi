import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KullaniciSistemi extends JFrame implements ActionListener {
    JButton jButtonKisiselBiligiler = new JButton("KİŞİSEL BİLGİLER");
    JButton jButtonBolumler = new JButton("BÖLÜMLER ");
    JButton jButtonRandevuAlma = new JButton("RANDEVU ALMA ");
    JButton jButtonRandevularim = new JButton("RANDEVULARİM ");
    JButton jButtonCikis = new JButton(" ÇIKIŞ");
    JPanel panel = new JPanel(null);

    private KullaniciGirisi kullaniciGirisi;

    JLabel jLabelKullanici;


    public KullaniciSistemi(String name, KullaniciGirisi girisi) {
        this.kullaniciGirisi = girisi;
        this.setTitle("KULLANICI SİSTEMİ ");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        panel.setBounds(0, 0, 1200, 80);
        panel.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        jLabelKullanici = new JLabel("Merhaba " + name);
        jLabelKullanici.setFont(new Font("Inter", Font.BOLD, 40));
        jLabelKullanici.setForeground(new Color(0xffffff));
        jLabelKullanici.setBounds(360, 0, 460, 80);

        jButtonKisiselBiligiler.setBounds(110, 110, 480, 280);
        jButtonKisiselBiligiler.setFont(new Font("Inter", Font.BOLD, 32));
        jButtonKisiselBiligiler.setForeground(new Color(0xFFFFFF));
        jButtonKisiselBiligiler.setBackground(Color.decode("#4A4A4A"));
        jButtonKisiselBiligiler.addActionListener(this);

        jButtonBolumler.setBounds(610, 110, 480, 280);
        jButtonBolumler.setFont(new Font("Inter", Font.BOLD, 32));
        jButtonBolumler.setForeground(new Color(0xFFFFFF));
        jButtonBolumler.setBackground(Color.decode("#4A4A4A"));
        jButtonBolumler.addActionListener(this);

        jButtonRandevuAlma.setBounds(110, 410, 480, 280);
        jButtonRandevuAlma.setFont(new Font("Inter", Font.BOLD, 32));
        jButtonRandevuAlma.setForeground(new Color(0xFFFFFF));
        jButtonRandevuAlma.setBackground(Color.decode("#4A4A4A"));
        jButtonRandevuAlma.addActionListener(this);

        jButtonRandevularim.setBounds(610, 410, 480, 280);
        jButtonRandevularim.setFont(new Font("Inter", Font.BOLD, 32));
        jButtonRandevularim.setForeground(new Color(0xFFFFFF));
        jButtonRandevularim.setBackground(Color.decode("#4A4A4A"));
        jButtonRandevularim.addActionListener(this);

        jButtonCikis.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonCikis.setBounds(5, 685, 130, 60);
        jButtonCikis.setForeground(new Color(0xFFFFFF));
        jButtonCikis.setBackground(Color.decode("#4A4A4A"));

        jButtonCikis.addActionListener((ActionListener) this);
        this.add(jButtonCikis);


        panel.add(jLabelKullanici);
        this.add(panel);
        this.add(jButtonKisiselBiligiler);
        this.add(jButtonBolumler);
        this.add(jButtonRandevularim);
        this.add(jButtonRandevuAlma);


    }

    public KullaniciSistemi() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButtonCikis) {
            new KullaniciGirisi();
            dispose();

        } else if (e.getSource() == jButtonKisiselBiligiler) {
            String tc = kullaniciGirisi.getTcField().getText();
            String sifre = kullaniciGirisi.getSifrField().getText();
            String[] bilgiler = getBilgiler(tc, sifre);
            if (bilgiler != null) {
                new KisiselBigiler(bilgiler);
                dispose();
            }
        } else if (e.getSource() == jButtonBolumler) {
            new Bolumler();
            dispose();
        } else if (e.getSource() == jButtonRandevuAlma) {


        } else if (e.getSource() == jButtonRandevularim) {

        }


    }

    private String[] getBilgiler(String tc, String sifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "SELECT * FROM hesapolustur WHERE tc = '" + tc + "' AND sifre = '" + sifre + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(sorgu);


                ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {

                        //  bilgiler classında bilgiler gelmiyor kodun düzenlenmesi gerekir!!

                        String ad_soyad = resultSet.getString("ad_soyad");
                        String tc1 = resultSet.getString("tc");
                        String yas = resultSet.getString("yas");
                        String email = resultSet.getString("email");
                        String telefon_no = resultSet.getString("telefon_no");
                        String[] bilgiler = {ad_soyad, tc1, yas, email, telefon_no};
                        return bilgiler;
                    }
        } catch (SQLException exception) {
            exception.getMessage();
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Jdbc jdbc = new Jdbc();
            jdbc.kapat();

        }
        return null;
    }
}

