package org.alura.dao;


import org.alura.model.Conversion;
import org.alura.model.TipoConversion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoConversionDAO {
    private Connection con;
    public TipoConversionDAO(Connection con) {
        this.con = con;
    }
    public List<TipoConversion> listar() {
        List<TipoConversion> resultado = new ArrayList<>();

        try {
            String sql = "SELECT ID, NOMBRE,DESCRIPCION FROM TIPOCONVERSION";

            System.out.println(sql);

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new TipoConversion(
                                resultSet.getInt("ID"),
                                resultSet.getString("NOMBRE"),
                                resultSet.getString("DESCRIPCION")));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public List<TipoConversion> listarConConversion() {
        List<TipoConversion> resultado = new ArrayList<>();

        try {
            String sql = "SELECT T.ID, T.NOMBRE,T.DESCRIPCION, C.ID, C.CAMBIO1,C.CAMBIO,C.VALOR1, C.VALOR2"
                    + " FROM TIPOCONVERSION T INNER JOIN CONVERSOR C "
                    + " ON T.ID = C.TIPOCONVERSION_ID";

            System.out.println(sql);

            final PreparedStatement statement = con
                    .prepareStatement(sql);

            try (statement) {
                final ResultSet resultSet = statement.executeQuery();

                try (resultSet) {
                    while (resultSet.next()) {
                        int TipoConversionId = resultSet.getInt("T.ID");
                        String TipoConversionNombre = resultSet.getString("T.NOMBRE");

                        TipoConversion tipoConversion = resultado
                                .stream()
                                .filter(tipo -> tipo.getId().equals(TipoConversionId))
                                .findAny().orElseGet(() -> {
                                    TipoConversion tipo = new TipoConversion(
                                            TipoConversionId, TipoConversionNombre);
                                    resultado.add(tipo);

                                    return tipo;
                                });

                        Conversion conversion = new Conversion(
                                resultSet.getInt("C.ID"),
                                resultSet.getString("C.CAMBIO1"),
                                resultSet.getString("C.CAMBIO2"),
                                resultSet.getDouble("C.VALOR1"),
                                resultSet.getDouble("C.VALOR2")
                        );

                        tipoConversion.agregar(conversion);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

}
