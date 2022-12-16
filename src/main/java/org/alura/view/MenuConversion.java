package org.alura.view;

import org.alura.controller.OpcionesConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuConversion extends JFrame {

    private static final long serialVersionUID=1L;

    private JLabel LabelConversion;
    private JComboBox<Object> comboConversiones;
    private JButton BotonAceptar, BotonCancelar;
    private  OpcionesConversion opcionesConversion;


    public MenuConversion(){
        super("Menu");
        this.opcionesConversion = new OpcionesConversion();
        Container container = getContentPane();
        setLayout(null);
        configurarFormularioOpcionesMenu(container);
        AccionesFormMenu();
    }

    private void configurarFormularioOpcionesMenu(Container container){
        LabelConversion = new JLabel("Elegir Conversion");
        LabelConversion.setBounds(10, 10, 150, 20);
        LabelConversion.setForeground(Color.BLACK);
        comboConversiones= new JComboBox<>();
        var listaConversionesdisponibles = this.opcionesConversion.ListaConversiones();
        listaConversionesdisponibles.forEach(conversion -> comboConversiones.addItem(conversion.getNombre()));
        comboConversiones.setBounds(10, 35, 215, 30);

        BotonCancelar = new JButton("Cancelar");
        BotonAceptar = new JButton("Aceptar");
        BotonAceptar.setBounds(10, 80, 90, 25);
        BotonCancelar.setBounds(135, 80, 90, 25);

        container.add(LabelConversion);
        container.add(comboConversiones);
        container.add(BotonCancelar);
        container.add(BotonAceptar);

        setSize(250, 170);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void AccionesFormMenu(){
        BotonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConversionMonedas();
            }
        });

        BotonCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
    private void ConversionMonedas(){
        new MenuMonedas(this);
    }


}
