import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SifreDegistirme extends JFrame implements ActionListener {

    JButton jButtonGeri = new JButton(" Geri ↺");
    JButton jButtonOnayla = new JButton("ONAYLA");
    JLabel jLabelSifreDegistirme = new JLabel("ŞİFRE DEĞİŞTİRME");
    JLabel jLabelEskiSifre = new JLabel("ESKİ ŞİFRE");
    JLabel jLabelYeniSifre = new JLabel("YENİ ŞİFRE");
    JLabel jLabelSifreOnay = new JLabel("YENİ ŞİFRE ONAYLAMA");
    JPanel panel = new JPanel(null);
    JPanel panel1 = new JPanel(null);

     private JPasswordField eskiSifreField = new JPasswordField(20);
    private JPasswordField yeniSifreField = new JPasswordField(20);
    private JPasswordField yeniSifreOnayField = new JPasswordField(20);



    JLabel imageContainer;
    ImageIcon image;

    public SifreDegistirme() {
        this.setTitle("ŞİFRE DEĞİŞTİRME");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel.setBounds(0,0,1200,80);
        panel.setBackground(new Color(0x4A4A4A));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);


        jLabelSifreDegistirme.setFont(new Font("Inter",Font.BOLD,36));
        jLabelSifreDegistirme.setForeground(new Color(0xffffff));
        jLabelSifreDegistirme.setBounds(20, 0, 460, 80);
        panel1.setBounds(113, 134, 974, 532);
        panel1.setBackground(new Color(0x4A464A));

        jLabelEskiSifre.setFont(new Font("Inter", Font.BOLD, 24));
        jLabelEskiSifre.setForeground(new Color(0xffffff));
        jLabelEskiSifre.setBounds(600, 197, 180, 48);

        jLabelYeniSifre.setFont(new Font("Inter", Font.BOLD, 24));
        jLabelYeniSifre.setForeground(new Color(0xffffff));
        jLabelYeniSifre.setBounds(600, 287, 180, 48);

        jLabelSifreOnay.setFont(new Font("Inter", Font.BOLD, 24));
        jLabelSifreOnay.setForeground(new Color(0xffffff));
        jLabelSifreOnay.setBounds(600, 377, 300, 48);


        image = new ImageIcon("src/image1/k.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(160,190, 200,200);

        jButtonGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonGeri.setBounds(5, 685, 130, 60);
        jButtonGeri.setForeground(new Color(0xFFFFFF));
        jButtonGeri.setBackground(Color.decode("#4A4A4A"));

        jButtonOnayla.setFont(new Font("Inter", Font.BOLD, 20));
        jButtonOnayla.setBounds(580, 475, 250, 48);
        jButtonOnayla.setForeground(new Color(0xFFFFFF));
        jButtonOnayla.setBackground(Color.decode("#939393"));
        jButtonOnayla.addActionListener(this);


        eskiSifreField.setBounds(600, 247, 220, 40);
        eskiSifreField.setFont(new Font("Inter", Font.BOLD, 24));

        yeniSifreField .setBounds(600, 337, 220, 40);
        yeniSifreField.setFont(new Font("Inter", Font.BOLD, 24));

        yeniSifreOnayField.setBounds(600, 427, 200, 40);
        yeniSifreOnayField.setFont(new Font("Inter", Font.BOLD, 24));




        jButtonGeri.addActionListener((ActionListener) this);
        this.add(jButtonGeri);

        panel.add(jLabelSifreDegistirme);
        this.add(panel);

        panel1.add(imageContainer);
        panel1.add(jButtonOnayla);
        this.add(panel1);

        this.add(jButtonGeri);
        

        panel1.add(jLabelEskiSifre);
        this.add(panel1);
        panel1.add(jLabelYeniSifre);
        this.add(panel1);
        panel1.add(jLabelSifreOnay);
        this.add(panel1);


        panel1.add(new JLabel("ESKİ ŞİFRE :"));
        panel1.add(eskiSifreField);

        panel1.add(new JLabel(" YENİ ŞİFRE :"));
        panel1.add(yeniSifreField);

        panel1.add(new JLabel("YENİ ŞİFRE ONAY :"));
        panel1.add(yeniSifreOnayField);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButtonOnayla){
            String eskiSifre = new String(eskiSifreField.getPassword()) ;
            String yeniSifre = new String(yeniSifreField.getPassword());
            String yeniSifreOnay = new String(yeniSifreOnayField.getPassword());
            if (eskiSifreDogruMu(eskiSifre)){
                if (yeniSifre.equals(yeniSifreOnay)){
                    sifreGuncelle(yeniSifre);

                }
                else {
                    JOptionPane.showMessageDialog(this, "Yeni şifreler eşleşmiyor. Lütfen kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Eski şifre hatalı. Lütfen kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (e.getSource() == jButtonGeri) {
            new KullaniciSistemi();
            dispose();

    }
    }

    private boolean eskiSifreDogruMu(String eskiSifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "SELECT * FROM hesapolustur WHERE tc = ? AND sifre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)) {
                preparedStatement.setString(1, KullaniciGirisi.getTc()); // Kullanıcı TC'sini aldık (KullaniciGirisi sınıfındaki static metod kullanıldı)
                preparedStatement.setString(2, eskiSifre);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException exception) {
            exception.getMessage();
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Jdbc jdbc = new Jdbc();
            jdbc.kapat();
        }
    }
    private void sifreGuncelle(String yeniSifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "UPDATE hesapolustur SET sifre = ? WHERE tc = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)) {
                preparedStatement.setString(1, yeniSifre);
                preparedStatement.setString(2, KullaniciGirisi.getTc()); // Kullanıcı TC'sini aldık

                int etkilenenSatirlar = preparedStatement.executeUpdate();

                if (etkilenenSatirlar > 0) {
                    JOptionPane.showMessageDialog(this, "Şifre başarıyla güncellendi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    new KisiselBigiler();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Şifre güncelleme sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException exception) {
            exception.getMessage();
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        } finally {
            Jdbc jdbc = new Jdbc();
            jdbc.kapat();
        }
    }
}

