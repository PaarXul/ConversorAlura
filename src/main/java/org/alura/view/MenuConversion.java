package org.alura.view;

import org.alura.controller.ConversionController;
import org.alura.controller.TipoConversionController;
import org.alura.model.TipoConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuConversion extends JFrame {

    private static final long serialVersionUID=1L;

    private JLabel LabelConversion;
    private JComboBox<TipoConversion> comboConversiones;
    private JButton BotonAceptar, BotonCancelar;
    private TipoConversionController tipoConversionController;
    private ConversionController conversionController;


    public MenuConversion(){
        super("Menu");
        this.tipoConversionController = new TipoConversionController();
        this.conversionController = new ConversionController();
        Container container = getContentPane();
        setLayout(null);
        configurarFormularioOpcionesMenu(container);
        AccionesFormMenu();
    }

    private void configurarFormularioOpcionesMenu(Container container){

        LabelConversion = new JLabel("Elegir Conversion");

        LabelConversion.setForeground(Color.BLACK);
        comboConversiones= new JComboBox<>();
        comboConversiones.addItem(new TipoConversion(0, "Elige una Categoría"));
        var tipoConversiones = this.tipoConversionController.listar();
        tipoConversiones.forEach(tipoConversion -> comboConversiones.addItem(tipoConversion));



        BotonCancelar = new JButton("Cancelar");
        BotonAceptar = new JButton("Aceptar");
        LabelConversion.setBounds(10, 10, 150, 20);
        comboConversiones.setBounds(10, 35, 215, 30);
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
                var conversion = (TipoConversion) comboConversiones.getSelectedItem();
                ConversionMonedas(conversion);
            }
        });

        BotonCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
    private void ConversionMonedas(TipoConversion conversion){

        new ConversionTipo(this,conversion);

    }


}
