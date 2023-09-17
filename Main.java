import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JFrame janela = new JFrame("Hotéis");
        janela.getContentPane().setLayout(new FlowLayout());
        
        JButton a = new JButton("Adicionar hotel");
        a.setBackground(new Color(255, 255, 255, 255));
        a.setBorderPainted(false);
        a.setFocusPainted(false);
        a.setCursor(new Cursor(Cursor.HAND_CURSOR));
        janela.getContentPane().add(a);

        janela.setSize(400, 200);
        janela.setVisible(true);
    }
}