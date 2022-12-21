package org.alura.controller;

import org.alura.dao.ConversionDAO;
import org.alura.factory.ConnectionFactory;
import org.alura.model.Conversion;
import org.alura.model.TipoConversion;

import java.util.List;

public class ConversionController {
    private ConversionDAO conversionDAO;

public ConversionController(){
    var factory = new ConnectionFactory();
    this.conversionDAO = new ConversionDAO(factory.recuperaConexion());
}


    public int modificar(String cambio1, String cambio2, double valor1,double valor2, Integer id) {
        return conversionDAO.modificar(cambio1, cambio2, valor1,valor2, id);
    }

    public int eliminar(Integer id) {
        return conversionDAO.eliminar(id);
    }

    public List<Conversion> listar() {
        return conversionDAO.listar();
    }

    public void guardar(Conversion conversion, Integer TipoConversioId) {
        conversion.setTipoConversionId(TipoConversioId);
        conversionDAO.guardar(conversion);
    }

    public List<Conversion> listar(TipoConversion tipoConversion) {
        return conversionDAO.listar(tipoConversion);
    }
public String MetodoCalcularMonedas(boolean op, Conversion conversion, double cantidad, int sele){

    double resultado;
    double val1 = conversion.getValor1();
    double val2 = conversion.getValor2();
    if (op){
        resultado= cantidad / val1;
    }else {
        resultado= cantidad * val1;
    }
    return String.valueOf(resultado);
}
    public String MetodoCalcularTemperaturas(boolean op, Conversion conversion, double cantidad,int sele){

        double val1 = conversion.getValor1();
        double val2 = conversion.getValor2();

        if (conversion.getCambio1().equals("Celsius") && conversion.getCambio2().equals("Fahrenheit")){ // Celsius --> Fahrenheit
            //Celsius	Fahrenheit	0,	32
            if (op){
                return String.valueOf((cantidad * (9/5))+val2);
            }else {
                return String.valueOf((cantidad - val2)*5/9);
            }
        }else if(conversion.getCambio1().equals("Celsius") && conversion.getCambio2().equals("Kelvin")){ // Celsius --> Kelvin
            //'Celsius', 'Kelvin', '0', '273.15',
            if (op){
                return String.valueOf(cantidad + val2);
            }else {
                return String.valueOf(cantidad - val2);
            }
        } else if (conversion.getCambio1().equals("Fahrenheit") && conversion.getCambio2().equals("Kelvin")) { // Fahrenheit --> Kelvin
            //Fahrenheit	Kelvin	32	273.15
            if (op){
                return String.valueOf((((cantidad - val1) * 5) / 9) + val2);
            }else {
                return String.valueOf((((cantidad - val2) * 9) / 5) + val1);
            }
        }else return "Vacio";

    }

    public String MetodoCalcularMedidas(boolean op, Conversion conversion, double cantidad, int sele){
       // '7', 'Kilómetro', 'Metro', '1', '1000', '3'
        //'8', 'Kilómetro', 'Milla', '1', '0.621371', '3'
        //'9', 'Metro', 'Milla', '1', '0.000621371', '3'
        double resultado;
        double val1 = conversion.getValor1();
        double val2 = conversion.getValor2();

        if (conversion.getCambio1().equals("Kilómetro") && conversion.getCambio2().equals("Metro")){ // Celsius --> Fahrenheit
            //Celsius	Fahrenheit	0,	32
            if (op){
                return String.valueOf((cantidad * val2));
            }else {
                return String.valueOf((0.001/cantidad));
            }
        }else if(conversion.getCambio1().equals("Kilómetro") && conversion.getCambio2().equals("Milla")){ // Celsius --> Kelvin
            //'Celsius', 'Kelvin', '0', '273.15',
            if (op){
                return String.valueOf(cantidad /1.609);
            }else {
                return String.valueOf(cantidad * 1.609);
            }
        } else if (conversion.getCambio1().equals("Metro") && conversion.getCambio2().equals("Milla")) { // Fahrenheit --> Kelvin
            //Fahrenheit	Kelvin	32	273.15
            if (op){
                return String.valueOf(cantidad / 1609);
            }else {
                return String.valueOf(cantidad * 1609);
            }
        }else return "Vacio";
    }


}
