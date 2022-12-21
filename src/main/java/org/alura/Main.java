package org.alura;

import org.alura.view.MenuConversion;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //UIManager.put("nimbusBase", new Color(86,160,66));
        //UIManager.put("control",new Color(150,0,0));
        UIManager.put("FileChooser.font", "Tahoma");
        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        MenuConversion menuConversion =new MenuConversion();
        menuConversion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}