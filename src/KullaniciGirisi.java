import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciGirisi extends JFrame implements ActionListener {

    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);


    JLabel kullaniciGirisiLabel = new JLabel(" Kullanıcı Girişi");
    JLabel kullaniciTcLabel = new JLabel("KULLANICI T.C :");
    JLabel sifreLabel = new JLabel(" ŞİFRE");

    private static JTextField tcField = new JTextField(20);

    private JTextField sifrField = new JTextField(20);

    JButton girisButton = new JButton("GİRİŞ");
    JButton geriButton = new JButton("GERİ ↺");

    JLabel imageContainer;
    ImageIcon image;


    public KullaniciGirisi() {

        this.setTitle("KULLANICI GİRİŞİ");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel1.setBounds(0, 0, 1200, 80);
        panel1.setBackground(new Color(0x4A4A4A));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        kullaniciGirisiLabel.setFont(new Font("Inter", Font.BOLD, 40));
        kullaniciGirisiLabel.setForeground(new Color(0xffffff));
        kullaniciGirisiLabel.setBounds(432, 0, 460, 80);
        panel2.setBounds(113, 134, 974, 532);
        panel2.setBackground(new Color(0x4A464A));

        kullaniciTcLabel.setFont(new Font("Inter", Font.BOLD, 24));
        kullaniciTcLabel.setForeground(new Color(0xffffff));
        kullaniciTcLabel.setBounds(519, 96, 208, 48);

        sifreLabel.setFont(new Font("Inter", Font.BOLD, 24));
        sifreLabel.setForeground(new Color(0xffffff));
        sifreLabel.setBounds(519, 263, 89, 56);

        tcField.setBounds(511, 186, 300, 60);
        tcField.setFont(new Font("Inter", Font.BOLD, 24));

        sifrField.setBounds(511, 353, 300, 60);
        sifrField.setFont(new Font("Inter", Font.BOLD, 24));

        girisButton.setFont(new Font("Inter", Font.BOLD, 24));
        girisButton.setBounds(665, 600, 216, 54);
        girisButton.setForeground(new Color(0x4A4A4A));
        girisButton.setBackground(Color.decode("#FFFFFF"));
        girisButton.addActionListener(this);

        image = new ImageIcon("src/image1/k.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(160,190, 200,200);

        geriButton.setFont(new Font("Inter", Font.BOLD, 20));
        geriButton.setBounds(5, 685, 130, 60);
        geriButton.setForeground(new Color(0xFFFFFF));
        geriButton.setBackground(Color.decode("#4A4A4A"));

        geriButton.addActionListener((ActionListener) this);
        this.add(geriButton);


        panel1.add(kullaniciGirisiLabel);
        this.add(panel1);

        panel2.add(kullaniciTcLabel);
        this.add(panel2);

        panel2.add(sifreLabel);
        this.add(panel2);

        panel2.add(new JLabel("KULLINICI T.C :"));
        panel2.add(tcField);

        panel2.add(new JLabel("ŞİFRE :"));
        panel2.add(sifrField);
        panel2.add(imageContainer);
        add(girisButton);

    }
    public static String getTc() {
        return tcField.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == girisButton) {
            String tc = tcField.getText();
            String sifre = sifrField.getText();
            if (girisYap(tc, sifre)) {
                JOptionPane.showMessageDialog(this, "Giriş başarılı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                new KullaniciSistemi(getName(tc, sifre),this);
                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Kullanıcı adı veya şifre hatalı.", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == geriButton) {
            new GirisYap();
            dispose();
        }
    }

    private boolean girisYap(String tc, String sifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "SELECT * FROM hesapolustur WHERE tc = ? AND sifre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)) {
                preparedStatement.setString(1, tc);
                preparedStatement.setString(2, sifre);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next();
                }
            }

        } catch (Exception exception) {
            exception.getMessage();
            JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Jdbc jdbc = new Jdbc();
            jdbc.kapat();

        }
    }

    private String getName(String tc, String sifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "SELECT * FROM hesapolustur WHERE tc = ? AND sifre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)) {
                preparedStatement.setString(1, tc);
                preparedStatement.setString(2, sifre);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("ad_soyad");
                    }
                }
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

    public JTextField getTcField() {
        return tcField;
    }

    public JTextField getSifrField() {
        return sifrField;
    }

}

