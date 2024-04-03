/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.ClienteTelefone;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class ClienteTelefoneDAO {
    public List<ClienteTelefone> select() {
        List<ClienteTelefone> listaClienteTelefone = new ArrayList<>();
        String query = String.format("""
                       SELECT * FROM clientetelefone;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ClienteTelefone clienteTelefone = new ClienteTelefone();
                clienteTelefone.setId_telefone(rs.getInt("id_telefone"));
                clienteTelefone.setId_cliente(rs.getInt("id_cliente"));
                clienteTelefone.setTelefone(rs.getString("telefone"));
                
                listaClienteTelefone.add(clienteTelefone);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaClienteTelefone;
    }

    public ClienteTelefone select(int id) {
        String query = String.format("""
                       SELECT * FROM clientetelefone WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                ClienteTelefone clienteTelefone = new ClienteTelefone();
                clienteTelefone.setId_telefone(rs.getInt("id_telefone"));
                clienteTelefone.setId_cliente(rs.getInt("id_cliente"));
                clienteTelefone.setTelefone(rs.getString("telefone"));

                return clienteTelefone;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
