import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HesapOlustur extends JFrame implements ActionListener {
    JLabel LhesapOLustur = new JLabel("HESAP OLUŞTUR");
    JLabel LhesapOlustur1 = new JLabel("HESAP OLUŞTUR");

    JLabel adLabel = new JLabel("AD SOYAD:");
    JLabel tcLabel = new JLabel("TC:");
    JLabel yasLabel = new JLabel("YAŞ:");
    JLabel teLLabel = new JLabel("TEL:");
    JLabel cinsiyetLabel = new JLabel("CİNSİYET:");
    JLabel sifreLabel = new JLabel("ŞİFRE:");
    JLabel sifreOnayLabel = new JLabel("ŞİFRE ONAY:");
    JLabel emailLabel = new JLabel("EMAİL:");


    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);
    JPanel panel3 = new JPanel(null);
    JPanel panel4 = new JPanel(null);


    JButton jButOnayla = new JButton("ONAYLA");

    JButton jButGeri = new JButton("GERİ ↺");


    private JTextField ad_soyadField = new JTextField(20);
    private JTextField tcField = new JTextField(20);
    private JTextField yasField = new JTextField(20);
    private JTextField telefon_noField = new JTextField(20);
    private JPasswordField sifreField = new JPasswordField(20);
    private JPasswordField sifre_onayField = new JPasswordField(20);
    private JTextField cinsiyetField = new JTextField(20);
    private JTextField emailField = new JTextField(20);

    public HesapOlustur() {
        this.setTitle(" HESAP OLUŞTUR");
        this.setLayout(null);
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel1.setBounds(0, 0, 1200, 80);
        panel1.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        LhesapOLustur.setFont(new Font("Inter", Font.BOLD, 40));
        LhesapOLustur.setForeground(new Color(0xffffff));
        LhesapOLustur.setBounds(429, 0, 342, 80);

        panel2.setBounds(422, 108, 356, 86);
        panel2.setBackground(Color.decode("#4A4A4A"));

        LhesapOlustur1.setFont(new Font("Inter", Font.BOLD, 32));
        LhesapOlustur1.setForeground(new Color(0xffffff));
        LhesapOlustur1.setBounds(43, 5, 300, 68);

        panel3.setBounds(422, 180, 356, 510);
        panel3.setBackground(Color.decode("#4A4A4A"));

        panel3.add(new JLabel("AD SOYAD"));
        panel3.add(ad_soyadField);

        panel3.add(new JLabel("TC"));
        panel3.add(tcField);

        panel3.add(new JLabel("YAŞ"));
        panel3.add(yasField);

        panel3.add(new JLabel("TELEFON NO"));
        panel3.add(telefon_noField);

        panel3.add(new JLabel("CİNSİYET"));
        panel3.add(cinsiyetField);

        panel3.add(new JLabel("ŞİFRE"));
        panel3.add(sifreField);

        panel3.add(new JLabel("ŞİFRE ONAYLAMA"));
        panel3.add(sifre_onayField);

        panel3.add(new JLabel("EMAİL"));
        panel3.add(emailField);

        ad_soyadField.setBounds(9, 7, 338, 51);
        ad_soyadField.setFont(new Font("Inter", Font.BOLD, 24));

        tcField.setBounds(9, 67, 338, 51);
        tcField.setFont(new Font("Inter", Font.BOLD, 24));

        yasField.setBounds(9, 127, 338, 51);
        yasField.setFont(new Font("Inter", Font.BOLD, 24));

        telefon_noField.setBounds(9, 187, 338, 51);
        telefon_noField.setFont(new Font("Inter", Font.BOLD, 24));

        cinsiyetField.setBounds(9, 247, 338, 51);
        cinsiyetField.setFont(new Font("Inter", Font.BOLD, 24));

        sifreField.setBounds(9, 307, 338, 51);
        sifreField.setFont(new Font("Inter", Font.BOLD, 24));

        sifre_onayField.setBounds(9, 367, 338, 51);
        sifre_onayField.setFont(new Font("Inter", Font.BOLD, 24));

        emailField.setBounds(9, 427, 338, 51);
        emailField.setFont(new Font("Inter", Font.BOLD, 24));


        panel4.setBounds(150, 180, 252, 510);
        panel4.setBackground(Color.decode("#4A4A4A"));

        adLabel.setFont(new Font("Inter", Font.BOLD, 20));
        adLabel.setForeground(new Color(0xffffff));
        adLabel.setBounds(32, 7, 338, 51);

        tcLabel.setFont(new Font("Inter", Font.BOLD, 20));
        tcLabel.setForeground(new Color(0xffffff));
        tcLabel.setBounds(32, 67, 338, 51);

        yasLabel.setFont(new Font("Inter", Font.BOLD, 20));
        yasLabel.setForeground(new Color(0xffffff));
        yasLabel.setBounds(32, 127, 338, 51);

        teLLabel.setFont(new Font("Inter", Font.BOLD, 20));
        teLLabel.setForeground(new Color(0xffffff));
        teLLabel.setBounds(32, 187, 338, 51);


        cinsiyetLabel.setFont(new Font("Inter", Font.BOLD, 20));
        cinsiyetLabel.setForeground(new Color(0xffffff));
        cinsiyetLabel.setBounds(32, 247, 338, 51);

        sifreLabel.setFont(new Font("Inter", Font.BOLD, 20));
        sifreLabel.setForeground(new Color(0xffffff));
        sifreLabel.setBounds(32, 307, 338, 51);

        sifreOnayLabel.setFont(new Font("Inter", Font.BOLD, 20));
        sifreOnayLabel.setForeground(new Color(0xffffff));
        sifreOnayLabel.setBounds(32, 367, 338, 51);

        emailLabel.setFont(new Font("Inter", Font.BOLD, 20));
        emailLabel.setForeground(new Color(0xffffff));
        emailLabel.setBounds(32, 427, 338, 51);

        jButOnayla.setFont(new Font("Inter", Font.BOLD, 20));
        jButOnayla.setBounds(500, 700, 200, 40);
        jButOnayla.setForeground(new Color(0xFFFFFF));
        jButOnayla.setBackground(Color.decode("#4A4A4A"));
        jButOnayla.addActionListener((ActionListener) this);


        jButGeri.setFont(new Font("Inter", Font.BOLD, 20));
        jButGeri.setBounds(5, 685, 130, 60);
        jButGeri.setForeground(new Color(0xFFFFFF));
        jButGeri.setBackground(Color.decode("#4A4A4A"));

        jButGeri.addActionListener((ActionListener) this);




        panel1.add(LhesapOLustur);
        this.add(panel1);

        panel2.add(LhesapOlustur1);
        this.add(panel2);

        panel3.add(new JLabel());
        this.add(panel3);

        panel4.add(adLabel);
        this.add(panel4);

        panel4.add(tcLabel);
        this.add(panel4);

        panel4.add(yasLabel);
        this.add(panel4);

        panel4.add(teLLabel);
        this.add(panel4);

        panel4.add(cinsiyetLabel);
        this.add(panel4);

        panel4.add(sifreLabel);
        this.add(panel4);

        panel4.add(sifreOnayLabel);
        this.add(panel4);

        panel4.add(emailLabel);
        this.add(panel4);

        this.add(jButOnayla);
        this.add(jButGeri);

    }
    public void actionPerformedJButtonOnayla(ActionEvent e){
        if (e.getSource()==jButOnayla){
            String sifre = new String(sifreField.getPassword());
            String sifreonay = new String(sifre_onayField.getPassword());
            if (!sifre.equals(sifreonay)){
                JOptionPane.showMessageDialog(this,"Şifreler uyuşmuyor. Lütfen kontrol edin.", "Hata",JOptionPane.ERROR_MESSAGE);
            }
            else {
                veriTabanınaEkle();
            }
        }

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButGeri) {
            new SaglikOcagi();
            dispose();
        }else if (e.getSource()==jButOnayla){
            actionPerformedJButtonOnayla(e);
        }

    }
    public void veriTabanınaEkle() {
        String adSoyad = ad_soyadField.getText();
        String tc = tcField.getText();
        int yas = 0;
        String telefonNo = telefon_noField.getText();
        String cinsiyet = cinsiyetField.getText();
        String sifre = new String(sifreField.getPassword());
        String email = emailField.getText();


        try {
            yas = Integer.parseInt(yasField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Yaş değeri geçerli değil. Lütfen kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection1 = Jdbc.baglan()) {
            // TC ve telefon numarası uzunluk kontrolü
            if (tc.length() != 11 || telefonNo.length() != 11) {
                JOptionPane.showMessageDialog(this, "TC ve telefon numarası 11 haneli olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
                return ; // Hata durumunda metottan çık
            }

            // Yaş kontrolü
            if (yas <= 0 || yas >= 140) {
                JOptionPane.showMessageDialog(this, "Yaş değeri geçerli değil. Lütfen kontrol edin.", "Hata", JOptionPane.ERROR_MESSAGE);
                return; // Hata durumunda metottan çık
            }


            try (Connection connection = Jdbc.baglan()) {
                String ekleSQL = "INSERT INTO hesapolustur(ad_soyad, tc, yas, telefon_no, cinsiyet, sifre, sifre_onay, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ekleStatement = connection.prepareStatement(ekleSQL)) {
                    ekleStatement.setString(1, ad_soyadField.getText());
                    ekleStatement.setString(2, tcField.getText());
                    ekleStatement.setInt(3, Integer.parseInt(yasField.getText()));
                    ekleStatement.setString(4, telefon_noField.getText());
                    ekleStatement.setString(5, cinsiyetField.getText());
                    ekleStatement.setString(6, sifreField.getText());
                    ekleStatement.setString(7, new String(sifre_onayField.getPassword()));
                    ekleStatement.setString(8, emailField.getText());

                    int etkilenenSatirlar = ekleStatement.executeUpdate();

                    if (etkilenenSatirlar > 0) {
                        JOptionPane.showMessageDialog(this, "Hesap başarıyla oluşturuldu.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                        new KullaniciGirisi();
                    } else {
                        JOptionPane.showMessageDialog(this, "Hesap oluşturma sırasında bir hata oluştu.", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(this, "Veritabanı hatası: " + exception.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            } finally {
                Jdbc jdbc = new Jdbc();
                jdbc.kapat();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


