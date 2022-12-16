package org.alura.view;

import javax.swing.*;
import java.awt.*;

public class MenuMonedas extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel LabelConversionMoneda;
    private JComboBox<Object> comboBoxListaMonedas;

    private JButton BotonAceptarMoneda;

    //private OpcionesMonedas opcionesMonedas;

    public MenuMonedas(MenuConversion menuConversion){
        super("Cambio de monedas");
        //this.opcionesMonedas = OpcionesMonedas();
        Container container = getContentPane();
        setLayout(null);
        LabelConversionMoneda = new JLabel("Elegir Moneda de conversion");
        LabelConversionMoneda.setBounds(10, 10, 150, 20);
        LabelConversionMoneda.setForeground(Color.BLACK);
        container.add(LabelConversionMoneda);

        setSize(250, 170);
        setVisible(true);
        setLocationRelativeTo(menuConversion);


    }

}
