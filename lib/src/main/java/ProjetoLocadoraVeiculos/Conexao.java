/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riquetti
 */
public class Conexao {

    private static Connection conn;

    public static void iniciarBanco(String host, String porta, String banco,
            String usuario, String senha) {

        try {
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":" + porta + "/" + banco,
                    usuario,
                    senha);
        } catch (SQLException ex) {
            throw new RuntimeException("Não foi possível se conectar com o banco de dados.", ex);
        }

    }

    public static Connection getConn() {
        return conn;
    }
}
