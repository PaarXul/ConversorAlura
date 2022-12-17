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

}
