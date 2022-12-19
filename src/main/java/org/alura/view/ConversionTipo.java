package org.alura.view;

import org.alura.controller.ConversionController;
import org.alura.controller.TipoConversionController;
import org.alura.model.Conversion;
import org.alura.model.TipoConversion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ConversionTipo extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel LabelConversionMoneda, labelvalor1,labelvalor2, labelFlechas, labelResultado,labelTextField;
    private JComboBox<Conversion> comboBoxLista;
    private JButton BotonAceptar, BotonCancelar;
    private TextField textFieldConversion;
    private JRadioButton OpcionValor1, OpcionValor2;

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

        LabelConversionMoneda.setForeground(Color.BLACK);
        comboBoxLista=new JComboBox<>();
        comboBoxLista.addItem(new Conversion("Elegir conversion del tipo "+tipoConversion.getNombre(),""));
       // comboBoxLista.setToolTipText("Seleccionar conversion");
        var conversions = this.conversionController.listar(tipoConversion);
        conversions.forEach(conversion ->comboBoxLista.addItem(conversion));
        textFieldConversion = new TextField();
        BotonAceptar = new JButton("Conversion");
        BotonCancelar = new JButton("Cancelar");

        OpcionValor1 = new JRadioButton("Normal");
        OpcionValor2 = new JRadioButton("Invertir");
        ButtonGroup bg = new ButtonGroup();
        bg.add(OpcionValor1);
        bg.add(OpcionValor2);
        labelTextField =new JLabel("Ingrese cantidad a convertir"   );
        labelvalor1=new JLabel();
        labelvalor2=new JLabel();
        labelFlechas=new JLabel("--> -->");
        labelResultado=new JLabel();
        LabelConversionMoneda.setBounds(10, 10, 250, 20);
        comboBoxLista.setBounds(10,45,300,30);
        OpcionValor1.setBounds(10,80,100,20);
        OpcionValor2.setBounds(120,80,100,20);
        labelvalor1.setBounds(10,110,50,20);
        labelFlechas.setBounds(65,110,50,20);
        labelvalor2.setBounds(120,110,50,20);
        labelTextField.setBounds(20,150,100,20);
        textFieldConversion.setBounds(20,170,100,20);
        labelResultado.setBounds(130,170,100,20);

        OpcionValor1.setSelected(true);
        BotonAceptar.setBounds(20,200,110,20);
        BotonCancelar.setBounds(160,200,110,20);


        container.add(labelResultado);
        container.add(labelFlechas);
        container.add(labelvalor1);
        container.add(labelvalor2);
        container.add(OpcionValor1);
        container.add(OpcionValor2);
        container.add(textFieldConversion);
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
                var convertir = (Conversion) comboBoxLista.getSelectedItem();
                double cantidad = Double.parseDouble(textFieldConversion.getText());

                convertirMetodo(convertir,cantidad);
            }
        });

        BotonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });

        comboBoxLista.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                var Selected = (Conversion) comboBoxLista.getSelectedItem();
                if (Selected == null) throw new AssertionError();
                boolean op= OpcionValor1.isSelected();
                if (op){
                    labelvalor1.setText(Selected.getCambio1());
                    labelvalor2.setText(Selected.getCambio2());
                }else {
                    labelvalor1.setText(Selected.getCambio2());
                    labelvalor2.setText(Selected.getCambio1());
                }

            }
        });
        OpcionValor1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                var Selected = (Conversion) comboBoxLista.getSelectedItem();
                boolean op = OpcionValor1.isSelected();
                if (op){
                    labelvalor1.setText(Selected.getCambio1());
                    labelvalor2.setText(Selected.getCambio2());
                }else {
                    labelvalor1.setText(Selected.getCambio2());
                    labelvalor2.setText(Selected.getCambio1());
                }
            }
        });
    }

    public void convertirMetodo(Conversion conversion, double cantidad){
        boolean op = OpcionValor1.isSelected();
        labelResultado.setText(this.conversionController.MetodoCalcularConversion(op,conversion,cantidad));

    }

}
