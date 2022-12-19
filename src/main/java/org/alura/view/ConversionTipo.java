package org.alura.view;

import org.alura.controller.ConversionController;
import org.alura.controller.TipoConversionController;
import org.alura.model.Conversion;
import org.alura.model.TipoConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversionTipo extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel LabelConversionMoneda;
    private JComboBox<Conversion> comboBoxLista;
    private JButton BotonAceptar, BotonCancelar;
    private TextField textFieldConversion;
    private TipoConversionController tipoConversionController;
    private ConversionController conversionController;

    //private OpcionesMonedas opcionesMonedas;

    public ConversionTipo(MenuConversion menuConversion, TipoConversion tipoConversion){
        super("Cambio de "+ tipoConversion.getNombre());
        this.tipoConversionController = new TipoConversionController();
        this.conversionController = new ConversionController();
        Container container = getContentPane();
        setLayout(null);
        setVisible(true);

        setLocationRelativeTo(menuConversion);
        configurarFormularioConversion(container,tipoConversion);
        AccionesFormMenuConversion(tipoConversion);


    }
    private void configurarFormularioConversion(Container container,TipoConversion tipoConversion){

        LabelConversionMoneda = new JLabel("Elegir "+tipoConversion.getNombre()+" de conversion");
        LabelConversionMoneda.setBounds(10, 10, 250, 20);
        LabelConversionMoneda.setForeground(Color.BLACK);
        comboBoxLista=new JComboBox<>();
        comboBoxLista.addItem(new Conversion("Elegir conversion del tipo "+tipoConversion.getNombre(),""));
       // comboBoxLista.setToolTipText("Seleccionar conversion");
        var conversions = this.conversionController.listar(tipoConversion);
        conversions.forEach(conversion ->comboBoxLista.addItem(conversion));
        comboBoxLista.setBounds(10,45,300,30);
        textFieldConversion = new TextField();
        BotonAceptar = new JButton("Conversion");
        BotonCancelar = new JButton("Cancelar");
        BotonAceptar.setBounds(20,100,110,20);
        BotonCancelar.setBounds(160,100,110,20);

        container.add(BotonAceptar);
        container.add(BotonCancelar);
        container.add(LabelConversionMoneda);
        container.add(comboBoxLista);

        setSize(450, 370);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    private void AccionesFormMenuConversion(TipoConversion tipoConversion){
        BotonAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        BotonCancelar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

}
