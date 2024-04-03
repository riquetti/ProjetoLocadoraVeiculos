/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoLocadoraVeiculos.dao;

import ProjetoLocadoraVeiculos.Conexao;
import ProjetoLocadoraVeiculos.entity.Estado;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riquetti
 */
public class EstadoDAO {
    public List<Estado> select() {
        List<Estado> listaEstado = new ArrayList<>();
        String query = String.format("""
                       SELECT * FROM estado;
                       """);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId_estado(rs.getInt("id_estado"));
                estado.setDescricao(rs.getString("descricao"));
                estado.setSigla(rs.getString("sigla"));
                

                listaEstado.add(estado);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaEstado;
    }
    
    public Estado select(int id) {
        String query = String.format("""
                       SELECT * FROM estado WHERE id = %d;
                       """, id);

        try (Statement stmt = Conexao.getConn().createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                Estado estado = new Estado();
                estado.setId_estado(rs.getInt("id_estado"));
                estado.setDescricao(rs.getString("descricao"));
                estado.setSigla(rs.getString("sigla"));
                

                return estado;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
