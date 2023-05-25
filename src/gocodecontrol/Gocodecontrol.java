package gocodecontrol;
import gocodecontrol.GUI.Login;
import javax.swing.JFrame;

public class Gocodecontrol {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        login.setTitle("GoCode Control - Tela de Acesso");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
}