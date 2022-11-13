package autenticacaocpf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCpf implements ActionListener  {
   

    JTextField cpf;

    public JanelaCpf() {
        JFrame jFrame = new JFrame("Identificação");

        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JButton jButton = new JButton("Continuar");
        jButton.setBounds(217,300,350,45);
        jButton.setFont(new Font("Arial", Font.BOLD, 20));
        jButton.setForeground(new Color(255, 255, 255, 255));
        jButton.setBackground(new Color(63, 150, 14, 255));

        jFrame.add(jButton);
        jButton.addActionListener(this);

        JLabel jLabel = new JLabel("Para continuar preencha com o seu CPF");
        jLabel.setBounds(233, 80, 400, 100);
        jLabel.setFont(new Font("Arial", Font.PLAIN, 17));

        jFrame.add(jLabel);

        JLabel jLabel2 = new JLabel("CPF");
        jLabel2.setBounds(170, 170, 100, 100);
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 17));

        jFrame.add(jLabel2);


        cpf = new JTextField("Continuar");
        cpf.setBounds(217,200,350,45);
        cpf.setFont(new Font("Arial", Font.ITALIC, 16));
        cpf.setText("");
        jFrame.add(cpf);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            String cpf1 = cpf.getText();
            AutenticacaoCpf.temCpf(cpf1);
        }
    }
