import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaglikOcagi extends JFrame implements ActionListener {
    JButton hesapOLustur =new JButton("HESAP OLUŞTUR");
    JButton giris = new JButton("GİRİŞ YAP");
    JLabel saLabel = new JLabel("SAĞLIK OCAĞI SİSTEMİ");
    JPanel panel = new JPanel(null);

    public SaglikOcagi(){
        this.setTitle("SAĞLIK OCAĞI SİSTEMİ ");
        this.setLayout(null);
        this.setSize(1200,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        panel.setBounds(0,0,1200,80);
        panel.setBackground(Color.decode("#4A4A4A"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        saLabel.setFont(new Font("Inter",Font.BOLD,40));
        saLabel.setForeground(new Color(0xffffff));
        saLabel.setBounds(360, 0, 460, 80);

        hesapOLustur.setBounds(664, 300, 450, 200);
        hesapOLustur.setFont(new Font("Inter",Font.BOLD,32));
        hesapOLustur.setForeground(new Color(0xFFFFFF));
        hesapOLustur.setBackground(Color.decode("#4A4A4A"));
        hesapOLustur.addActionListener(this);

        giris.setFont(new Font("Inter",Font.BOLD,32));
        giris.setBounds(86, 300, 450, 200);
        giris.setForeground(new Color(0xFFFFFF));
        giris.setBackground(Color.decode("#4A4A4A"));
        giris.addActionListener(this);






        panel.add(saLabel);
        this.add(panel);
        this.add(hesapOLustur);
        this.add(giris);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hesapOLustur){
            new HesapOlustur();
            dispose();
        }else if (e.getSource()==giris){
            new GirisYap();
            dispose();
        }


    }
}
