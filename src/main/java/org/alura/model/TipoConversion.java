package org.alura.model;

import java.util.ArrayList;
import java.util.List;

public class TipoConversion {
    private Integer id;
    private String nombre;
    private String descripcion;
    private List<Conversion> conversions = new ArrayList<>();

    public TipoConversion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoConversion(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Conversion> getConversions() {
        return this.conversions;
    }

    public void agregar(Conversion conversion) {
        this.conversions.add(conversion);
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
