package org.alura.controller;

import org.alura.dao.TipoConversionDAO;
import org.alura.factory.ConnectionFactory;
import org.alura.model.TipoConversion;

import java.util.ArrayList;
import java.util.List;

public class TipoConversionController {
    private TipoConversionDAO tipoConversionDAO;

    public TipoConversionController(){
        var factory = new ConnectionFactory();
        this.tipoConversionDAO = new TipoConversionDAO(factory.recuperaConexion());
    }
    public List<TipoConversion> listar() {
        return tipoConversionDAO.listar();
    }
}
