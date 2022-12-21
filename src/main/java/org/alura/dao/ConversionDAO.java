package org.alura.dao;

import org.alura.model.Conversion;
import org.alura.model.TipoConversion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConversionDAO {
    private Connection con;

    public ConversionDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Conversion conversion) {
        try {
            PreparedStatement statement;
            statement = con.prepareStatement(
                    "INSERT INTO CONVERSION "
                            + "(CAMBIO1, CAMBIO2, VALOR1,VALOR2, TIPOCONVERSION_ID)"
                            + " VALUES (?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setString(1, conversion.getCambio1());
                statement.setString(2, conversion.getCambio2());
                statement.setDouble(3, conversion.getValor1());
                statement.setDouble(4, conversion.getValor2());
                statement.setInt(5, conversion.getTipoConversionId());

                statement.execute();

                final ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        conversion.setId(resultSet.getInt(1));

                        System.out.println(String.format("Fue insertado el conversion: %s", conversion));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conversion> listar() {
        List<Conversion> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con
                    .prepareStatement("SELECT ID, CAMBIO1, CAMBIO2, VALOR1,VALOR2 FROM CONVERSION");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Conversion(
                                resultSet.getInt("ID"),
                                resultSet.getString("CAMBIO1"),
                                resultSet.getString("CAMBIO2"),
                                resultSet.getDouble("VALOR1"),
                                resultSet.getDouble("VALOR1")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int eliminar(Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement("DELETE FROM CONVERSION WHERE ID = ?");

            try (statement) {
                statement.setInt(1, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int modificar(String CAMBIO1, String CAMBIO2, double VALOR1, double VALOR2,Integer id) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "UPDATE CONVERSION SET "
                            + " CAMBIO1 = ?, "
                            + " CAMBIO2 = ?,"
                            + " VALO1 = ?,"
                            + " VALO2 = ?"
                            + " WHERE ID = ?");

            try (statement) {
                statement.setString(1, CAMBIO1);
                statement.setString(2, CAMBIO2);
                statement.setDouble(3, VALOR1);
                statement.setDouble(4, VALOR2);
                statement.setInt(5, id);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Conversion> listar(TipoConversion tipoConversion) {
        List<Conversion> resultado = new ArrayList<>();

        try {
            String sql = "SELECT ID, CAMBIO1, CAMBIO2, VALOR1,VALOR2 "
                    + " FROM CONVERSION WHERE TIPOCONVERSION_ID = ?";
            System.out.println(sql);

            final PreparedStatement statement = con.prepareStatement(
                    sql);

            try (statement) {
                statement.setInt(1, tipoConversion.getId());
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        resultado.add(new Conversion(
                                resultSet.getInt("ID"),
                                resultSet.getString("CAMBIO1"),
                                resultSet.getString("CAMBIO2"),
                                resultSet.getDouble("VALOR1"),
                                resultSet.getDouble("VALOR2")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }
}
