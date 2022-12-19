package org.alura.model;

import java.util.ArrayList;
import java.util.List;

public class Conversion {
    private Integer id;
    private String cambio1;
    private String cambio2;
    private double Valor1;
    private double valor2;
    private Integer TipoConversionId;

    public Conversion(String cambio1, String cambio2) {
        this.cambio1 = cambio1;
        this.cambio2 = cambio2;
    }

    public Conversion(String cambio1, String cambio2, double valor1, double valor2) {
        this.cambio1 = cambio1;
        this.cambio2 = cambio2;
        Valor1 = valor1;
        this.valor2 = valor2;
    }

    public Conversion(Integer id, String cambio1, String cambio2, double valor1, double valor2) {
        this.id = id;
        this.cambio1 = cambio1;
        this.cambio2 = cambio2;
        Valor1 = valor1;
        this.valor2 = valor2;
    }

    public Conversion(Integer id, String cambio1, String cambio2, double valor1, double valor2, Integer tipoConversionId) {
        this.id = id;
        this.cambio1 = cambio1;
        this.cambio2 = cambio2;
        Valor1 = valor1;
        this.valor2 = valor2;
        TipoConversionId = tipoConversionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCambio1() {
        return cambio1;
    }

    public void setCambio1(String cambio1) {
        this.cambio1 = cambio1;
    }

    public String getCambio2() {
        return cambio2;
    }

    public void setCambio2(String cambio2) {
        this.cambio2 = cambio2;
    }

    public double getValor1() {
        return Valor1;
    }

    public void setValor1(double valor1) {
        Valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public Integer getTipoConversionId() {
        return TipoConversionId;
    }

    public void setTipoConversionId(Integer tipoConversionId) {
        TipoConversionId = tipoConversionId;
    }

    @Override
    public String toString() {
        return String.format(
                "%s a %s",
                this.cambio1, this.cambio2);
    }
}
