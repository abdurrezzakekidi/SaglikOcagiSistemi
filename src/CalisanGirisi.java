import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalisanGirisi extends JFrame implements ActionListener  {
    JPanel panel1 = new JPanel(null);
    JPanel panel2 = new JPanel(null);


    JLabel calisanGirisiLabel = new JLabel(" ÇALIŞAN Girişi");
    JLabel calisanAdiLabel = new JLabel("ÇALIŞANIN ADI");
    JLabel sifreLabel = new JLabel(" ŞİFRE");

    private JTextField calisan_adiField = new JTextField(20);
    private JTextField sifrField = new JTextField(20);

    JButton girisButton1 = new JButton("GİRİŞ");
    JButton geriButton1 = new JButton("GERİ ↺");

    JLabel imageContainer ;
    ImageIcon image;

    public CalisanGirisi(){

        this.setTitle("ÇALIŞAN GİRİŞİ");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        panel1.setBounds(0,0,1200,80);
        panel1.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        calisanGirisiLabel.setFont(new Font("Inter",Font.BOLD,40));
        calisanGirisiLabel.setForeground(new Color(0xffffff));
        calisanGirisiLabel.setBounds(432, 0, 460, 80);
        panel2.setBounds(113,134,974,532);
        panel2.setBackground(new Color(0x4A464A));

        calisanAdiLabel.setFont(new Font("Inter", Font.BOLD, 24));
        calisanAdiLabel.setForeground(new Color(0xffffff));
        calisanAdiLabel.setBounds(519, 96, 208, 48);

        sifreLabel.setFont(new Font("Inter", Font.BOLD, 24));
        sifreLabel.setForeground(new Color(0xffffff));
        sifreLabel.setBounds(519, 263, 89, 56);

        calisan_adiField.setBounds(511, 186, 300, 60);
        calisan_adiField.setFont(new Font("Inter", Font.BOLD, 24));

        sifrField.setBounds(511, 353, 300, 60);
        sifrField.setFont(new Font("Inter", Font.BOLD, 24));

        girisButton1.setFont(new Font("Inter",Font.BOLD,24));
        girisButton1.setBounds(665, 600, 216, 54);
        girisButton1.setForeground(new Color(0x4A4A4A));
        girisButton1.setBackground(Color.decode("#FFFFFF"));
        girisButton1.addActionListener(this);


        image =new ImageIcon("src/image1/ç.jpg");
        imageContainer = new JLabel(image);
        imageContainer.setBounds(160, 190, 200, 200);

        geriButton1.setFont(new Font("Inter", Font.BOLD, 20));
        geriButton1.setBounds(5, 685, 130, 60);
        geriButton1.setForeground(new Color(0xFFFFFF));
        geriButton1.setBackground(Color.decode("#4A4A4A"));

        geriButton1.addActionListener((ActionListener) this);
        this.add(geriButton1);




        panel1.add(calisanGirisiLabel);
        this.add(panel1);

        panel2.add(calisanAdiLabel);
        this.add(panel2);

        panel2.add(sifreLabel);
        this.add(panel2);

        panel2.add(new JLabel("ÇALIŞAN ADI :"));
        panel2.add(calisan_adiField);

        panel2.add(new JLabel("ŞİFRE :"));
        panel2.add(sifrField);
        panel2.add(imageContainer);
        add(girisButton1);

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==girisButton1){
            String caisan_adi = calisan_adiField.getText();
            String sifre = sifrField.getText();
            if (girisYap(caisan_adi,sifre)){
                JOptionPane.showMessageDialog(this, "Giriş başarılı!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
               new CalisanSistemi(getName(caisan_adi,sifre));
            }else {
                JOptionPane.showMessageDialog(this, "Çalışan adı veya şifre hatalı.", "Hata", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (e.getSource() == geriButton1) {
            new GirisYap();
            dispose();


        }


    }
    private boolean girisYap(String calisan_adi,String sifre){
        try (Connection connection = Jdbc.baglan()){
            String sorgu ="SELECT * FROM calisangirisi WHERE calisan_adi = ? AND sifre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)){
                preparedStatement.setString(1,calisan_adi);
                preparedStatement.setString(2,sifre);
                try (ResultSet resultSet =preparedStatement.executeQuery()){
                    return resultSet.next();

                }

            }

        }catch (SQLException exception){
            exception.getMessage();
            JOptionPane.showMessageDialog(this,"Veritabanı hatası"+exception.getMessage()+"hata"+JOptionPane.ERROR_MESSAGE);
            return false;
        }
        finally {
            Jdbc jdbc = new Jdbc();
            jdbc.kapat();
        }
    }
    private String getName(String calisan_adi, String sifre) {
        try (Connection connection = Jdbc.baglan()) {
            String sorgu = "SELECT * FROM calisangirisi WHERE calisan_adi = ? AND sifre = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sorgu)) {
                preparedStatement.setString(1, calisan_adi);
                preparedStatement.setString(2, sifre);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("calisan_adi");
                    }
                }
            }
        } catch (Exception exception) {
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

