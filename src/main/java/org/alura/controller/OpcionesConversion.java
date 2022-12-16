package org.alura.controller;

import org.alura.model.Conversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OpcionesConversion {
    public List<Conversiones> ListaConversiones(){

         List<Conversiones> NombreConversion=  new ArrayList<>();
         NombreConversion.add(new Conversiones(1,"Monedas","Convertidor de Monedas"));
         NombreConversion.add(new Conversiones(2,"Temperaturas","Convertidor de Temperaturas"));

        return NombreConversion;
    }
}
